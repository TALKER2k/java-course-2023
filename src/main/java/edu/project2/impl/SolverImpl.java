package edu.project2.impl;

import edu.project2.interfaces.Solver;
import edu.project2.models.Cell;
import edu.project2.models.Coordinate;
import edu.project2.models.Maze;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SolverImpl implements Solver {
    //поиск в ширину
    public List<Coordinate> bfs(Coordinate s, Coordinate t, Maze maze) {
        int height = maze.height();
        int width = maze.width();
        boolean[][] isFreeCell = new boolean[height][width];
        int[][] shortestPath = new int[height][width];
        Coordinate[][] parent = new Coordinate[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                isFreeCell[i][j] = maze.grid()[i][j].getType() != Cell.Type.WALL;
                shortestPath[i][j] = Integer.MAX_VALUE;
            }
        }

        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(s);
        shortestPath[s.row()][s.col()] = 0;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();

            if (current.equals(t)) {
                break;
            }
            final int four = 4;
            for (int i = 0; i < four; i++) {
                int edgeRow = current.row() + dx[i];
                int edgeCol = current.col() + dy[i];

                if (edgeRow >= 0 && edgeCol >= 0 && edgeRow < height && edgeCol < width
                        && isFreeCell[edgeRow][edgeCol] && shortestPath[edgeRow][edgeCol] == Integer.MAX_VALUE) {
                    queue.add(new Coordinate(edgeRow, edgeCol));
                    shortestPath[edgeRow][edgeCol] = shortestPath[current.row()][current.col()] + 1;
                    parent[edgeRow][edgeCol] = current;
                }
            }
        }

        if (shortestPath[t.row()][t.col()] == Integer.MAX_VALUE) {
            return null; // Путь не найден
        }

        List<Coordinate> shortPath = new ArrayList<>();
        Coordinate current = t;

        while (!current.equals(s)) {
            shortPath.add(current);
            current = parent[current.row()][current.col()];
        }

        shortPath.add(s); // Добавляем начальную точку

        Collections.reverse(shortPath); // Переворачиваем путь, чтобы начинать с s

        return shortPath;
    }


    @Override
    public List<Coordinate> solve(Maze maze, Coordinate start, Coordinate end) {
        return bfs(start, end, maze);
    }
}

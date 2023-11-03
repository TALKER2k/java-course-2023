package edu.project2.impl;

import edu.project2.interfaces.Solver;
import edu.project2.models.Cell;
import edu.project2.models.Coordinate;
import edu.project2.models.Maze;

import java.util.*;
import java.util.stream.Collectors;

public class SolverImpl implements Solver {
    private LinkedList<Coordinate> adjLists[];
    int height = 25;
    int width = 35;
    List<Coordinate> visited = new ArrayList<>();

    boolean DFS(int row, int col, int endRow, int endCol, Maze maze) {
        Coordinate currentCoordinate = new Coordinate(row, col);

        if (row < 0 || row >= height || col < 0 || col >= width || visited.contains(currentCoordinate)
                || maze.grid()[row][col].getType() == Cell.Type.WALL) {
            return false;
        }

        visited.add(currentCoordinate);

        if (row == endRow && col == endCol) {
            return true;
        }

        if (DFS(row, col - 1, endRow, endCol, maze) ||
                DFS(row, col + 1, endRow, endCol, maze) ||
                DFS(row + 1, col, endRow, endCol, maze) ||
                DFS(row - 1, col, endRow, endCol, maze)) {
            return true;
        }

        return false;
    }



    void findPath(int startRow, int startCol, int endRow, int endCol, Maze maze) {
        if (DFS(startRow, startCol, endRow, endCol, maze)) {
            System.out.println("Путь найден.");
        } else {
            System.out.println("Путь не найден.");
        }
    }

    @Override
    public List<Coordinate> solve(Maze maze, Coordinate start, Coordinate end) {
        findPath(start.row(), start.col(), end.row(), end.col(), maze);
        System.out.println(visited.size());
        return visited;
    }
}

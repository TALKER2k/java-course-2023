package edu.project2.impl;

import edu.project2.interfaces.Renderer;
import edu.project2.models.Cell;
import edu.project2.models.Coordinate;
import edu.project2.models.Maze;
import java.util.ArrayList;
import java.util.List;

public class RenderImpl implements Renderer {
    @Override
    public StringBuilder render(Maze maze) {
        StringBuilder outputMaze = new StringBuilder();
        for (int i = 0; i < maze.height(); i++) {
            for (int j = 0; j < maze.width(); j++) {
                if (maze.grid()[i][j].getType() == Cell.Type.WALL) {
                    outputMaze.append("▉");
                } else if (maze.grid()[i][j].getType() == Cell.Type.PATH) {
                    outputMaze.append("*");
                } else {
                    outputMaze.append(" ");
                }
                outputMaze.append(" ");
            }
            outputMaze.append("\n");
        }
        return outputMaze;
    }

    @Override
    public StringBuilder render(Maze maze, List<Coordinate> path) {
        List<String> outputMaze = new ArrayList<>();
        for (Coordinate coordinate : path) {
            outputMaze.add(coordinate.row() + "," + coordinate.col());
        }

        Maze mazeExp = new Maze(maze.height(), maze.width(), maze.grid());

        int k = 0;
        for (int i = 0; i < maze.height(); i++) {
            for (int j = 0; j < maze.width(); j++) {
                if (k == path.size()) {
                    k--;
                }

                if (outputMaze.contains(i + "," + j)) {
                    mazeExp.grid()[i][j].setType(Cell.Type.PATH);
                }
                k++;
            }
        }

        return render(mazeExp);
    }
}

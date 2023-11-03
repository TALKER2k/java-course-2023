package edu.project2.impl;

import edu.project2.models.Cell;
import edu.project2.interfaces.Generator;
import edu.project2.models.Maze;

import java.util.Random;
import java.util.Stack;

public class GeneratorImpl implements Generator {
    private final int height;
    private final int width;
    private final Cell[][] grid;

    public GeneratorImpl(int height, int width) {
        this.height = height;
        this.width = width;
        this.grid = new Cell[height][width];
        initializeGrid();
        generateMaze();
    }

    private void initializeGrid() {
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                grid[row][col] = new Cell(row, col, Cell.Type.WALL);
            }
        }
    }

    private void generateMaze() {
        Random random = new Random();
        Stack<Cell> stack = new Stack<>();
        Cell startCell = grid[1][1];
        startCell.setType(Cell.Type.PASSAGE);
        stack.push(startCell);

        while (!stack.isEmpty()) {
            Cell currentCell = stack.peek();
            int row = currentCell.getRow();
            int col = currentCell.getCol();
            Cell[] neighbors = getUnvisitedNeighbors(row, col);
            if (neighbors.length == 0) {
                stack.pop();
            } else {
                Cell neighbor = neighbors[random.nextInt(neighbors.length)];
                int nRow = neighbor.getRow();
                int nCol = neighbor.getCol();
                int diffRow = nRow - row;
                int diffCol = nCol - col;
                grid[row + diffRow / 2][col + diffCol / 2].setType(Cell.Type.PASSAGE);
                neighbor.setType(Cell.Type.PASSAGE);
                stack.push(neighbor);
            }
        }
    }

    private Cell[] getUnvisitedNeighbors(int row, int col) {
        Cell[] neighbors = new Cell[4];
        int count = 0;
        if (row >= 2 && grid[row - 2][col].getType() == Cell.Type.WALL) {
            neighbors[count++] = grid[row - 2][col];
        }
        if (row < height - 2 && grid[row + 2][col].getType() == Cell.Type.WALL) {
            neighbors[count++] = grid[row + 2][col];
        }
        if (col >= 2 && grid[row][col - 2].getType() == Cell.Type.WALL) {
            neighbors[count++] = grid[row][col - 2];
        }
        if (col < width - 2 && grid[row][col + 2].getType() == Cell.Type.WALL) {
            neighbors[count++] = grid[row][col + 2];
        }
        return count > 0 ? java.util.Arrays.copyOf(neighbors, count) : new Cell[0];
    }

    @Override
    public Maze generate(int height, int width) {
        return new Maze(height, width, grid);
    }
}

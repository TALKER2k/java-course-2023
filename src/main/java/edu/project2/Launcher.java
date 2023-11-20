package edu.project2;

import edu.project2.impl.GeneratorImpl;
import edu.project2.impl.RenderImpl;
import edu.project2.impl.SolverImpl;
import edu.project2.interfaces.Generator;
import edu.project2.interfaces.Renderer;
import edu.project2.interfaces.Solver;
import edu.project2.models.Cell;
import edu.project2.models.Coordinate;
import edu.project2.models.Maze;
import java.util.List;
import java.util.Random;

public class Launcher {
    public static final int HEIGHT = 35;
    public static final int WIDTH = 55;
    Maze maze;
    Generator generator = new GeneratorImpl(HEIGHT, WIDTH);
    Renderer renderer = new RenderImpl();
    Solver solver = new SolverImpl();
    Random random = new Random();

    @SuppressWarnings("checkstyle:RegexpSinglelineJava")
    public void run() {
        maze = generator.generate(HEIGHT, WIDTH);
        System.out.println(renderer.render(maze));
        List<Coordinate> listCoordinate = solver.solve(maze, generateCoordinate(maze), generateCoordinate(maze));
        System.out.println(renderer.render(maze, listCoordinate));
    }

    private Coordinate generateCoordinate(Maze maze) {
        final int x = random.nextInt(HEIGHT);
        final int y = random.nextInt(WIDTH);
        return (maze.grid()[x][y].getType() == Cell.Type.PASSAGE ? new Coordinate(x, y) : generateCoordinate(maze));
    }
}

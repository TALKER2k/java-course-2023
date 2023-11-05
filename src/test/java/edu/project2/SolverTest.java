package edu.project2;

import edu.project2.impl.GeneratorImpl;
import edu.project2.impl.SolverImpl;
import edu.project2.interfaces.Generator;
import edu.project2.interfaces.Solver;
import edu.project2.models.Coordinate;
import edu.project2.models.Maze;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SolverTest {
    Solver solver = new SolverImpl();

    @BeforeEach
    void initSolver() {
        solver = new SolverImpl();
    }

    @Test
    void solveTest() {
        Generator generator = new GeneratorImpl(3, 3);
        Maze maze = generator.generate(3, 3);

        List<Coordinate> coordinateList = solver.solve(maze, new Coordinate(1, 1), new Coordinate(1, 1));

        assertThat(coordinateList).isEqualTo(List.of(new Coordinate(1, 1)));
    }
}

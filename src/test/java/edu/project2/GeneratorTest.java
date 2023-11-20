package edu.project2;

import edu.project2.impl.GeneratorImpl;
import edu.project2.interfaces.Generator;
import edu.project2.models.Cell;
import edu.project2.models.Maze;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class GeneratorTest {
    private Generator generator;

    @BeforeEach
    void initGenerator() {
        generator = new GeneratorImpl(Launcher.HEIGHT, Launcher.WIDTH);
    }

    @Test
    void generateMazeTest() {
        Maze maze = generator.generate(Launcher.HEIGHT, Launcher.WIDTH);
        boolean isWall = true;

        for (int i = 0; i < Launcher.HEIGHT; i++) {
            if (maze.grid()[i][0].getType() != Cell.Type.WALL) {
                isWall = false;
            }
            if (maze.grid()[i][Launcher.WIDTH - 1].getType() != Cell.Type.WALL) {
                isWall = false;
            }
        }

        for (int i = 0; i < Launcher.WIDTH; i++) {
            if (maze.grid()[0][i].getType() != Cell.Type.WALL) {
                isWall = false;
            }
            if (maze.grid()[Launcher.HEIGHT - 1][i].getType() != Cell.Type.WALL) {
                isWall = false;
            }
        }

        assertThat(isWall).isTrue();
    }
}

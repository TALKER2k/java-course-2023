package edu.project2;

import edu.project2.impl.GeneratorImpl;
import edu.project2.impl.RenderImpl;
import edu.project2.interfaces.Generator;
import edu.project2.interfaces.Renderer;
import edu.project2.models.Maze;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class RenderTest {
    private Renderer renderer;

    @BeforeEach
    void initRenderer() {
        renderer = new RenderImpl();
    }

    @Test
    void renderTest() {
        Generator generator = new GeneratorImpl(Launcher.HEIGHT, Launcher.WIDTH);
        Maze maze = generator.generate(Launcher.HEIGHT, Launcher.WIDTH);

        StringBuilder rendererResultWithoutPath = renderer.render(maze);
        StringBuilder rendererResultWithPath = renderer.render(maze, List.of());

        assertThat(rendererResultWithoutPath.toString()).isEqualTo(rendererResultWithPath.toString());
    }
}

package edu.hw3;

import java.util.TreeMap;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7Test {
    Task7 comparator = new Task7();

    @Test
    void treeWithNullKeyTest() {
        TreeMap<String, String> tree = new TreeMap<>(comparator);

        tree.put(null, "test");

        assertThat(tree.containsKey(null)).isTrue();
    }
}

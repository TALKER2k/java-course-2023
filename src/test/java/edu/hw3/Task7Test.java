package edu.hw3;

import java.util.TreeMap;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7Test {
    Task7 comparator = new Task7();

    @Test
    void treeWithNullKeyTest() {
        TreeMap<String, String> tree = new TreeMap<>(comparator);

        tree.put(null, "test1");
        tree.put("4", "test4");
        tree.put(null, "test2");
        tree.put(null, "test3");

        assertThat(tree.containsKey(null)).isTrue();
    }
}

package edu.project1;

import java.util.List;
import java.util.Random;

public final class ListUtils {
    private ListUtils() {
    }

    public static String randomWord(List<String> list) {
        return list.get(new Random().nextInt(list.size()));
    }
}

package edu.hw3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Task3 {
    private Task3() {}

    public static <T> Map<T, Integer> freqDict(List<T> inputListString) {
        Map<T, Integer> frequencyResult = new HashMap<>();
        for (T listElem : inputListString) {
            frequencyResult.put(listElem, frequencyResult.getOrDefault(listElem, 0) + 1);
        }
        return frequencyResult;
    }
}

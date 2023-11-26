package edu.hw7;

import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public long factorial(int number) {
        List<Long> list = new ArrayList<>();
        for (long i = 1; i <= number; i++) {
            list.add(i);
        }

        return list.parallelStream()
                .reduce(1L, (a, b) -> a * b);
    }
}

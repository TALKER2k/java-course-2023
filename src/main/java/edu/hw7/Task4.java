package edu.hw7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;

public class Task4 {

    private static final double FOUR = 4.0;

    public static class MonteCarloPi {

        public static double calculatePi(int iterations) {
            int circleCount = 0;
            for (int i = 0; i < iterations; i++) {
                double x = ThreadLocalRandom.current().nextDouble(0, 1);
                double y = ThreadLocalRandom.current().nextDouble(0, 1);
                if (isInsideCircle(x, y)) {
                    circleCount++;
                }
            }

            return FOUR * circleCount / iterations;
        }

        private static boolean isInsideCircle(double x, double y) {
            return x * x + y * y <= 1;
        }

    }

    public static class MonteCarloPiMultiThreaded {

        public static double calculatePi(int iterations, int numThreads) throws Exception {
            int totalCircleCount;
            try (ExecutorService executorService = Executors.newFixedThreadPool(numThreads)) {
                int iterationsPerThread = iterations / numThreads;
                Future<Integer>[] futures = new Future[numThreads];

                for (int i = 0; i < numThreads; i++) {
                    futures[i] = executorService.submit(() -> simulatePoints(iterationsPerThread));
                }

                totalCircleCount = 0;
                for (int i = 0; i < numThreads; i++) {
                    totalCircleCount += futures[i].get();
                }

                executorService.shutdown();
            }

            return FOUR * totalCircleCount / iterations;
        }

        private static int simulatePoints(int iterations) {
            int circleCount = 0;
            for (int i = 0; i < iterations; i++) {
                double x = ThreadLocalRandom.current().nextDouble(-1, 1);
                double y = ThreadLocalRandom.current().nextDouble(-1, 1);

                if (isInsideCircle(x, y)) {
                    circleCount++;
                }
            }
            return circleCount;
        }

        private static boolean isInsideCircle(double x, double y) {
            return x * x + y * y <= 1;
        }
    }
}

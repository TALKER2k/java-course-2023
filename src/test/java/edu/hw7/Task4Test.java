package edu.hw7;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task4Test {

    @Test
    public void testCalculatePi() {
        int iterations = 10_000_000;
        double piApproximation = Task4.MonteCarloPi.calculatePi(iterations);

        assertTrue(piApproximation >= 3 && piApproximation <= 4);

        assertErrorTolerance(iterations, 0.01);
        assertErrorTolerance(100_000_000, 0.001);
        assertErrorTolerance(1_000_000_000, 0.0001);
    }

    private void assertErrorTolerance(int iterations, double tolerance) {
        double piApproximation = Task4.MonteCarloPi.calculatePi(iterations);
        double error = Math.abs(piApproximation - Math.PI);

        System.out.println("Approximation of Pi with " + iterations + " iterations: " + piApproximation);
        System.out.println("Error: " + error);
        System.out.println("======================================================================");

        assertTrue(error <= tolerance, "Error exceeds tolerance: " + error);
    }

    @ParameterizedTest
    @CsvSource({"1,100000", "2,100000", "3,100000", "4,100000", "5,100000", "6,100000", "7,100000", "8,100000",
            "3,1000", "1,1000000", "2,1000000", "12,1000000", "1,30000000", "2,30000000",
            "12,30000000"})
    public void testCalculatePiMulti(int numThreads, int numIterations) throws Exception {
        long startTime = System.nanoTime();

        double multiThreadedPi = Task4.MonteCarloPiMultiThreaded.calculatePi(numIterations, numThreads);

        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;

        System.out.println("Approximation of Pi with " + numIterations + " iterations: " + multiThreadedPi);
        System.out.println("Threads: " + numThreads + ", Elapsed Time: " + elapsedTime + " ns");
        System.out.println("=============================================================================");

        assertTrue(multiThreadedPi >= 3 && multiThreadedPi <= 3.5);
    }

}

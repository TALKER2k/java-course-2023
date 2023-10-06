package edu.hw1;

public final class Task7 {
    private Task7() {}

    public static int rotateRight(int n, int shift) {
        int bits = Integer.SIZE;
        return (n >>> shift) | (n << (bits - shift));
    }

    public static int rotateLeft(int n, int shift) {
        final int bits = 5;
        int mask = (1 << bits) - 1;
        return ((n << shift) | (n >>> (bits - shift))) & mask;
    }
}

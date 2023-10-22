package edu.hw2;

public final class Task2 {
    private Task2() {}

    public static class Rectangle {
        private int width;
        private int height;

        public Rectangle() {}

        public Rectangle(int width, int height) {
            this.width = width;
            this.height = height;
        }

        public Rectangle setHeight(int height) {
            return new Rectangle(width, height);
        }

        public Rectangle setWidth(int width) {
            return new Rectangle(width, height);
        }

        double area() {
            return width * height;
        }
    }

    public static class Square extends Rectangle {
        public Square() {}
    }
}

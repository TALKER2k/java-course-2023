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

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }

        double area() {
            return width * height;
        }
    }

    public static class Square extends Rectangle {
        public Square() {}

        @Override
        public Rectangle setHeight(int height) {
            return new Rectangle(getWidth(), height);
        }

        @Override
        public Rectangle setWidth(int width) {
            return new Rectangle(width, getHeight());
        }
    }
}

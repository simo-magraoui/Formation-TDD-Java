package com.example;

public class Rectangle {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int calculatePerimeter() {
        return 2 * (width + height);
    }

    public int calculateArea() {
        return width * height;
    }

}

package edu.hw2.task2;

public class Rectangle {
    private int width;
    private int height;

    public void setWidth(int width) throws Exception {
        this.width = width;
    }

    public void setHeight(int height) throws Exception {
        this.height = height;
    }

    public double area() {
        return width * height;
    }
}

package edu.hw2;

import edu.hw2.task2.Rectangle;
import edu.hw2.task2.Square;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Test {
    Rectangle rectangle = new Rectangle(10, 15);
    Square square = new Square(10);

    @Test
    void rectangleTest() {
        Rectangle anotherRectangle = rectangle.setWidth(20);
        Rectangle oneMoreRectangle = anotherRectangle.setHeight(30);
        assertEquals(600, oneMoreRectangle.area());
    }

    @Test
    void squareTest() {
        Square anotherSquare = square.setSize(20);
        assertEquals(400, anotherSquare.area());

    }

    @Test
    void squareAsRectangleTest() {
        Rectangle anotherRectangle = square.setWidth(20);
        Rectangle oneMoreRectangle = anotherRectangle.setHeight(10);
        assertEquals(200, oneMoreRectangle.area());

    }

}

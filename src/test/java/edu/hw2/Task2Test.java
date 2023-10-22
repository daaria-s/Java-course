package edu.hw2;

import edu.hw2.task2.Rectangle;
import edu.hw2.task2.Square;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Test {

    Rectangle rectangle = new Rectangle();
    Square square = new Square();

    @Test
    void rectangleTest() throws Exception {
        rectangle.setWidth(10);
        rectangle.setHeight(20);
        assertEquals(200, rectangle.area());
    }

    @Test
    void squareTest() throws Exception {
        square.setSize(40);
        assertEquals(1600, square.area());
    }

    @Test
    void squareAsRectangleTest() {
        try {
            square.setWidth(7);
        } catch (Exception exception) {
            assertEquals("Trying to change width in square", exception.getMessage());
        }

        try {
            square.setHeight(13);
        } catch (Exception exception) {
            assertEquals("Trying to change height in square", exception.getMessage());
        }
    }

}

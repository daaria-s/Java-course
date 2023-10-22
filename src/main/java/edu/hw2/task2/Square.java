package edu.hw2.task2;

public class Square extends Rectangle {
    @Override public void setWidth(int width) throws Exception {
        throw new Exception("Trying to change width in square");
    }

    @Override
    public void setHeight(int height) throws Exception {
        throw new Exception("Trying to change height in square");

    }

    public void setSize(int size) throws Exception {
        super.setHeight(size);
        super.setWidth(size);

    }
}

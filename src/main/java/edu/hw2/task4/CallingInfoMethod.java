package edu.hw2.task4;

public class CallingInfoMethod {

    private CallingInfoMethod() {
    }

    public static CallingInfo callingInfo() {
        StackTraceElement[] trace = new Throwable().getStackTrace();
        return new CallingInfo(trace[1].getClassName(), trace[1].getMethodName());

    }
}

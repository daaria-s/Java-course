package edu.hw2.task4;

public class CallingInfoMethod {


    private CallingInfoMethod() {}

    public static CallingInfo callingInfo(Throwable e) {
        StackTraceElement[] trace = e.getStackTrace();
        return new CallingInfo(trace[0].getClassName(), trace[0].getMethodName());

    }
}

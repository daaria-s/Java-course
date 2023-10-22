package edu.hw2;

import edu.hw2.task4.CallingInfo;
import org.junit.jupiter.api.Test;
import static edu.hw2.task4.CallingInfoMethod.callingInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task4Test {

    void someFunction() throws Throwable {
        throw new Throwable();
    }

    @Test
    void callingInfoTest() {
        try {
            someFunction();
        } catch (Throwable e) {
            CallingInfo callingInfo = new CallingInfo("edu.hw2.Task4Test", "someFunction");
            assertEquals(callingInfo, callingInfo(e));
        }
    }

}

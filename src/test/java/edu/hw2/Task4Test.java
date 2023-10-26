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
        CallingInfo callingInfo = new CallingInfo("edu.hw2.Task4Test", "callingInfoTest");
        assertEquals(callingInfo, callingInfo());
    }

    @Test
    void callingInfoAnotherTest() {
        CallingInfo callingInfo = new CallingInfo("edu.hw2.Task4Test", "callingInfoAnotherTest");
        assertEquals(callingInfo, callingInfo());
    }

}

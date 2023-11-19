package edu.project3;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogReportTest {

    String title = "My title";
    String colTitle1 = "My coloumn title 1";
    String colTitle2 = "My coloumn title 2";
    ArrayList<Map.Entry<String, String>> data =
        new ArrayList<>(Arrays.asList(Map.entry("k1", "v1"), Map.entry("k2", "v2")));

    @Test
    void logReportConstructorTest() {

        LogReport myReport = new LogReport(title, colTitle1, colTitle2);
        assertEquals(title, myReport.title);
        assertEquals(colTitle1, myReport.keyTitle);
        assertEquals(colTitle2, myReport.valueTitle);
        assertTrue(myReport.data.isEmpty());

        LogReport myReport2 = new LogReport(title, colTitle1, colTitle2, data);
        assertEquals(title, myReport2.title);
        assertEquals(colTitle1, myReport2.keyTitle);
        assertEquals(colTitle2, myReport2.valueTitle);
        assertEquals(data, myReport2.data);
    }

    @Test
    void logReportAddInfoTest() {
        LogReport myReport = new LogReport(title, colTitle1, colTitle2, data);
        assertEquals(data, myReport.data);

        Map.Entry<String, String> newLine = Map.entry("some info", "another info");

        data.add(newLine);
        myReport.addInfo("some info", "another info");
        assertEquals(data, myReport.data);

    }
}

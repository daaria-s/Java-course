package edu.project3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LogReport {

    String title;
    String keyTitle;
    String valueTitle;
    ArrayList<Map.Entry<String, String>> data;

    public LogReport(String title, String keyTitle, String valueTitle) {
        this.title = title;
        this.keyTitle = keyTitle;
        this.valueTitle = valueTitle;
        this.data = new ArrayList<>();

    }

    public LogReport(String title, String keyTitle, String valueTitle, List<Map.Entry<String, String>> data) {
        this.title = title;
        this.keyTitle = keyTitle;
        this.valueTitle = valueTitle;
        this.data = new ArrayList<>(data);
    }

    public void addInfo(String key, String value) {
        data.add(Map.entry(key, value));
    }
}

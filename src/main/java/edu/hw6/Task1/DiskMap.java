package edu.hw6.Task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DiskMap implements Map<String, String> {

    HashMap<String, String> myMap = new HashMap<>();
    String myFileName;

    static final String DEFAULT_FILE_NAME = "diskMap";

    static final String TEXT_FILE = ".txt";

    public DiskMap(String fileName) {

        myFileName = fileName;
        if (!new File(fileName).exists()) {
            createFile(fileName);
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.ready()) {
                String[] mapElement = reader.readLine().split(":");
                myMap.put(mapElement[0], mapElement[1]);
            }
        } catch (IOException ignored) {
        }
    }

    public DiskMap() {
        createFile(generateFileName());
    }

    String generateFileName() {
        String name = DEFAULT_FILE_NAME + TEXT_FILE;
        int i = 1;
        while (new File(name).exists()) {
            name = DEFAULT_FILE_NAME + i + TEXT_FILE;
            i++;
        }
        return name;
    }

    @SuppressWarnings("RegexpSinglelineJava")
    void createFile(String fileName) {
        try {
            myFileName = fileName;
            File myFile = new File(myFileName);
            assert myFile.createNewFile();
        } catch (IOException ignored) {
            System.out.println("Can't create file");
        }

    }

    @SuppressWarnings("RegexpSinglelineJava")
    void updateFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(myFileName));

            for (Entry<String, String> entry : myMap.entrySet()) {
                writer.write(entry.getKey() + ":" + entry.getValue() + "\n");
            }

            writer.close();
        } catch (IOException ignored) {
            System.out.println("Can't write to file");

        }
    }

    @Override
    public int size() {
        return myMap.size();
    }

    @Override
    public boolean isEmpty() {
        return myMap.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return myMap.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return myMap.containsValue(value);
    }

    @Override
    public String get(Object key) {
        return myMap.get(key);
    }

    @Nullable
    @Override
    public String put(String key, String value) {
        String returnedVal = myMap.put(key, value);
        updateFile();
        return returnedVal;
    }

    @Override
    public String remove(Object key) {
        String returnedVal = myMap.remove(key);
        updateFile();
        return returnedVal;
    }

    @Override
    public void putAll(@NotNull Map<? extends String, ? extends String> m) {
        myMap.putAll(m);
        updateFile();
    }

    @Override
    public void clear() {
        myMap.clear();
        updateFile();
    }

    @NotNull
    @Override
    public Set<String> keySet() {
        Set<String> returnedVal = myMap.keySet();
        updateFile();
        return returnedVal;
    }

    @NotNull
    @Override
    public Collection<String> values() {
        return myMap.values();
    }

    @NotNull
    @Override
    public Set<Entry<String, String>> entrySet() {
        return myMap.entrySet();
    }
}

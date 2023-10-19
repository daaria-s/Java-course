package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public final class Task0 {
    private final static Logger LOGGER = LogManager.getLogger();

    private Task0() {
    }

    public static void helloWorld(String[] args) {
        LOGGER.info("Привет, мир!");

    }
}

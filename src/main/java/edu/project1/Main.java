package edu.project1;

import java.util.Objects;
import java.util.Scanner;

public final class Main {
    private static final String GIVE_UP_SIGN = "-1";

    private Main() {
    }

    private static Character parseString(String userString) {
        if (userString.length() == 1) {
            if (Character.isAlphabetic(userString.charAt(0))) {
                return userString.toLowerCase().charAt(0);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        Session session = new Session(new Dictionary().generateWord());

        Printer.welcomeMessage();

        while (true) {
            String userInput = myObj.nextLine();

            if (Objects.equals(userInput, GIVE_UP_SIGN)) {
                Printer.gameOver();
                break;
            }
            Character userChar = parseString(userInput);
            if (userChar == null) {
                Printer.badInput();
                continue;
            }
            if (session.attemptToGuess(userChar)) {
                Printer.hit();
            } else {
                Printer.missed(session.getAttempts(), session.getMaxAttempts());
            }
            Printer.printUserAnswer(session.getUserAnswer());
            GameStatus gameStatus = session.gameStatusCheck();
            if (gameStatus != GameStatus.IN_PROCESS) {
                Printer.gameResult(gameStatus);
                break;
            }

        }

    }
}

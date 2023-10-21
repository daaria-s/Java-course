package edu.project1;

import org.jetbrains.annotations.NotNull;

public class Printer {

    private Printer() {
    }

    @SuppressWarnings("RegexpSinglelineJava")
    public static void printUserAnswer(char @NotNull [] userAnswer) {
        System.out.print("The word: ");
        for (char elem : userAnswer) {
            System.out.print(elem);
        }
        System.out.println();
    }

    @SuppressWarnings("RegexpSinglelineJava")
    public static void welcomeMessage() {
        System.out.println("""
            Welcome to the game!
            Try to guess my word
            Enter a letter to guess or -1 to stop the game""");

    }

    @SuppressWarnings("RegexpSinglelineJava")
    public static void hit() {
        System.out.println("Hit!");
    }

    @SuppressWarnings("RegexpSinglelineJava")
    public static void missed(int currentAttempts, int maxAttempts) {
        System.out.printf("Missed! Misake %d out of %d", currentAttempts, maxAttempts);
    }

    @SuppressWarnings("RegexpSinglelineJava")
    public static void gameOver() {
        System.out.println("Game is over!");
    }

    @SuppressWarnings("RegexpSinglelineJava")
    public static void gameResult(GameStatus gameStatus) {
        if (gameStatus == GameStatus.WIN) {
            System.out.println("You win!");
        } else if (gameStatus == GameStatus.LOSE) {
            System.out.println("You lose!");
        }
        gameOver();
    }

    @SuppressWarnings("RegexpSinglelineJava")
    public static void badInput() {
        System.out.println("Bad input!");
    }

}

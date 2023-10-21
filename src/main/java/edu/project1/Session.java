package edu.project1;

import java.util.Arrays;

public class Session {

    private static final char UNKNOWN_LETTER_SYMBOL = '*';
    private final String answer;
    private final char[] userAnswer;
    private final int maxAttempts;
    private int attempts;

    private GameStatus gameStatus;

    public Session(String answer) {
        this.answer = answer;
        int answerLenght = answer.length();
        this.userAnswer = new char[answerLenght];
        Arrays.fill(this.userAnswer, UNKNOWN_LETTER_SYMBOL);
        this.maxAttempts = answerLenght;
        this.attempts = 0;
        this.gameStatus = GameStatus.IN_PROCESS;
    }

    char[] getUserAnswer() {
        return userAnswer;
    }

    int getAttempts() {
        return attempts;
    }

    int getMaxAttempts() {
        return maxAttempts;
    }

    public boolean attemptToGuess(char symbol) {
        boolean guessed = false;
        for (int i = 0; i < answer.length(); i++) {
            if (userAnswer[i] == UNKNOWN_LETTER_SYMBOL && answer.charAt(i) == symbol) {
                guessed = true;
                userAnswer[i] = symbol;
            }
        }
        if (!guessed) {
            attempts++;
        }
        return guessed;
    }

    public GameStatus gameStatusCheck() {
        if (isAllGuessed()) {
            gameStatus = GameStatus.WIN;
        } else if (!(attempts < maxAttempts)) {
            gameStatus = GameStatus.LOSE;
        }
        return gameStatus;
    }

    private boolean isAllGuessed() {
        for (char elem : userAnswer) {
            if (elem == UNKNOWN_LETTER_SYMBOL) {
                return false;
            }
        }
        return true;
    }
}


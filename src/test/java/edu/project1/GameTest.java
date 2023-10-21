package edu.project1;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameTest {

    @Test
    void attemptToGuessTest() {
        Session session = new Session("word");
        assertEquals(0, session.getAttempts());
        assertEquals(4, session.getMaxAttempts());

        assertTrue(session.attemptToGuess('o'));
        assertEquals(0, session.getAttempts());

        assertFalse(session.attemptToGuess('a'));
        assertEquals(1, session.getAttempts());

        assertTrue(session.attemptToGuess('d'));
        assertEquals(1, session.getAttempts());

    }

    @Nested
    class gameStatusCheckTest {
        @Test
        void winStatus() {
            Session session = new Session("test");
            assertEquals(GameStatus.IN_PROCESS, session.gameStatusCheck());
            session.attemptToGuess('t');
            session.attemptToGuess('e');
            assertEquals(GameStatus.IN_PROCESS, session.gameStatusCheck());
            session.attemptToGuess('s');
            assertEquals(GameStatus.WIN, session.gameStatusCheck());
        }

        @Test
        void loseStatus() {
            Session session = new Session("word");
            assertEquals(GameStatus.IN_PROCESS, session.gameStatusCheck());
            session.attemptToGuess('a');
            session.attemptToGuess('b');
            assertEquals(GameStatus.IN_PROCESS, session.gameStatusCheck());
            session.attemptToGuess('c');
            session.attemptToGuess('k');
            assertEquals(GameStatus.LOSE, session.gameStatusCheck());

        }
    }

    @Test
    void isAllGuessedTest() {
        Session session = new Session("word");
        assertFalse(session.isAllGuessed());

        session.attemptToGuess('w');
        session.attemptToGuess('o');
        session.attemptToGuess('r');
        session.attemptToGuess('d');

        assertTrue(session.isAllGuessed());
    }

}

package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void shouldPlayerOneWin() {
        Player player1 = new Player(1, "Ivan", 100);
        Player player2 = new Player(2, "Oleg", 50);

        Game game = new Game();

        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("Ivan", "Oleg");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldPlayerTwoWin() {
        Player player1 = new Player(1, "Ivan", 100);
        Player player2 = new Player(2, "Oleg", 200);

        Game game = new Game();

        game.register(player1);
        game.register(player2);

        int expected = 2;
        int actual = game.round("Ivan", "Oleg");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldPlayerEquals() {
        Player player1 = new Player(1, "Ivan", 150);
        Player player2 = new Player(2, "Oleg", 150);

        Game game = new Game();

        game.register(player1);
        game.register(player2);

        int expected = 0;
        int actual = game.round("Ivan", "Oleg");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldPlayer1NotExist() {
        Player player2 = new Player(2, "Oleg", 150);

        Game game = new Game();

        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Ivan", "Oleg")
        );
    }

    @Test
    public void shouldPlayer2NotExist() {
        Player player1 = new Player(1, "Ivan", 150);

        Game game = new Game();

        game.register(player1);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Ivan", "Oleg")
        );
    }
}

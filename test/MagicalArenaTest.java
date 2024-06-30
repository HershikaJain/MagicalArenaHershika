package test;
import static org.junit.Assert.*;

import org.junit.Test;

public class MagicalArenaTest {

    @Test
    public void testPlayerIsAlive() {
        Player player = new Player(50, 5, 10);
        assertTrue(player.isAlive());
    }

    @Test
    public void testPlayerIsNotAlive() {
        Player player = new Player(0, 5, 10);
        assertFalse(player.isAlive());
    }

    @Test
    public void testBattle() {
        Player playerA = new Player(50, 5, 10);
        Player playerB = new Player(100, 10, 5);
        MagicalArena.battle(playerA, playerB);
        assertTrue(playerA.isAlive() || playerB.isAlive());
    }
}

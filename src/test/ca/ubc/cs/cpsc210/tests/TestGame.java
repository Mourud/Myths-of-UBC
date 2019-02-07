package ca.ubc.cs.cpsc210.tests;

import ca.ubc.cs.cpsc210.ui.Game;
import org.junit.jupiter.api.BeforeEach;

public class TestGame {
    Game game;


    @BeforeEach
    void testGame() {
        game = new Game("Easy");
    }

}

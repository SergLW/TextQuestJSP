package com.textQuest.model;

import com.textQuest.model.scene.SceneType;
import com.textQuest.model.state.GameState;
import com.textQuest.model.state.QuestionState;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class GameEngineTest {

    @Test
    void answer_onWin_isNo() {
        GameEngine gameEngine = GameFactory.newGame();
        for (int i = 0; i < 6; i++) {
            gameEngine.answer(true);
        }

        GameState before = gameEngine.currentState();
        assertEquals(SceneType.WIN, before.sceneType());

        gameEngine.answer(true);
        GameState after = gameEngine.currentState();
        assertSame(before, after);
    }

    @Test
    void answer_onLose_isNo() {
        GameEngine gameEngine = GameFactory.newGame();
        gameEngine.answer(false);

        GameState before = gameEngine.currentState();
        assertEquals(SceneType.LOSE, before.sceneType());

        gameEngine.answer(false);
        GameState after = gameEngine.currentState();
        assertSame(before, after);
    }

    @Test
    void answer_shouldFailOnUnknownTarget() {
        Map<String, GameState> map = new HashMap<>();
        map.put("Q4_SOME", new QuestionState(
                "Q4_SOME", "Test?", "NO_LINK", "NO_LINK2", "Tak", "Hi"
        ));

        GameEngine gameEngine = new GameEngine(map, "Q4_SOME");
        assertThrows(IllegalStateException.class, () -> gameEngine.answer(true));
    }

}
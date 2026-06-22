package com.textQuest.model;

import com.textQuest.model.scene.SceneType;
import com.textQuest.model.state.GameState;
import com.textQuest.model.state.QuestionState;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameFactoryTest {

    @Test
    void newGame_startQuestions() {
        GameEngine engine = GameFactory.newGame();
        GameState state = engine.currentState();

        assertNotNull(state);
        assertEquals(SceneType.QUESTION, state.sceneType());
        assertTrue(state instanceof QuestionState);

        QuestionState questionState = (QuestionState) state;
        assertNotNull(questionState.trueLabel());
        assertNotNull(questionState.falseLabel());
        assertFalse(questionState.trueLabel().trim().isEmpty());
        assertFalse(questionState.falseLabel().trim().isEmpty());
    }

    @Test
    void go_win() {
        GameEngine engine = GameFactory.newGame();
        engine.answer(true);
        engine.answer(true);
        engine.answer(true);

        assertEquals(SceneType.WIN, engine.currentState().sceneType());
    }

    @Test
    void go_lose() {
        GameEngine engine = GameFactory.newGame();
        engine.answer(true);
        engine.answer(false);

        assertEquals(SceneType.LOSE, engine.currentState().sceneType());
    }

}
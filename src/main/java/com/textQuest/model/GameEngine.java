package com.textQuest.model;

import com.textQuest.exceptions.InvalidStateException;
import com.textQuest.model.scene.SceneType;
import com.textQuest.model.state.GameState;

import java.util.Map;
import java.util.Objects;

public final class GameEngine {
    private final Map<String, GameState> states;
    private String currentId;

    public GameEngine(Map<String, GameState> states, String startId) {
        this.states = Objects.requireNonNull(states);
        if (!states.containsKey(startId)) {
            throw new IllegalStateException(startId + " (StartId)");
        }
        this.currentId = startId;
    }

    public GameState currentState() {
        return states.get(currentId);
    }

    public void answer(boolean yesAnswer) {
        GameState currentState = currentState();
        if (currentState.sceneType() != SceneType.QUESTION) return;
        String nextId = yesAnswer ? currentState.clickYes() : currentState.clickNo();

        GameState nextState = states.get(nextId);
        if (nextState == null) {
            throw new InvalidStateException(nextId + " (nextId");
        }
        currentId = nextId;
    }

    public GameState get(String id) {
        return states.get(id);
    }

}

package com.textQuest.model;

import com.textQuest.service.QuestionsList;

import java.util.Map;
import java.util.Objects;

public final class GameLogic {
    private final Map<String, GameState> states;
    private String currentId;

    public GameLogic(Map<String, GameState> states, String startId) {
        this.states = Objects.requireNonNull(states);
        if (!states.containsKey(startId)) {
            throw new IllegalArgumentException(startId + " not found");
        }
        this.currentId = startId;
    }

    public GameState currentState() {
        return states.get(currentId);
    }

    public void answer(boolean yesAnswer) {
        GameState currentState = currentState();

        if (currentState.sceneType() != SceneType.QUESTION) {
            return;
        }

        String nextId = yesAnswer ? currentState.clickYes() : currentState.clickNo();
        currentId = nextId;
    }

    public GameState get(String id) {
        return states.get(id);
    }

}

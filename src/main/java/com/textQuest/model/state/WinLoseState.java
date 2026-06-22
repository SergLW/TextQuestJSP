package com.textQuest.model.state;

import com.textQuest.model.scene.SceneType;

import java.util.Objects;

public final class WinLoseState implements GameState {

    private final SceneType sceneType;
    private final String id;
    private final String text;

    public WinLoseState(SceneType sceneType, String id, String text) {
        this.sceneType = Objects.requireNonNull(sceneType);
        this.id = id;
        this.text = text;
    }

    @Override
    public SceneType sceneType() {
        return Objects.requireNonNull(sceneType);
    }

    @Override
    public String id() {
        return id;
    }

    @Override
    public String text() {
        return text;
    }

    @Override
    public String clickYes() {
        return null;
    }

    @Override
    public String clickNo() {
        return null;
    }
}

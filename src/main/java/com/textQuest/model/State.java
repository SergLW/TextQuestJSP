package com.textQuest.model;

import java.util.Objects;

public final class State implements GameState {

    private final SceneType sceneType;

    private final String id;
    private final String text;
    private final String clickYes;
    private final String clickNo;


    public State(SceneType sceneType, String id, String text, String clickYes, String clickNo) {
        this.id = id;
        this.text = text;
        this.clickYes = clickYes;
        this.clickNo = clickNo;
        this.sceneType = Objects.requireNonNull(sceneType);
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
        return clickYes;
    }

    @Override
    public String clickNo() {
        return clickNo;
    }

    @Override
    public SceneType sceneType() {
        return sceneType;
    }
}

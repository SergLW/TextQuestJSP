package com.textQuest.model.state;

import com.textQuest.model.scene.SceneType;

import java.util.Objects;

public final class QuestionState implements GameState {

    private final String id;
    private final String text;
    private final String clickYes;
    private final String clickNo;
    private final String trueLabel;
    private final String falseLabel;


    public QuestionState(String id, String text, String clickYes, String clickNo, String trueLabel, String falseLabel) {
        this.id = id;
        this.text = text;
        this.clickYes = clickYes;
        this.clickNo = clickNo;
        this.trueLabel = trueLabel;
        this.falseLabel = falseLabel;
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

    public String trueLabel() {
        return trueLabel;
    }

    public String falseLabel() {
        return falseLabel;
    }

    @Override
    public SceneType sceneType() {
        return Objects.requireNonNull(SceneType.QUESTION);
    }
}

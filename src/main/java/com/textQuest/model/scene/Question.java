package com.textQuest.model.scene;

public final class Question {
    private final String text;
    private final String trueLabel;
    private final String falseLabel;

    public Question(String text, String trueLabel, String falseLabel) {
        this.text = text;
        this.trueLabel = trueLabel;
        this.falseLabel = falseLabel;
    }

    public String getText() {
        return text;
    }

    public String getTrueLabel() {
        return trueLabel;
    }

    public String getFalseLabel() {
        return falseLabel;
    }
}

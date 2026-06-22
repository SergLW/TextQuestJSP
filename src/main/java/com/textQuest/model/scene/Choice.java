package com.textQuest.model.scene;

public final class Choice {
    private final SceneID clickYes;
    private final SceneID clickNo;

    public Choice(SceneID clickYes, SceneID clickNo) {
        this.clickYes = clickYes;
        this.clickNo = clickNo;
    }

    public SceneID getClickYes() {
        return clickYes;
    }

    public SceneID getClickNo() {
        return clickNo;
    }
}

package com.textQuest.model.scene;

public enum SceneID {
    Q1_INTRO,
    Q2_GO_BRIDGE,
    Q3_ABOUT_MYSEFT,
    WIN_1,
    LOSE_1_REFUSE,
    LOSE_2_REFUSE_GO,
    LOSE_3_LIE;

    public String id() {
        return name();
    }
}

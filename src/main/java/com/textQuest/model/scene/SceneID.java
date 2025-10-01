package com.textQuest.model.scene;

public enum SceneID {
    Q1_INTRO,
    Q2_GO_BRIDGE,
    Q3_ABOUT_MYSELF,
    Q4_SCAN,
    Q4_NEGOTIATE,
    Q5_MEMORY_TEST,
    Q6_HELP_TRANSLATOR,

    WIN_HOME_SAFE,
    WIN_ALLIANCE,

    LOSE_REFUSE_CALL,
    LOSE_REFUSE_BRIDGE,
    LOSE_REFUSE_TEST,
    LOSE_PANIC;
    public String id() {
        return name();
    }
}

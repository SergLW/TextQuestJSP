package com.textQuest.model;

import com.textQuest.model.scene.Choice;
import com.textQuest.model.scene.SceneID;

import java.util.LinkedHashMap;
import java.util.Map;

import static com.textQuest.model.scene.SceneID.*;

public final class Scenario {
    private Scenario() {}

    public static SceneID start() {
        return Q1_INTRO;
    }

    public static Map<SceneID, Choice> choices() {
        Map<SceneID, Choice> choices = new LinkedHashMap<>();
        choices.put(Q1_INTRO, new Choice(Q2_GO_BRIDGE, LOSE_REFUSE_CALL));
        choices.put(Q2_GO_BRIDGE, new Choice(Q3_ABOUT_MYSELF, LOSE_REFUSE_BRIDGE));
        choices.put(Q3_ABOUT_MYSELF, new Choice(Q4_NEGOTIATE, Q4_SCAN));
        choices.put(Q4_SCAN, new Choice(Q4_NEGOTIATE, LOSE_REFUSE_TEST));
        choices.put(Q4_NEGOTIATE, new Choice(Q5_MEMORY_TEST, LOSE_PANIC));
        choices.put(Q5_MEMORY_TEST, new Choice(Q6_HELP_TRANSLATOR, LOSE_REFUSE_TEST));
        choices.put(Q6_HELP_TRANSLATOR, new Choice(WIN_ALLIANCE, WIN_HOME_SAFE));
        return choices;
    }

}

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
        choices.put(Q1_INTRO, new Choice(Q2_GO_BRIDGE, LOSE_1_REFUSE));
        choices.put(Q2_GO_BRIDGE, new Choice(Q3_ABOUT_MYSEFT, LOSE_2_REFUSE_GO));
        choices.put(Q3_ABOUT_MYSEFT, new Choice(WIN_1, LOSE_3_LIE));
        return choices;
    }

}

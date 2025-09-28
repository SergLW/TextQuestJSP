package com.textQuest.service;

import com.textQuest.model.scene.Question;
import com.textQuest.model.scene.SceneID;

import java.util.HashMap;
import java.util.Map;

import static com.textQuest.model.scene.SceneID.*;

public final class QuestionsList {
    private static final Map<SceneID, Question> QUESTIONS = new HashMap<>();
    private static final Map<SceneID, String> WINS = new HashMap<>();
    private static final Map<SceneID, String> LOSES = new HashMap<>();

    private QuestionsList() {
    }

    static {
        //QUESTIONS
        QUESTIONS.put(Q1_INTRO, new Question(
                "Ви втрачаєте пам'ять. Прийняти виклик НЛО?",
                "Прийняти виклик.",
                "Відхилити виклик."
        ));
        QUESTIONS.put(Q2_GO_BRIDGE, new Question(
                "Ви прийняли виклик. Піднятися на капітанський місток?",
                "Піднятися на місток.",
                "Відмовитися підніматися на місток."
        ));
        QUESTIONS.put(Q3_ABOUT_MYSEFT, new Question(
                "Ви піднялися на місток. Хто ви?",
                "Розповісти правду про себе.",
                "Збрехати про себе."
        ));
        //WINS
        WINS.put(WIN_1, "Вас повернули додому.");
        //LOSES
        LOSES.put(LOSE_1_REFUSE, "Ви відхилили виклик.");
        LOSES.put(LOSE_2_REFUSE_GO, "Ви відмовилися йти на переговори. ");
        LOSES.put(LOSE_3_LIE, "Ваша брехня була розкрита.");
    }

    public static Question getQuestion(SceneID sceneID) {
        return QUESTIONS.get(sceneID);
    }

    public static String winText(SceneID sceneID) {
        return WINS.get(sceneID);
    }

    public static String loseText(SceneID sceneID) {
        return LOSES.get(sceneID);
    }

    public static boolean isQuestion(SceneID sceneID) {
        return QUESTIONS.containsKey(sceneID);
    }

    public static boolean isWin(SceneID sceneID) {
        return WINS.containsKey(sceneID);
    }

    public static boolean isLose(SceneID sceneID) {
        return LOSES.containsKey(sceneID);
    }

}

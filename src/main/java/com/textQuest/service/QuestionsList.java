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
        QUESTIONS.put(Q1_INTRO, new Question(
                "You’re losing your memory. Answer the UFO call?",
                "Answer the call.",
                "Ignore the call."
        ));
        QUESTIONS.put(Q2_GO_BRIDGE, new Question(
                "You answered the call. Go up to the captain’s bridge?",
                "Go to the bridge.",
                "Stay where you are."
        ));
        QUESTIONS.put(Q3_ABOUT_MYSELF, new Question(
                "You reached the bridge. Who are you?",
                "Tell the truth about yourself.",
                "Lie about yourself."
        ));
        QUESTIONS.put(Q4_SCAN, new Question(
                "They propose a quick bioscan to verify you. Do you agree?",
                "Agree to the scan.",
                "Refuse the scan."
        ));
        QUESTIONS.put(Q4_NEGOTIATE, new Question(
                "They want to negotiate terms to send you home. Do you negotiate?",
                "Negotiate the terms.",
                "Decline to negotiate."
        ));
        QUESTIONS.put(Q5_MEMORY_TEST, new Question(
                "Before sending you home, they ask for a memory integrity test. Take it?",
                "Take the test.",
                "Refuse the test."
        ));
        QUESTIONS.put(Q6_HELP_TRANSLATOR, new Question(
                "Their translator is glitchy. Will you help calibrate it?",
                "Help with calibration.",
                "Skip and go home now."
        ));

        // WINS
        WINS.put(WIN_HOME_SAFE, "They safely return you home.");
        WINS.put(WIN_ALLIANCE, "You forge a small alliance and are returned home with new friends.");

        // LOSES
        LOSES.put(LOSE_REFUSE_CALL, "You ignored the call.");
        LOSES.put(LOSE_REFUSE_BRIDGE, "You refused to go to the bridge.");
        LOSES.put(LOSE_REFUSE_TEST, "You refused verification. They won’t take the risk.");
        LOSES.put(LOSE_PANIC, "You panicked and broke protocol. The meeting ended.");
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

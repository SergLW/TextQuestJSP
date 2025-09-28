package com.textQuest.service;

import com.textQuest.model.GameLogic;
import com.textQuest.model.GameState;
import com.textQuest.model.SceneType;
import com.textQuest.model.State;

import java.util.LinkedHashMap;
import java.util.Map;

public final class QuestionsList {
    private QuestionsList() {
    }

    public static GameLogic newGame() {
        Map<String, GameState> states = new LinkedHashMap<>();
        //QUESTONS
        states.put("q1_challenge", new State(
                SceneType.QUESTION,
                "q1_challenge",
                "Ви втрачаєте пам'ять. Прийняти виклик НЛО",
                "q2",
                "q1_lose"
        ));

        //LOSE
        states.put("q1_lose", new State(
                SceneType.LOSE,
                "q1_lose",
                "Ви відхилили виклик.",
                null,
                null
        ));

        //WIN
        states.put("q_win", new State(
                SceneType.WIN,
                "q_win",
                "Ти чесно відповів на питання і зберіг пам'ять. Відмінна робота!",
                null,
                null
        ));

        return new GameLogic(states, "q1_challenge");
    }
}

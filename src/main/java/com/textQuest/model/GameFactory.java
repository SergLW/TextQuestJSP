package com.textQuest.model;

import com.textQuest.model.scene.SceneID;
import com.textQuest.model.scene.SceneType;
import com.textQuest.model.state.GameState;
import com.textQuest.model.state.QuestionState;
import com.textQuest.model.state.WinLoseState;
import com.textQuest.model.scene.Choice;
import com.textQuest.model.scene.Question;
import com.textQuest.service.QuestionsList;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.textQuest.model.scene.SceneID.*;

public class GameFactory {
    private GameFactory() {}

    public static GameEngine newGame() {
        Map<String, GameState> states = new LinkedHashMap<>();
        Map<SceneID, Choice> choices = Scenario.choices();

        for (Map.Entry<SceneID, Choice> choice : choices.entrySet()) {
            SceneID key = choice.getKey();
            Choice value = choice.getValue();

            Question question = QuestionsList.getQuestion(key);
            if (question == null) {
                throw new IllegalStateException("No question found for key: " + key);
            }

            states.put(key.id(), new QuestionState(
                    key.id(),
                    question.getText(),
                    value.getClickYes().id(),
                    value.getClickNo().id(),
                    question.getTrueLabel(),
                    question.getFalseLabel()
            ));
        }

        List<SceneID> winId = Arrays.asList(
                WIN_HOME_SAFE,
                WIN_ALLIANCE);
        for (SceneID win : winId) {
            String text = QuestionsList.winText(win);
            if (text != null) {
                states.put(win.id(), new WinLoseState(SceneType.WIN, win.id(), text));
            }
        }

        List<SceneID> loseIds = Arrays.asList(
                LOSE_PANIC,
                LOSE_REFUSE_BRIDGE,
                LOSE_REFUSE_TEST,
                LOSE_REFUSE_CALL
        );
        for (SceneID lose : loseIds) {
            String text = QuestionsList.loseText(lose);
            if (text != null) {
                states.put(lose.id(), new WinLoseState(SceneType.LOSE, lose.id(), text));
            }
        }

        return new GameEngine(states, Scenario.start().id());
    }
}

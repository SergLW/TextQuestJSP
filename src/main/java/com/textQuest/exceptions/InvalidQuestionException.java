package com.textQuest.exceptions;

import com.textQuest.model.scene.SceneID;

public class InvalidQuestionException extends GameException {
    public InvalidQuestionException(SceneID key) {
        super("No question found for key: " + key);
    }
}

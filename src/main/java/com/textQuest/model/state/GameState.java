package com.textQuest.model.state;

import com.textQuest.model.scene.SceneType;

public interface GameState {

    SceneType sceneType();
    String id();
    String text();
    String clickYes();
    String clickNo();

}

package com.github.hanyaeger.FishingSimulator.entities.minigame;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class MiniGame extends SpriteEntity {


    public MiniGame(Coordinate2D initialLocation) {
        super("sprites/minigame.png", initialLocation, new Size(100, 350), 1, 1);
        setVisible(false);
    }

    public void showMiniGame(boolean visible) {
        setVisible(visible);
    }
}

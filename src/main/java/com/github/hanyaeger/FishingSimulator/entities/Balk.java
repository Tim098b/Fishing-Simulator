package com.github.hanyaeger.FishingSimulator.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class Balk extends DynamicSpriteEntity {
    public Balk(Coordinate2D initialLocation) {
        super("sprites/minigame_balk.png", initialLocation, new Size(22, 120), 1, 1);
        setMotion(0, 180);
        setVisible(true);
    }


    public void removeBalk() {
        remove();
    }

    public void showBalk(boolean visible) {
        setVisible(visible);
    }
}

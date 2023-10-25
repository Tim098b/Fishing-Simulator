package com.github.hanyaeger.FishingSimulator.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class MiniGameBalk extends DynamicSpriteEntity implements Collider {
    public MiniGameBalk(Coordinate2D initialLocation) {
        super("sprites/minigame_balk.png", initialLocation, new Size(22, 49), 1, 1);
        setMotion(3, 180);
        setVisible(false);
    }


    public void removeBalk() {
        remove();
    }

    public void showBalk(boolean visible) {
        setVisible(visible);
    }
}

package com.github.hanyaeger.FishingSimulator.entities.shadow;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

public abstract class FishShadow extends DynamicSpriteEntity implements Collider, SceneBorderTouchingWatcher {

    public FishShadow(Coordinate2D initialLocation) {
        super("sprites/fish_shadow.png", initialLocation, new Size(100, 100), 1, 1);
    }


    public abstract void move();

    @Override
    public void notifyBoundaryTouching(SceneBorder sceneBorder) {
        switch (sceneBorder) {
            case LEFT, RIGHT, TOP, BOTTOM:
                changeDirection(90);
                break;
        }
    }
}

package com.github.hanyaeger.FishingSimulator.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

public class FishShadow extends DynamicSpriteEntity implements Collider, SceneBorderTouchingWatcher {

    public FishShadow(Coordinate2D initialLocation) {
        super("sprites/fish_shadow.png", initialLocation, new Size(100, 100), 1, 1);
        setMotion(1, randomizeAngle(0, 360));
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder sceneBorder) {
        switch (sceneBorder)
        {
            case LEFT, RIGHT, TOP, BOTTOM:
                changeDirection(90);
                break;
        }
    }

    private double randomizeAngle(int i, int i1) {
        return Math.random() * (i1 - i) + i;
    }
}

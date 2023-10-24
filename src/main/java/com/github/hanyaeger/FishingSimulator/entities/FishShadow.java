package com.github.hanyaeger.FishingSimulator.entities;

import com.github.hanyaeger.FishingSimulator.Zee;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

public class FishShadow extends DynamicSpriteEntity implements Collider, SceneBorderTouchingWatcher {

    private Zee zee;

    public FishShadow(Coordinate2D initialLocation, Zee zee) {
        super("sprites/fish_shadow.png", initialLocation, new Size(150, 150), 1, 1);
        this.zee = zee;
        setMotion(1, 360d);
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder sceneBorder) {
        switch (sceneBorder)
        {
            case LEFT:
            case RIGHT:
            case TOP:
            case BOTTOM:
                setMotion(1, randomizeAngle(0, 360));
                break;
        }
    }

    private double randomizeAngle(int i, int i1) {
        return Math.random() * (i1 - i) + i;
    }
}

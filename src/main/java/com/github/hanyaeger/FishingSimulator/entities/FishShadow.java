package com.github.hanyaeger.FishingSimulator.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

public class FishShadow extends DynamicSpriteEntity implements Newtonian, SceneBorderTouchingWatcher, Collider {

    public FishShadow(Coordinate2D initialLocation) {
        super("sprites/fish_shadow.png", initialLocation, new Size(150, 150), 1, 1);
        setMotion(2, Direction.RIGHT);
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder border) {
        switch (border) {
            case TOP:
                setAnchorLocationY(1);
                break;
            case BOTTOM:
                setAnchorLocationY(10);
                break;
            case LEFT:
                setAnchorLocationX(1);
                break;
            case RIGHT:
                setAnchorLocationX(getSceneWidth() - getWidth() - 1);
                break;
        }
    }
}

package com.github.hanyaeger.FishingSimulator.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

public class MiniGameBalk extends DynamicSpriteEntity implements Collider, SceneBorderTouchingWatcher {
    public MiniGameBalk(Coordinate2D initialLocation) {
        super("sprites/minigame_balk.png", initialLocation, new Size(22, 49), 1, 1);
        setMotion(1, 180);
        setVisible(false);
    }

    public void showMiniGameBalk(boolean visible) {
        setVisible(visible);
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder sceneBorder) {
        switch (sceneBorder)
        {
            case TOP, BOTTOM:
                setAnchorLocationY(230);
                break;
        }
    }
}

package com.github.hanyaeger.FishingSimulator.entities.minigame;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

public class MiniGameBalk extends DynamicSpriteEntity implements Collider, SceneBorderTouchingWatcher {
    private int score;

    public MiniGameBalk() {
        super("sprites/minigame_balk.png", new Coordinate2D(390, 230), new Size(22, 49), 1, 1);
        setMotion(1, 180);
        setVisible(false);
    }

    public void showMiniGameBalk(boolean visible) {
        setVisible(visible);
    }

    public void setSpeed(int speed) {
        setMotion(speed, 180);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder sceneBorder) {
        switch (sceneBorder) {
            case TOP, BOTTOM:
                setAnchorLocationY(230);
                break;
        }
    }
}

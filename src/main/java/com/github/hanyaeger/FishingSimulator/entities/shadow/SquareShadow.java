package com.github.hanyaeger.FishingSimulator.entities.shadow;

import com.github.hanyaeger.FishingSimulator.Timers.ShadowFishTimer;
import com.github.hanyaeger.FishingSimulator.entities.shadow.FishShadow;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.entities.Direction;

public class SquareShadow extends FishShadow implements TimerContainer {

    public SquareShadow() {
        super((new Coordinate2D(900, 600)));
    }

    @Override
    public void move() {
        setMotion(1, squareMove());
    }

    private Direction squareMove() {
        if (getAnchorLocation().getX() < 1000 && getAnchorLocation().getY() == 400) {
            return Direction.RIGHT;
        } else if (getAnchorLocation().getX() == 1000 && getAnchorLocation().getY() < 600) {
            return Direction.DOWN;
        } else if (getAnchorLocation().getX() > 800 && getAnchorLocation().getY() == 600) {
            return Direction.LEFT;
        } else if (getAnchorLocation().getX() == 800 && getAnchorLocation().getY() > 400) {
            return Direction.UP;
        } else {
            return Direction.RIGHT;
        }
    }


    @Override
    public void setupTimers() {
        addTimer(new ShadowFishTimer(this, 1));
    }
}

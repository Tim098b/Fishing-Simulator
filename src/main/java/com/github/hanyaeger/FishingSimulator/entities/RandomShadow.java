package com.github.hanyaeger.FishingSimulator.entities;

import com.github.hanyaeger.FishingSimulator.Timers.ShadowFishTimer;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.TimerContainer;

public class RandomShadow extends FishShadow implements TimerContainer {

    public RandomShadow() {
        super((new Coordinate2D(900, 600)));
    }

    @Override
    public void move() {
        setMotion(1, randomizeAngle(0, 360));
    }

    private double randomizeAngle(int i, int i1) {
        return Math.random() * (i1 - i) + i;
    }

    @Override
    public void setupTimers() {
        addTimer(new ShadowFishTimer(this, 5000));
    }
}



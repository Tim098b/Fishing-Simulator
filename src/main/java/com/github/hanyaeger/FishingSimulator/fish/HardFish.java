package com.github.hanyaeger.FishingSimulator.fish;

import com.github.hanyaeger.FishingSimulator.entities.MiniGameBalk;
import com.github.hanyaeger.api.Coordinate2D;

public class HardFish extends MiniGameBalk {
    public HardFish(Coordinate2D initialLocation) {
        super(initialLocation);
        setScore(2);
        setSpeed(2);
    }
}

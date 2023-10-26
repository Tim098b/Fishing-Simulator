package com.github.hanyaeger.FishingSimulator.fish;

import com.github.hanyaeger.FishingSimulator.entities.MiniGameBalk;
import com.github.hanyaeger.api.Coordinate2D;

public class EasyFish extends MiniGameBalk {
    public EasyFish(Coordinate2D initialLocation) {
        super(initialLocation);
        setScore(1);
        setSpeed(1);
    }
}

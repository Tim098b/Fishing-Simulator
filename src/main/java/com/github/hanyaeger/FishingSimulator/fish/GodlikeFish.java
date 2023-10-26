package com.github.hanyaeger.FishingSimulator.fish;

import com.github.hanyaeger.FishingSimulator.entities.MiniGameBalk;
import com.github.hanyaeger.api.Coordinate2D;

public class GodlikeFish extends MiniGameBalk {
    public GodlikeFish(Coordinate2D initialLocation) {
        super(initialLocation);
        setScore(3);
        setSpeed(3);
    }
}

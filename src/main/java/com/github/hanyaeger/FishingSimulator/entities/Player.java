package com.github.hanyaeger.FishingSimulator.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class Player extends SpriteEntity {

    public Player(Coordinate2D initialLocation) {
        super("sprites/player_fishingrod.png", initialLocation, new Size(150, 100), 1, 1);
    }
}

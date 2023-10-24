package com.github.hanyaeger.FishingSimulator.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class MiniGameFish extends SpriteEntity {

    public MiniGameFish(Coordinate2D initialLocation) {
        super("sprites/minigame_fish.png", initialLocation, new Size(35, 35), 1, 1);
    }

    public void removeMiniGameFish() {
        remove();
    }
}

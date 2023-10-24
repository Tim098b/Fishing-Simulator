package com.github.hanyaeger.FishingSimulator;

import com.github.hanyaeger.FishingSimulator.entities.FishShadow;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class Dobber extends DynamicSpriteEntity implements Collided {


    public Dobber(Coordinate2D initialLocation) {
        super("sprites/dobber.png", initialLocation);
    }

    @Override
    public void onCollision(Collider collider) {
        if (collider instanceof FishShadow) {
            System.out.println("Collision detected!");
        }
    }
}

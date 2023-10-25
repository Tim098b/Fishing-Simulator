package com.github.hanyaeger.FishingSimulator;

import com.github.hanyaeger.FishingSimulator.entities.FishShadow;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;


public class Zee extends Borders implements Collided {
    public Zee(final Coordinate2D initialPosition, final Size size) {
        super(initialPosition, size);
    }

    @Override
    public void onCollision(Collider collider) {
        if (collider instanceof FishShadow) {
            System.out.println("FishShadow collided");
            ((FishShadow) collider).setMotion(1, randomizeAngle(0, 360));
        }
    }

    private double randomizeAngle(int i, int i1) {
        return Math.random() * (i1 - i) + i;
    }
}

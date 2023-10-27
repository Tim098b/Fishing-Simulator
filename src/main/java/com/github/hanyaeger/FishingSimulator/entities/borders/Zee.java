package com.github.hanyaeger.FishingSimulator.entities.borders;

import com.github.hanyaeger.FishingSimulator.entities.borders.Borders;
import com.github.hanyaeger.FishingSimulator.entities.shadow.FishShadow;
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
            ((FishShadow) collider).changeDirection(90);
        }
    }
}

package com.github.hanyaeger.FishingSimulator.entities.borders;

import com.github.hanyaeger.FishingSimulator.entities.borders.Borders;
import com.github.hanyaeger.FishingSimulator.entities.minigame.MiniGameBalk;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;


public class MiniGameBorder extends Borders implements Collided {
    public MiniGameBorder(final Coordinate2D initialPosition, final Size size) {
        super(initialPosition, size);
    }

    @Override
    public void onCollision(Collider collider) {
        if (collider instanceof MiniGameBalk) {
            ((MiniGameBalk) collider).changeDirection(180);
        }
    }
}

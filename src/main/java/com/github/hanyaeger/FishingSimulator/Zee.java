package com.github.hanyaeger.FishingSimulator;

import com.github.hanyaeger.FishingSimulator.entities.FishShadow;
import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;

public class Zee extends RectangleEntity implements Collided {
    public Zee(final Coordinate2D initialPosition, final Size size) {
        super(initialPosition);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setWidth(size.width());
        setHeight(size.height());
        setFill(Color.TRANSPARENT);
        setStrokeColor(Color.RED);
        setStrokeWidth(1D);
    }

    @Override
    public void onCollision(Collider collider) {
        if (collider instanceof FishShadow) {
            ((FishShadow) collider).setMotion(1, randomizeAngle(0, 360)
            );
        }
    }

    private double randomizeAngle(int i, int i1) {
        return Math.random() * (i1 - i) + i;
    }
}

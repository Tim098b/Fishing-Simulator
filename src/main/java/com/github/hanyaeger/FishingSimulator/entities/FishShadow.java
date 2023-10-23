package com.github.hanyaeger.FishingSimulator.entities;

import com.github.hanyaeger.FishingSimulator.Zee;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class FishShadow extends DynamicSpriteEntity implements Newtonian, Collider {

    private Zee zee;

    public FishShadow(Coordinate2D initialLocation, Zee zee) {
        super("sprites/fish_shadow.png", initialLocation, new Size(150, 150), 1, 1);
        this.zee = zee;
        setMotion(1, 270d);
    }

    public void notifyBoundaryTouching(Coordinate2D location) {
        if (zee.getBoundingBox().getMaxY() < location.getY()) {
            System.out.println("test");
        } else if (zee.getBoundingBox().getMinX() < location.getY()) {
            System.out.println("test");
        } else if (zee.getBoundingBox().getMinY() < location.getY()) {
            System.out.println("test");
        } else if (zee.getBoundingBox().getMaxX() < location.getY()) {
            System.out.println("test");
        }
    }

}

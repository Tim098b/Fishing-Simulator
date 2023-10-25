package com.github.hanyaeger.FishingSimulator;

import com.github.hanyaeger.FishingSimulator.entities.FishShadow;
import com.github.hanyaeger.FishingSimulator.entities.MiniGame;
import com.github.hanyaeger.FishingSimulator.scenes.GameScene;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class Dobber extends DynamicSpriteEntity implements Collided {

    private MiniGame miniGame;
    public Dobber(Coordinate2D initialLocation, MiniGame miniGame) {
        super("sprites/dobber.png", initialLocation);
        this.miniGame = miniGame;
    }

    @Override
    public void onCollision(Collider collider) {
        if (collider instanceof FishShadow) {
            miniGame.showMiniGame(true);
        }
    }
}

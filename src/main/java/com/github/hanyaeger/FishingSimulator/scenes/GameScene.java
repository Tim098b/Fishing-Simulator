package com.github.hanyaeger.FishingSimulator.scenes;

import com.github.hanyaeger.FishingSimulator.Zee;
import com.github.hanyaeger.FishingSimulator.entities.FishShadow;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.FishingSimulator.entities.Player;

public class GameScene extends DynamicScene {

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/gameBackground.gif");
    }

    @Override
    public void setupEntities() {
        var zee = new Zee(new Coordinate2D(800, 550),
                new Size(950, 330));
        addEntity(zee);

        addEntity(new Player(new Coordinate2D(250, 400)));
        addEntity(new FishShadow(new Coordinate2D(900, 600), zee));
    }
}

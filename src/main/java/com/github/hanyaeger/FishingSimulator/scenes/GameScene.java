package com.github.hanyaeger.FishingSimulator.scenes;

import com.github.hanyaeger.FishingSimulator.Dobber;
import com.github.hanyaeger.FishingSimulator.Zee;
import com.github.hanyaeger.FishingSimulator.entities.FishShadow;
import com.github.hanyaeger.FishingSimulator.entities.MiniGame;
import com.github.hanyaeger.FishingSimulator.entities.MiniGameFish;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.FishingSimulator.entities.Player;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;

public class GameScene extends DynamicScene implements MouseButtonPressedListener {

    public boolean isFishing = false;

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/gameBackground.gif");
    }

    @Override
    public void setupEntities() {
        var zee = new Zee(new Coordinate2D(800, 550),
                new Size(950, 330));
        addEntity(zee);

        var player = new Player(new Coordinate2D(250, 400));
        addEntity(player);
        addEntity(new FishShadow(new Coordinate2D(900, 600), zee));
        addEntity(new MiniGame(new Coordinate2D(350, 75)));
        addEntity(new MiniGameFish(new Coordinate2D(382, 230)));
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        if (mouseButton == MouseButton.PRIMARY) {
            if(!isFishing) {
                addEntity(new Dobber(new Coordinate2D(coordinate2D.getX() - 20, coordinate2D.getY() - 30)));
                isFishing = true;
            }
        }
    }

}

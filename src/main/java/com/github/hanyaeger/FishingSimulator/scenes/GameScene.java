package com.github.hanyaeger.FishingSimulator.scenes;

import com.github.hanyaeger.FishingSimulator.Dobber;
import com.github.hanyaeger.FishingSimulator.MiniGameBorder;
import com.github.hanyaeger.FishingSimulator.Zee;
import com.github.hanyaeger.FishingSimulator.entities.*;
import com.github.hanyaeger.FishingSimulator.text.ScoreText;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;

public class GameScene extends DynamicScene implements MouseButtonPressedListener {

    public static boolean isFishing = false;

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/gameBackground.gif");
    }

    MiniGame miniGame = new MiniGame(new Coordinate2D(350, 75));
    MiniGameFish miniGameFish = new MiniGameFish(new Coordinate2D(382, 230));
    MiniGameBalk miniGameBalk = new MiniGameBalk(new Coordinate2D(390, 230));

    @Override
    public void setupEntities() {
        addEntity(new Zee(new Coordinate2D(650, 200), new Size(1300, 370)));
        addEntity(new Zee(new Coordinate2D(200, 550), new Size(400, 350)));
        addEntity(new MiniGameBorder(new Coordinate2D(400, 60), new Size(50, 50)));
        addEntity(new MiniGameBorder(new Coordinate2D(400, 440), new Size(50, 50)));
        addEntity(new Player(new Coordinate2D(250, 400)));
        addEntity(new FishShadow(new Coordinate2D(900, 600)));
        addEntity(new FishShadow(new Coordinate2D(900, 600)));
        addEntity(new ScoreText(new Coordinate2D(30, 30), 0));
        addEntity(miniGame);
        addEntity(miniGameBalk);
        addEntity(miniGameFish);
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        if (mouseButton == MouseButton.PRIMARY) {
            if (!isFishing) {
                addEntity(new Dobber(new Coordinate2D(coordinate2D.getX() - 20, coordinate2D.getY() - 30), miniGame, miniGameFish, miniGameBalk));
                isFishing = true;
            }
        }
    }
}

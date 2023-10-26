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
import javafx.scene.paint.Color;

public class GameScene extends DynamicScene implements MouseButtonPressedListener {

    public static boolean isFishing = false;
    public static boolean inMiniGame = false;


    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/gameBackground.gif");
    }

    MiniGame miniGame = new MiniGame(new Coordinate2D(350, 75));
    MiniGameFish miniGameFish = new MiniGameFish(new Coordinate2D(382, 230));
    MiniGameBalk miniGameBalk = new MiniGameBalk(new Coordinate2D(390, 230));
    ScoreText scoreText = new ScoreText(new Coordinate2D(30, 30), 0);

    @Override
    public void setupEntities() {
        addEntity(new Zee(new Coordinate2D(650, 200), new Size(1300, 370)));
        addEntity(new Zee(new Coordinate2D(200, 550), new Size(400, 350)));
        addEntity(new MiniGameBorder(new Coordinate2D(400, 85), new Size(50, 1)));
        addEntity(new MiniGameBorder(new Coordinate2D(400, 415), new Size(50, 1)));
        addEntity(new Player(new Coordinate2D(250, 400)));
        for (int i = 0; i < 2; i++) {
            addEntity(new FishShadow(new Coordinate2D(900, 600)));
        }
        addEntity(scoreText);
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
            if (inMiniGame) {
                double balkTop = miniGameBalk.getAnchorLocation().getY();
                double balkBottom = balkTop + miniGameBalk.getHeight();

                double fishTop = miniGameFish.getAnchorLocation().getY();
                double fishBottom = fishTop + miniGameFish.getHeight();

                if (balkTop < fishTop && balkBottom > fishBottom) {
                    scoreText.setFill(Color.BLUE);
                    scoreText.setScore(scoreText.getScore() + 2);
                }
                else {
                    scoreText.setFill(Color.RED);
                    scoreText.setScore(scoreText.getScore() - 1);
                }
                miniGame.showMiniGame(false);
                miniGameBalk.showMiniGameBalk(false);
                miniGameFish.showMiniGameFish(false);
                inMiniGame = false;
                isFishing = false;
                addEntity(new FishShadow(new Coordinate2D(900, 600)));
            }
        }
    }
}

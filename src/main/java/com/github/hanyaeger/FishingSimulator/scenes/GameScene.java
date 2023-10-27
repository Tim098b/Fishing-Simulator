package com.github.hanyaeger.FishingSimulator.scenes;

import com.github.hanyaeger.FishingSimulator.entities.Dobber;
import com.github.hanyaeger.FishingSimulator.entities.borders.MiniGameBorder;
import com.github.hanyaeger.FishingSimulator.entities.borders.Zee;
import com.github.hanyaeger.FishingSimulator.entities.*;
import com.github.hanyaeger.FishingSimulator.entities.minigame.MiniGame;
import com.github.hanyaeger.FishingSimulator.entities.minigame.MiniGameBalk;
import com.github.hanyaeger.FishingSimulator.entities.minigame.MiniGameFish;
import com.github.hanyaeger.FishingSimulator.entities.shadow.FishShadow;
import com.github.hanyaeger.FishingSimulator.entities.shadow.RandomShadow;
import com.github.hanyaeger.FishingSimulator.entities.shadow.SquareShadow;
import com.github.hanyaeger.FishingSimulator.text.ScoreText;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class GameScene extends DynamicScene implements MouseButtonPressedListener {

    public static boolean isFishing = false;
    public static boolean inMiniGame = false;


    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/gameBackground.gif");
    }

    MiniGame miniGame = new MiniGame(new Coordinate2D(350, 75));
    MiniGameFish miniGameFish = new MiniGameFish(new Coordinate2D(382, 230));
    MiniGameBalk miniGameBalk = new MiniGameBalk();
    ScoreText scoreText = new ScoreText(new Coordinate2D(30, 30), 0);
    ArrayList<FishShadow> fishShadows = new ArrayList<>();

    @Override
    public void setupEntities() {
        addEntity(new Zee(new Coordinate2D(650, 200), new Size(1300, 370)));
        addEntity(new Zee(new Coordinate2D(200, 550), new Size(400, 350)));
        addEntity(new MiniGameBorder(new Coordinate2D(400, 85), new Size(50, 1)));
        addEntity(new MiniGameBorder(new Coordinate2D(400, 415), new Size(50, 1)));
        addEntity(new Player(new Coordinate2D(250, 400)));
        fishShadows.add(new SquareShadow());
        fishShadows.add(new RandomShadow());
        addEntity(scoreText);
        addEntity(miniGame);
        addEntity(miniGameBalk);
        addEntity(miniGameFish);
        for (FishShadow fishShadow : fishShadows) {
            addEntity(fishShadow);
            fishShadow.move();
        }
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
                    scoreText.setScore(scoreText.getScore() + miniGameBalk.getScore());
                } else {
                    scoreText.setFill(Color.RED);
                    scoreText.setScore(scoreText.getScore() - 1);
                }
                miniGame.showMiniGame(false);
                miniGameBalk.showMiniGameBalk(false);
                miniGameFish.showMiniGameFish(false);
                inMiniGame = false;
                isFishing = false;
                FishShadow fishShadow = fishShadows.get((int) (Math.random() * fishShadows.size()));
                addEntity(fishShadow);
                fishShadow.move();
            }
        }
    }
}

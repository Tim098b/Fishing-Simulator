package com.github.hanyaeger.FishingSimulator;

import com.github.hanyaeger.FishingSimulator.entities.FishShadow;
import com.github.hanyaeger.FishingSimulator.entities.MiniGame;
import com.github.hanyaeger.FishingSimulator.entities.MiniGameBalk;
import com.github.hanyaeger.FishingSimulator.entities.MiniGameFish;
import com.github.hanyaeger.FishingSimulator.fish.EasyFish;
import com.github.hanyaeger.FishingSimulator.fish.GodlikeFish;
import com.github.hanyaeger.FishingSimulator.fish.HardFish;
import com.github.hanyaeger.FishingSimulator.scenes.GameScene;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class Dobber extends DynamicSpriteEntity implements Collided, MouseButtonPressedListener {

    private MiniGame miniGame;
    private MiniGameFish miniGameFish;
    private MiniGameBalk miniGameBalk;

//    private EasyFish easyFish;
//    private HardFish hardFish;
//    private GodlikeFish godlikeFish;

    private MiniGameBalk easyFish = new EasyFish();
    private MiniGameBalk hardFish = new HardFish();
    private MiniGameBalk godlikeFish = new GodlikeFish();

    private ArrayList<MiniGameBalk> fishArray = new ArrayList<MiniGameBalk>() {{
        add(easyFish);
        add(hardFish);
        add(godlikeFish);
    }};
    public Dobber(Coordinate2D initialLocation, MiniGame miniGame, MiniGameFish miniGameFish, MiniGameBalk miniGameBalk) {
        super("sprites/dobber.png", initialLocation, new Size(25, 60), 1, 1);
        this.miniGame = miniGame;
        this.miniGameFish = miniGameFish;
        this.miniGameBalk = miniGameBalk;
    }

    @Override
    public void onCollision(Collider collider) {
        if (collider instanceof FishShadow) {
            fishArray.get((int) (Math.random() * fishArray.size())).showMiniGameBalk(true);
            System.out.println(fishArray.get((int) (Math.random() * fishArray.size())));
            miniGame.showMiniGame(true);
            miniGameFish.showMiniGameFish(true);
//            miniGameBalk.showMiniGameBalk(true);

            remove();
            ((FishShadow) collider).remove();
            GameScene.inMiniGame = true;
            //GameScene.isFishing = false;
        }
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        remove();
        GameScene.isFishing = false;
    }
}

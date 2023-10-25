package com.github.hanyaeger.FishingSimulator.text;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ScoreText extends TextEntity {

    private int score;

    public ScoreText(Coordinate2D initialLocation, int score){
        super(initialLocation);

        this.score = score;
        setText("Score: " + score);
        setFont(Font.font("Roboto", FontWeight.NORMAL, 30));
        setFill(Color.BLACK);
    }
}

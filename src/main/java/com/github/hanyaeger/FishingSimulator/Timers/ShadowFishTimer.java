package com.github.hanyaeger.FishingSimulator.Timers;

import com.github.hanyaeger.FishingSimulator.entities.FishShadow;
import com.github.hanyaeger.api.Timer;

public class ShadowFishTimer extends Timer {

    private FishShadow fishShadow;

    public ShadowFishTimer(final FishShadow fishShadow, int interval) {
        super(interval);
        this.fishShadow = fishShadow;
    }

    @Override
    public void onAnimationUpdate(final long timestamp) {
        fishShadow.move();
    }
}

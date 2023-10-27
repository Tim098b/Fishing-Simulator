module waterworld {
    requires hanyaeger;

    exports com.github.hanyaeger.FishingSimulator;

    opens audio;
    opens backgrounds;
    opens sprites;
    exports com.github.hanyaeger.FishingSimulator.entities;
    exports com.github.hanyaeger.FishingSimulator.entities.minigame;
    exports com.github.hanyaeger.FishingSimulator.entities.shadow;
    exports com.github.hanyaeger.FishingSimulator.entities.borders;
}

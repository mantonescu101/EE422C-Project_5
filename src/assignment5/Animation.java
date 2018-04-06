package assignment5;

import javafx.animation.AnimationTimer;

public abstract class Animation extends AnimationTimer {

    private long shleep = 0;

    long prevTime = 0;

    public Animation( long sleep) {
        this.shleep = sleep * 1_000_000;
    }

    @Override
    public void handle(long now) {

        if ((now - prevTime) < shleep) {
            return;
        }

        prevTime = now;
        handle();
    }

    public abstract void handle();
}

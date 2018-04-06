package assignment5;

import javafx.scene.paint.Color;

import java.util.*;

public class MyCritter4 extends Critter.TestCritter {

    @Override
    public void doTimeStep() {
        walk(6);
    }

    @Override
    public boolean fight(String opponent) {
        return true;
    }

    public Color viewColor(){ return Color.RED; }

    @Override
    public CritterShape viewShape() {
        return CritterShape.TRIANGLE;
    }

    public String toString() {
        return "4";
    }
}
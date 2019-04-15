package de.guilib.gui;

import processing.core.PApplet;
import processing.core.PFont;

public class FadeText extends Text {

    private int duration;
    private long last;

    public FadeText(String text, int x, int y, int fontSize, int duration, int color) {
        super(text, x, y, fontSize, color);
        this.duration = duration;
        last = System.currentTimeMillis();
    }

    public FadeText(String text, int x, int y, PFont font, int duration, int color) {
        super(text, x, y, font, color);
        this.duration = duration;
        last = System.currentTimeMillis();
    }

    @Override
    public void draw(PApplet pa) {
        super.draw(pa);
        duration -= System.currentTimeMillis() - last;
        last = System.currentTimeMillis();
        if (duration <= 0) {
            handler.remove(this);
        }
    }
}

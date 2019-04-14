package de.guilib.gui;

import processing.core.PApplet;

public class Button extends GUIElement {

    protected String text;

    public Button(String text, int x, int y, int width, int height, GUIHandler handler) {
        super(x, y, width, height, true, handler);
        this.text = text;
    }

    public Button(String text, int x, int y, int width, int height, GUIAction action, GUIHandler handler) {
        super(x, y, width, height, true, handler);
        this.text = text;
        setAction(action);
    }

    @Override
    public void draw(PApplet pa) {
        pa.fill(70);
        pa.rect(x, y, width, height);
        pa.fill(0);
        pa.text(text, x + width / 2, y + height - 32 / 2);
    }

}

package de.guilib.gui;

import processing.core.PApplet;
import processing.core.PFont;

public class Text extends GUIElement {

    private String text;
    private PFont font;
    private int fontSize;
    private int color;

    Text(String text, int x, int y, int fontSize, int color) {
        this(text, x, y, null, color);
        this.fontSize = fontSize;
    }

    Text(String text, int x, int y, PFont font, int color) {
        super(x, y, 0, 0, false);
        handler.pa.textFont(font);
        width = (int) handler.pa.textWidth(text);
        height = (int) (font.getSize() + handler.pa.textDescent());
        handler.pa.textFont(handler.font);
        this.text = text;
        this.font = font;
        this.color = color;
    }

    @Override
    public void draw(PApplet pa) {
        if(font != null)
            pa.textFont(font);
        else
            pa.textSize(fontSize);
        pa.textAlign(PApplet.CENTER);
        pa.fill(color);
        pa.text(text, x, y);
    }

}

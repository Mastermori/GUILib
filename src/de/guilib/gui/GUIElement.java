package de.guilib.gui;

import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

public abstract class GUIElement {

    int x, y;
    int width, height;
    boolean clickable;
    boolean visible;
    protected GUIAction action;
    protected GUIHandler handler;

    public GUIElement(int x, int y, int width, int height, boolean clickable) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.clickable = clickable;
        visible = true;
    }

    public abstract void draw(PApplet pa);

    public void click(PApplet pa) {
        action.execute(pa);
    }

    public void setAction(GUIAction action) {
        this.action = action;
    }

    public boolean overLapping(int x, int y) {
        return x > this.x && y > this.y && x < this.x + width && y < this.y + height;
    }

    protected void setHandler(GUIHandler handler) {
        this.handler = handler;
        if (clickable)
            handler.addClickable(this);
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isClickable() {
        return clickable;
    }

    public void setClickable(boolean clickable) {
        this.clickable = clickable;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }


}

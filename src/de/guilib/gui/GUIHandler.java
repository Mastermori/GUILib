package de.guilib.gui;

import processing.core.PApplet;
import processing.core.PFont;

import java.util.ArrayList;
import java.util.List;

public class GUIHandler {

    private static List<GUIElement> gui;
    private static List<GUIElement> remGui;
    private static List<GUIElement> addGui;

    private List<GUIElement> clickables;
    private List<GUIElement> remClickables;
    protected PApplet pa;

    protected PFont font;

    public GUIHandler(PApplet pa, PFont font){
        gui = new ArrayList<>();
        remGui = new ArrayList<>();
        addGui = new ArrayList<>();
        clickables = new ArrayList<>();
        remClickables = new ArrayList<>();
        this.pa = pa;
        this.font = font;
    }

    public void draw(){
        if (!remGui.isEmpty()) {
            gui.removeAll(remGui);
            remGui.clear();
        }
        if (!addGui.isEmpty()) {
            gui.addAll(addGui);
            addGui.clear();
        }
        for (GUIElement e : gui) {
            e.draw(pa);
        }
    }

    public void mouseClicked(){
        if(!remClickables.isEmpty()) {
            clickables.removeAll(remClickables);
            remClickables.clear();
        }
        for (GUIElement e : clickables) {
            if (e.isVisible() && e.overLapping(pa.mouseX, pa.mouseY)) {
                e.click(pa);
            }
        }
    }

    public void add(GUIElement ge) {
        addGui.add(ge);
        ge.setHandler(this);
    }

    public void remove(GUIElement ge) {
        removeClickable(ge);
        remGui.add(ge);
    }

    public void addClickable(GUIElement ge) {
        clickables.add(ge);
    }

    public void removeClickable(GUIElement ge) {
        remClickables.add(ge);
    }

}

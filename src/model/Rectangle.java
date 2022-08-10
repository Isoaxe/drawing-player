package model;

import sound.MidiSynth;

import java.awt.*;

public class Rectangle extends Shape {
    public Rectangle(Point topLeft, MidiSynth midiSynth) {
        super(topLeft, midiSynth);
        PLAYING_COLOR = new Color(20, 189, 79);
    }

    // EFFECTS: return true if the given y value is within the bounds of the Shape
    public boolean containsY(int y) {
        return (this.y <= y) && (y <= this.y + height);
    }

    // EFFECTS: return true if the given Point (x,y) is contained within the bounds of this Shape
    @Override
    public boolean contains(Point point) {
        return containsX(point.x) && containsY(point.y);
    }

    // EFFECTS: draws the rectangle
    @Override
    protected void drawGraphics(Graphics g) {
        g.drawRect(x, y, width, height);
    }

    // EFFECTS: fills the rectangle
    @Override
    protected void fillGraphics(Graphics g) {
        g.fillRect(x, y, width, height);
    }
}

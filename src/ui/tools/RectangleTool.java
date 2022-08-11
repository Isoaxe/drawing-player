package ui.tools;

import model.Rectangle;
import ui.DrawingEditor;

import javax.swing.*;
import java.awt.event.MouseEvent;

public class RectangleTool extends ShapeTool {
    public RectangleTool(DrawingEditor editor, JComponent parent) {
        super(editor, parent);
    }

    // EFFECTS: Constructs and returns the new rectangle
    private void makeRectangle(MouseEvent e) {
        shape = new Rectangle(e.getPoint(), editor.getMidiSynth());
    }

    // MODIFIES: this
    // EFFECTS:  when MouseEvent occurs a shape is instantiated, is played, and
    //           added to the editor's drawing
    @Override
    public void mousePressedInDrawingArea(MouseEvent e) {
        makeRectangle(e);
        shape.selectAndPlay();
        shape.setBounds(e.getPoint());
        editor.addToDrawing(shape);
    }

    // EFFECTS: Returns the string for the label.
    private String getLabel() {
        return "Rectangle";
    }
}

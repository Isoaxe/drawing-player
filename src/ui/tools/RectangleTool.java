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
    private void makeShape(MouseEvent e) {
        shape = new Rectangle(e.getPoint(), editor.getMidiSynth());
    }
}

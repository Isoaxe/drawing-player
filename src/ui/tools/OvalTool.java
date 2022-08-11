package ui.tools;

import model.Oval;
import ui.DrawingEditor;

import javax.swing.*;
import java.awt.event.MouseEvent;

public class OvalTool extends ShapeTool {
    public OvalTool(DrawingEditor editor, JComponent parent) {
        super(editor, parent);
    }

    // EFFECTS: Constructs and returns the new oval
    private void makeOval(MouseEvent e) {
        shape = new Oval(e.getPoint(), editor.getMidiSynth());
    }

    // MODIFIES: this
    // EFFECTS:  when MouseEvent occurs a shape is instantiated, is played, and
    //           added to the editor's drawing
    @Override
    public void mousePressedInDrawingArea(MouseEvent e) {
        makeOval(e);
        shape.selectAndPlay();
        shape.setBounds(e.getPoint());
        editor.addToDrawing(shape);
    }

    // EFFECTS: Returns the string for the label.
    @Override
    protected String getLabel() {
        return "Oval";
    }

    // MODIFIES: this
    // EFFECTS:  creates new button and adds to parent
    @Override
    protected void createButton(JComponent parent) {
        button = new JButton(getLabel());
        button = customizeButton(button);
    }
}

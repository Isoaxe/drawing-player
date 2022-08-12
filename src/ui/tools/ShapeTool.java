package ui.tools;

import model.Oval;
import model.Rectangle;
import model.Shape;
import ui.DrawingEditor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class ShapeTool extends Tool {
	protected Shape shape;
    private String label;

    public ShapeTool(DrawingEditor editor, JComponent parent, String label) {
		super(editor, parent);
		shape = null;
        this.label = label;
	}

    // MODIFIES: this
    // EFFECTS:  associate button with new ClickHandler
	@Override
	protected void addListener() {
		button.addActionListener(new ShapeToolClickHandler());
	}

	// MODIFIES: this
    // EFFECTS:  unselects this shape, and sets it to null
	@Override
	public void mouseReleasedInDrawingArea(MouseEvent e) {
        shape.unselectAndStopPlaying();
	    shape = null;
	}

	// MODIFIES: this
    // EFFECTS:  sets the bounds of thes shape to where the mouse is dragged to
	@Override
	public void mouseDraggedInDrawingArea(MouseEvent e) {
		shape.setBounds(e.getPoint());
	}

	private class ShapeToolClickHandler implements ActionListener {
		// EFFECTS: sets active tool to the shape tool
		//          called by the framework when the tool is clicked
    	@Override
		public void actionPerformed(ActionEvent e) {
			editor.setActiveTool(ShapeTool.this);
		}
	}

    // EFFECTS: Constructs and returns the new shape
    private void makeShape(MouseEvent e) {
        if (label == "Rectangle") {
            shape = new Rectangle(e.getPoint(), editor.getMidiSynth());
        } else if (label == "Oval") {
            shape = new Oval(e.getPoint(), editor.getMidiSynth());
        } else {
            shape = null;
        }
    }

    // MODIFIES: this
    // EFFECTS:  when MouseEvent occurs a shape is instantiated, is played, and
    //           added to the editor's drawing
    public void mousePressedInDrawingArea(MouseEvent e) {
        makeShape(e);
        shape.selectAndPlay();
        shape.setBounds(e.getPoint());
        editor.addToDrawing(shape);
    }

    // MODIFIES: this
    // EFFECTS:  creates new button and adds to parent
    protected void createButton(JComponent parent) {
        System.out.println(label);
        button = new JButton(label);
        button = customizeButton(button);
    }
}


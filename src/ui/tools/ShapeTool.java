package ui.tools;

import model.Shape;
import ui.DrawingEditor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class ShapeTool extends Tool {
	protected Shape shape;

    public ShapeTool(DrawingEditor editor, JComponent parent) {
		super(editor, parent);
		shape = null;
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
}


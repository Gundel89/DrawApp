package com.softgroup.model.handler;

import java.util.ArrayList;

import com.softgroup.model.Shape;

import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;

public class SelectShapeEventHandler extends AbstractShapeEventHandler {

	public SelectShapeEventHandler(ArrayList<Shape> shapes, Canvas canvas) {
		super(shapes, canvas);
	}

	@Override
	public void handle(MouseEvent event) {
		shapes.forEach(s -> s.setSelected(false));
		selectedShape = null;
		for(Shape shape : shapes) {
			if(shape.isMouseInShapesArea(event.getSceneX(), event.getSceneY())) {
				shape.setSelected(true);
				selectedShape = shape;
				break;
			}
		}
		render();
	}

}

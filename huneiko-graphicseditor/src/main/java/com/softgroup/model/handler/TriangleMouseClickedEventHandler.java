package com.softgroup.model.handler;

import java.util.ArrayList;

import com.softgroup.model.Shape;
import com.softgroup.model.Triangle;

import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;

public class TriangleMouseClickedEventHandler extends AbstractShapeEventHandler {

	public TriangleMouseClickedEventHandler(ArrayList<Shape> shapes, Canvas canvas) {
		super(shapes, canvas);
	}

	@Override
	public void handle(MouseEvent event) {
		if(currentShape == null) {
			currentShape = new Triangle(
					event.getSceneX(), event.getSceneY(),
					event.getSceneX(), event.getSceneY(),
					event.getSceneX(), event.getSceneY()
			);
		} else {
			if(currentShape.getClicks() == 1) {
				shapes.add(currentShape);
				currentShape = null;
			}
		}
		if(currentShape != null) {
			currentShape.decrementClicks();
		}
	}
}

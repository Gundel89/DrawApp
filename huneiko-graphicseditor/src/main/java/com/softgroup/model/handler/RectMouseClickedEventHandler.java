package com.softgroup.model.handler;

import java.util.ArrayList;

import com.softgroup.model.Point;
import com.softgroup.model.Rectangle;
import com.softgroup.model.Shape;

import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;

public class RectMouseClickedEventHandler extends AbstractShapeEventHandler {

	public RectMouseClickedEventHandler(ArrayList<Shape> shapes, Canvas canvas) {
		super(shapes, canvas);
	}

	@Override
	public void handle(MouseEvent event) {
		if(currentShape == null) {
			currentShape = new Rectangle(
					event.getSceneX(), event.getSceneY(),
					event.getSceneX(), event.getSceneY()
			);
		} else {
			Point pointB = currentShape.getPoints().get(1);
			pointB.setX(event.getSceneX());
			pointB.setY(event.getSceneY());
			
			shapes.add(currentShape);
			currentShape = null;
			render();
		}
	}

}

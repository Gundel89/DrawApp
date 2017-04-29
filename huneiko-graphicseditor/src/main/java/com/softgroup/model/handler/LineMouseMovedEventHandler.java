package com.softgroup.model.handler;

import java.util.ArrayList;

import com.softgroup.model.Point;
import com.softgroup.model.Shape;

import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;

public class LineMouseMovedEventHandler extends AbstractShapeEventHandler {

	public LineMouseMovedEventHandler(ArrayList<Shape> shapes, Canvas canvas) {
		super(shapes, canvas);
	}

	@Override
	public void handle(MouseEvent event) {
		if(currentShape != null) {
			/*Line line = (Line) currentShape;
			line.setPointB(new Point(event.getSceneX(), event.getSceneY()));*/
			Point pointB = currentShape.getPoints().get(1);
			pointB.setX(event.getSceneX());
			pointB.setY(event.getSceneY());
			render();
		}
	}

}

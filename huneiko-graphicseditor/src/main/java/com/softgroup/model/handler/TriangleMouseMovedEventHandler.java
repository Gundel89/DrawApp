package com.softgroup.model.handler;

import java.util.ArrayList;

import com.softgroup.model.Point;
import com.softgroup.model.Shape;

import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;

public class TriangleMouseMovedEventHandler extends AbstractShapeEventHandler {

	public TriangleMouseMovedEventHandler(ArrayList<Shape> shapes, Canvas canvas) {
		super(shapes, canvas);
	}

	@Override
	public void handle(MouseEvent event) {
		if(currentShape != null) {
			if(currentShape.getClicks() == 2) {
				Point pointB = currentShape.getPoints().get(1);
				Point pointC = currentShape.getPoints().get(2);
				
				pointB.setX(event.getSceneX());
				pointB.setY(event.getSceneY());
				pointC.setX(event.getSceneX());
				pointC.setY(event.getSceneY());
			} else {
				Point pointC = currentShape.getPoints().get(2);
				
				pointC.setX(event.getSceneX());
				pointC.setY(event.getSceneY());
			}
			render();
		}
	}

}

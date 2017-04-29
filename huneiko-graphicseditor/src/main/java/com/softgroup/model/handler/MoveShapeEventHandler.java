package com.softgroup.model.handler;

import java.util.ArrayList;

import com.softgroup.model.Shape;

import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;

public class MoveShapeEventHandler extends AbstractShapeEventHandler {

	public MoveShapeEventHandler(ArrayList<Shape> shapes, Canvas canvas) {
		super(shapes, canvas);
	}

	@Override
	public void handle(MouseEvent event) {
		if(selectedShape != null) {
			selectedShape.moveTo(event.getSceneX(), event.getSceneY());
		}
		render();
	}

}

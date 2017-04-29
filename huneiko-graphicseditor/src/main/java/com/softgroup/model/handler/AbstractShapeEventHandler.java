package com.softgroup.model.handler;

import java.util.ArrayList;

import com.softgroup.model.Shape;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

public abstract class AbstractShapeEventHandler implements EventHandler<MouseEvent> {
	
	protected static Shape currentShape;
	protected static Shape selectedShape;
	protected static ArrayList<Shape> shapes;
	protected static Canvas canvas;
	
	public AbstractShapeEventHandler(ArrayList<Shape> shapes, Canvas canvas) {
		this.shapes = shapes;
		this.canvas = canvas;
	}
	
	protected void render() {
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		
		shapes.forEach(s -> s.draw(gc));
		
		if(currentShape != null) {
			currentShape.draw(gc);
		}
	}
	
	public static void setSelectNull() {
		shapes.forEach(s -> s.setSelected(false));
		selectedShape = null;
	}
}

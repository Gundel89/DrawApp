package com.softgroup.model;

import javafx.scene.canvas.GraphicsContext;

public class Rectangle extends Line {
	
	public Rectangle(double xA, double yA, double xB, double yB) {
		super(xA, yA, xB, yB);
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		gc.setStroke(borderColor);
		Point pointA = points.get(0);
		Point pointB = points.get(1);
		gc.strokeRect(pointA.getX(), pointA.getY(),
				Math.abs(pointB.getX() - pointA.getX()),
				Math.abs(pointB.getY() - pointA.getY()));
		
		if(isSelected) {
			points.forEach(p -> p.draw(gc));
		}
	}
}

package com.softgroup.model;

import javafx.scene.canvas.GraphicsContext;

public class Circle extends Line {
	
	public Circle(double xA, double yA, double xB, double yB) {
		super(xA, yA, xB, yB);
	}

	@Override
	public void draw(GraphicsContext gc) {
		gc.setStroke(borderColor);
		Point pointA = points.get(0);
		Point pointB = points.get(1);
		gc.strokeOval(pointA.getX(), pointA.getY(),
				Math.abs(pointB.getX() - pointA.getX()),
				Math.abs(pointB.getX() - pointA.getX())
		);
		if(isSelected) {
			points.forEach(p -> p.draw(gc));
		}
	}

}

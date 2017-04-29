package com.softgroup.model;

import javafx.scene.canvas.GraphicsContext;

public class Line extends Shape {
	
	public Line() {
		this(0, 0, 0, 0);
	}
	
	public Line(double xA, double yA, double xB, double yB) {
		super();
		addPoint(xA, yA);
		addPoint(xB, xB);
	}

	@Override
	public void draw(GraphicsContext gc) {
		gc.setStroke(borderColor);
		Point pointA = points.get(0);
		Point pointB = points.get(1);
		gc.strokeLine(pointA.getX(), pointA.getY(), pointB.getX(), pointB.getY());
		
		if(isSelected) {
			points.forEach(p -> p.draw(gc));
		}
	}

	@Override
	public boolean isMouseInShapesArea(double x, double y) {
		double smallestX = points.get(0).getX();
		double biggestX = points.get(0).getX();
		double smallestY = points.get(0).getY();
		double biggestY = points.get(0).getY();
		
		for(Point p : points) {
			if(smallestX > p.getX()) {
				smallestX = p.getX();
			}
			if(biggestX < p.getX()) {
				biggestX = p.getX();
			}
			if(smallestY > p.getY()) {
				smallestY = p.getY();
			}
			if(biggestY < p.getY()) {
				biggestY = p.getY();
			}
		}
		return x > smallestX && x < biggestX && y > smallestY && y < biggestY;
	}

	@Override
	public void moveTo(double x, double y) {
		double distanceABX = points.get(0).getX() - points.get(1).getX();
		double distanceABY = points.get(0).getY() - points.get(1).getY();
		
		points.get(0).setX(x);
		points.get(0).setY(y);
		points.get(1).setX(points.get(0).getX() - distanceABX);
		points.get(1).setY(points.get(0).getY() - distanceABY);
	}
}

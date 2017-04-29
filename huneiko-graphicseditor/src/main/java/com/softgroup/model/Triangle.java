package com.softgroup.model;

import javafx.scene.canvas.GraphicsContext;

public class Triangle extends Shape {
	
	public Triangle(double xA, double yA, double xB, double yB, double xC, double yC) {
		addPoint(xA, yA);
		addPoint(xB, yB);
		addPoint(xC, yC);
		clicks = 3;
	}

	@Override
	public void draw(GraphicsContext gc) {
		double[] xPoints = {
				points.get(0).getX(), points.get(1).getX(), points.get(2).getX()
		};
		double[] yPoints = {
				points.get(0).getY(), points.get(1).getY(), points.get(2).getY()
		};
		gc.strokePolygon(xPoints, yPoints, 3);
		
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
		double distanceACX = points.get(0).getX() - points.get(2).getX();
		double distanceACY = points.get(0).getY() - points.get(2).getY();
		
		points.get(0).setX(x);
		points.get(0).setY(y);
		points.get(1).setX(points.get(0).getX() - distanceABX);
		points.get(1).setY(points.get(0).getY() - distanceABY);
		points.get(2).setX(points.get(0).getX() - distanceACX);
		points.get(2).setY(points.get(0).getY() - distanceACY);
		
		/*double distanceAX = x - points.get(0).getX();
		double distanceAY = y - points.get(0).getY();*/
	}
	
}

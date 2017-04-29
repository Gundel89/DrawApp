package com.softgroup.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Point {
	
	private double x;
	private double y;
	
	public Point() {
		this(0, 0);
	}
	
	public Point(double x, double y) {
		this.setX(x);
		this.setY(y);
	}
	
	public void draw(GraphicsContext gc) {
		gc.setFill(Color.BLUE);
		gc.strokeRect(x - 3, y - 3, 6, 6);
	}
	
	public double getX() {
		return x;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public double getY() {
		return y;
	}
	
	public void setY(double y) {
		this.y = y;
	}
}

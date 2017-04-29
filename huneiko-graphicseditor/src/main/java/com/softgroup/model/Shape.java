package com.softgroup.model;

import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Shape {
	
	protected ArrayList<Point> points;
	
	protected int clicks;
	protected boolean isSelected;
	
	protected Color fillColor = Color.WHITE;
	protected Color borderColor = Color.BLACK;
	
	public Shape() {
		points = new ArrayList<>();
	}
	
	public abstract void draw(GraphicsContext gc);
	public abstract boolean isMouseInShapesArea(double x, double y);
	public abstract void moveTo(double x, double y);
	
	public void addPoint(double x, double y) {
		points.add(new Point(x, y));
	}
	
	public void decrementClicks() {
		--clicks;
	}
	
	public boolean isSelected() {
		return isSelected;
	}
	
	public void setSelected(boolean value) {
		isSelected = value;
	}
	
	public int getClicks() {
		return clicks;
	}
	
	public ArrayList<Point> getPoints() {
		return points;
	}
	
	public Color getFillColor() {
		return fillColor;
	}
	
	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}
	
	public Color getBorderColor() {
		return borderColor;
	}
	
	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}
}

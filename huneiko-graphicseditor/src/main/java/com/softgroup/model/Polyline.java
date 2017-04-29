package com.softgroup.model;

import java.util.LinkedList;

import javafx.scene.canvas.GraphicsContext;

public class Polyline extends Shape {
	
	protected LinkedList<Line> lines;
	
	public Polyline() {
		lines = new LinkedList<>();
	}
	
	public void addLine(Line line) {
		lines.add(line);
	}

	@Override
	public void draw(GraphicsContext gc) {
		for(Line l : lines) {
			l.draw(gc);
		}
	}

	@Override
	public boolean isMouseInShapesArea(double x, double y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void moveTo(double x, double y) {
		// TODO Auto-generated method stub
		
	}
}

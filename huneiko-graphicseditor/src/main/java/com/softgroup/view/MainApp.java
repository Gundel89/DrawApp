package com.softgroup.view;

import java.util.ArrayList;

import com.softgroup.model.Shape;
import com.softgroup.model.handler.AbstractShapeEventHandler;
import com.softgroup.model.handler.CircleMouseClickedEventHandler;
import com.softgroup.model.handler.LineMouseClickedEventHandler;
import com.softgroup.model.handler.LineMouseMovedEventHandler;
import com.softgroup.model.handler.MoveShapeEventHandler;
import com.softgroup.model.handler.RectMouseClickedEventHandler;
import com.softgroup.model.handler.SelectShapeEventHandler;
import com.softgroup.model.handler.TriangleMouseClickedEventHandler;
import com.softgroup.model.handler.TriangleMouseMovedEventHandler;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainApp extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	private ArrayList<Shape> shapes = new ArrayList<>();
	private Shape selectedShape = null;
	private Canvas canvas = new Canvas(800, 500);
	private GridPane layout = new GridPane();
	private StackPane root = new StackPane();
	private Scene scene = new Scene(root, 800, 500);
	
	ToggleButton btnLine = new ToggleButton("Line");
	ToggleButton btnTriangle = new ToggleButton("Triangle");
	ToggleButton btnRect = new ToggleButton("Rect");
	ToggleButton btnCircle = new ToggleButton("Circle");
	Button btnReset = new Button("Reset");
	
	@Override
	public void start(Stage stage) throws Exception {
		
		ToggleGroup tg = new ToggleGroup();
		
		btnLine.setToggleGroup(tg);
		btnTriangle.setToggleGroup(tg);
		btnRect.setToggleGroup(tg);
		btnCircle.setToggleGroup(tg);
		
		initHandlers();
		
		ToolBar tb = new ToolBar(btnLine, btnTriangle, btnRect, btnCircle, btnReset);
		tb.setOrientation(Orientation.VERTICAL);
		
		layout.addRow(0, tb);
		layout.setHgap(20);
		layout.setAlignment(Pos.TOP_RIGHT);
		
		root.getChildren().addAll(canvas, layout);
		
		stage.setScene(scene);
		stage.show();
	}
	
	private void initHandlers() {
		LineMouseClickedEventHandler lineClick = new LineMouseClickedEventHandler(shapes, canvas);
		LineMouseMovedEventHandler lineMove = new LineMouseMovedEventHandler(shapes, canvas);
		TriangleMouseClickedEventHandler triangleClick = new TriangleMouseClickedEventHandler(shapes, canvas);
		TriangleMouseMovedEventHandler triangleMove = new TriangleMouseMovedEventHandler(shapes, canvas);
		RectMouseClickedEventHandler rectClick = new RectMouseClickedEventHandler(shapes, canvas);
		CircleMouseClickedEventHandler circleClick = new CircleMouseClickedEventHandler(shapes, canvas);
		SelectShapeEventHandler selectClick = new SelectShapeEventHandler(shapes, canvas);
		MoveShapeEventHandler moveShape = new MoveShapeEventHandler(shapes, canvas);
		
		scene.setOnMouseDragged(moveShape);
		btnLine.setOnAction(e -> {
			if(!btnLine.isSelected()) {
				scene.setOnMouseClicked(selectClick);
				scene.setOnMouseMoved(x -> {});
			} else {
				AbstractShapeEventHandler.setSelectNull();
				scene.setOnMouseClicked(lineClick);
				scene.setOnMouseMoved(lineMove);
			}
		});
		btnTriangle.setOnAction(e -> {
			if(!btnTriangle.isSelected()) {
				scene.setOnMouseClicked(selectClick);
				scene.setOnMouseMoved(x -> {});
			} else {
				AbstractShapeEventHandler.setSelectNull();
				scene.setOnMouseClicked(triangleClick);
				scene.setOnMouseMoved(triangleMove);
			}
		});
		btnRect.setOnAction(e -> {
			if(!btnRect.isSelected()) {
				scene.setOnMouseClicked(selectClick);
				scene.setOnMouseMoved(x -> {});
			} else {
				AbstractShapeEventHandler.setSelectNull();
				scene.setOnMouseClicked(rectClick);
				scene.setOnMouseMoved(lineMove);
			}
		});
		btnCircle.setOnAction(e -> {
			if(!btnCircle.isSelected()) {
				scene.setOnMouseClicked(selectClick);
				scene.setOnMouseMoved(x -> {});
			} else {
				AbstractShapeEventHandler.setSelectNull();
				scene.setOnMouseClicked(circleClick);
				scene.setOnMouseMoved(lineMove);
			}
		});
		btnReset.setOnAction(e -> {
			canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
			AbstractShapeEventHandler.setSelectNull();
			shapes.clear();
		});
	}
}

package com.selesdepselesnul.raysnake;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class SnakeSprite extends Rectangle {
	
	private enum Direction {
		UP, RIGHT, BOTTOM, LEFT;
	}

	private Direction direction = Direction.RIGHT;
	private Stage parentStage;
	private double speed;
	private int count = 0;
	
	public SnakeSprite(Stage parentStage, double speed) {
		super(40, 10, 20, 10);
		this.parentStage = parentStage;
		this.speed = speed;
		this.parentStage.getScene()
						.setOnKeyPressed(e -> {
			switch (e.getCode()) {
			case UP:
				this.setRotate(270.0);
				direction = Direction.UP;
				break;
			case DOWN:
				this.setRotate(90.0);
				direction = Direction.BOTTOM;
				break;
			case LEFT:
				this.setRotate(180.0);
				direction = Direction.LEFT;
				break;
			case RIGHT:
				this.setRotate(0.0);
				direction = Direction.RIGHT;
				break;
			default:
				break;
			}
		});
	}

	public void update() {
		handleEdge();
		handleDirection();
	}

	private void handleDirection() {
		if(direction == Direction.UP)
			this.setTranslateY(this.getTranslateY() - speed);
		else if(direction == Direction.RIGHT)
			this.setTranslateX(this.getTranslateX() + speed);
		else if(direction == Direction.BOTTOM)
			this.setTranslateY(this.getTranslateY() + speed);
		else
			this.setTranslateX(this.getTranslateX() - speed);	
	}

	private void handleEdge() {
		if(Math.floor(this.getTranslateX()) >= parentStage.getWidth())
			this.setTranslateX(-this.getWidth());
		else if(Math.floor(this.getTranslateY()) >= parentStage.getHeight())
			this.setTranslateY(-this.getWidth());
		else if(Math.floor(this.getTranslateX()) <= -this.getWidth()*4)
			this.setTranslateX(parentStage.getWidth() - this.getWidth());
		else if(Math.floor(this.getTranslateY()) <= -this.getWidth()*4)
			this.setTranslateY(parentStage.getHeight());
	}

	public void collade(Circle food) {
		if(this.getTranslateX() >= food.getCenterX() - food.getRadius()
			&& this.getTranslateX() <= food.getCenterX() + food.getRadius()
			&& this.getTranslateY() >= food.getCenterY() - food.getRadius()
			&& this.getTranslateY() <= food.getCenterY() + food.getRadius())
			System.out.println("collade" + ++count);
	}

}

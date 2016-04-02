package com.selesdepselesnul.snake;
	
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;

enum Direction {
	UP, RIGHT, DOWN, LEFT
}

public class Main extends Application {
	
	private Rectangle snake = new Rectangle(40, 10, 20, 10);
	private double velocity = 4;
	private Direction direction = Direction.RIGHT;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Group root = new Group();
			
			root.getChildren().add(snake);
			Scene scene = new Scene(root);
			scene.setOnKeyPressed(e -> {
				switch (e.getCode()) {
				case UP:
					snake.setRotate(90.0);
					direction = Direction.UP;
					break;
				case DOWN:
					snake.setRotate(90.0);
					direction = Direction.DOWN;
					break;
				case LEFT:
					snake.setRotate(0.0);
					direction = Direction.LEFT;
					break;
				case RIGHT:
					snake.setRotate(0.0);
					direction = Direction.RIGHT;
					break;
				default:
					break;
				}
			});
			new AnimationTimer() {
				
				@Override
				public void handle(long now) {
			
					if(Math.floor(snake.getTranslateX()) >= primaryStage.getWidth())
						snake.setTranslateX(-snake.getWidth());
					else if(Math.floor(snake.getTranslateY()) >= primaryStage.getHeight())
						snake.setTranslateY(-snake.getWidth());
					else if(Math.floor(snake.getTranslateX()) <= -snake.getWidth()*4)
						snake.setTranslateX(primaryStage.getWidth() - snake.getWidth());
					else if(Math.floor(snake.getTranslateY()) <= -snake.getWidth()*4)
						snake.setTranslateY(primaryStage.getHeight());
					
					if(direction == Direction.UP)
						snake.setTranslateY(snake.getTranslateY() - velocity);
					else if(direction == Direction.RIGHT)
						snake.setTranslateX(snake.getTranslateX() + velocity);
					else if(direction == Direction.DOWN)
						snake.setTranslateY(snake.getTranslateY() + velocity);
					else
						snake.setTranslateX(snake.getTranslateX() - velocity);
				}
			}.start();
			primaryStage.setScene(scene);
			primaryStage.setWidth(600);
			primaryStage.setHeight(600);
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	public static void main(String[] args) {
		launch(args);
	}
}

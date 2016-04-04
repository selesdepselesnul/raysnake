package com.selesdepselesnul.raysnake;
	
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;


public class Main extends Application {
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
	
			Group root = new Group();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			SnakeSprite snakeSprite = new SnakeSprite(primaryStage, 4.0);
			root.getChildren().add(snakeSprite);
					
			new AnimationTimer() {
				
				@Override
				public void handle(long now) {
					
					snakeSprite.update();
			
	
				}
			}.start();
			
	
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

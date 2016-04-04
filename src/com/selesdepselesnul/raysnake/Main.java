package com.selesdepselesnul.raysnake;
	
import java.util.Random;

import com.sun.javafx.geom.Path2D;
import com.sun.javafx.sg.prism.NGPath;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathElement;


public class Main extends Application {
	
	
	@Override
	public void start(Stage primaryStage) {
		
		try {
			
			primaryStage.setWidth(600);
			primaryStage.setHeight(600);
			Group root = new Group();
			Scene scene = new Scene(root);
			Random random = new Random();
			Circle food = new Circle(
					random.nextDouble() * primaryStage.getWidth() + 4, 
					random.nextDouble() * primaryStage.getHeight() + 4,
					4, 
					Color.RED);
			primaryStage.setScene(scene);
			SnakeSprite snakeSprite = new SnakeSprite(primaryStage, 4.0);
			root.getChildren().addAll(snakeSprite, food);
					
			new AnimationTimer() {
				
				@Override
				public void handle(long now) {
					
					snakeSprite.update();
					snakeSprite.collade(food);
	
				}
			}.start();
			
	
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

package it.edu.iisgubbio.animazioni;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TelaPallina extends Application{
	
	Canvas tela = new Canvas(400, 400);
	GraphicsContext gc = tela.getGraphicsContext2D();
	int x = 0;
	
	public void start(Stage finestra) throws Exception {
		
		gc.setFill(Color.BLACK);
		gc.fillOval(0, 0, 15, 15);
		
		GridPane griglia = new GridPane();
		griglia.add(tela, 0, 0);
		
		Scene scene = new Scene(griglia);
		finestra.setTitle("Timer"); 
		finestra.setScene(scene);
		finestra.show();
		Timeline timeline = new Timeline(new KeyFrame(
		Duration.seconds(0.1), 
		x -> aggiornaPallina()));
	    timeline.setCycleCount(200);
	    timeline.play();
	}
	

	private void aggiornaPallina() {
		
		gc.setFill(Color.WHITE);
		gc.fillOval(x, 0-2.5, 20, 20);
		x+= 10;
		gc.setFill(Color.BLACK);
		gc.fillOval(x, 0, 15, 15);
		
		}
	
	public static void main(String[] args) {
		launch(args);
	}
}

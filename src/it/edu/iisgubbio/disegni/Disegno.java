package it.edu.iisgubbio.disegni;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Disegno extends Application{
	
	Button pNero = new Button("nero");
	Canvas tela = new Canvas(400, 300);
	GraphicsContext gc = tela.getGraphicsContext2D();
	
	public void start(Stage finestra) throws Exception {
			
		gc.setFill(Color.RED);
		gc.fillOval(0, 0, 150, 150);
		gc.setFill(Color.BLUE);
		gc.fillOval(300, 200, 100, 100);
		gc.setStroke(Color.GREEN);
	    gc.setLineWidth(50);
	    gc.strokeLine(0, 300, 400, 0);
	    gc.setStroke(Color.ORANGE);
	    gc.setLineWidth(5);
	    gc.strokeOval(250, 0, 150, 50);
	    
		GridPane pannello = new GridPane();
		pannello.add(pNero, 0, 1);
		pannello.add(tela, 0, 0);
		Scene scene = new Scene(pannello);
		finestra.setTitle("Disegno");
		finestra.setScene(scene);
		finestra.show();
		pNero.setOnAction( e -> eseguiNero());
		
	}
	
	private void eseguiNero() {
		
		gc.setFill(Color.BLACK);
		gc.fillOval(38, 38, 75, 75);
	}

	public static void main(String[] args) {
		launch(args);
	
}

}

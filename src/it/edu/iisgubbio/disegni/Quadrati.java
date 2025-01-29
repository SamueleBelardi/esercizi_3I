package it.edu.iisgubbio.disegni;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Quadrati extends Application {
	
	Button pDisegna = new Button("disegna");
	Canvas tela = new Canvas(400, 400);
	GraphicsContext gc = tela.getGraphicsContext2D();
	double z = 0;
	
	public void start(Stage finestra) throws Exception {
		
		GridPane pannello = new GridPane();
		pannello.add(pDisegna, 0, 1);
		pannello.add(tela, 0, 0, 3, 1);
		pannello.setMaxWidth(Integer.MAX_VALUE);
		pDisegna.setId("button");
		pannello.setId("sfondo");
	
		Scene scene = new Scene(pannello);
		scene.getStylesheets().add("it/edu/iisgubbio/disegni/stileDue.css");
		finestra.setTitle("Griglia");
		finestra.setScene(scene);
		finestra.show();
		pDisegna.setOnAction( e -> eseguiDisegna());
		
	}

	private void eseguiDisegna() {
		
		double dimensione;
		
		dimensione = 10;
		System.out.println(z);
		for( int y = 0; y <= 400; y+= dimensione+1) {
			for( int x = 0; x <= 400; x+= dimensione+1) {
				z = Math.random();
				if (z>0.5) {
					gc.setFill(Color.YELLOW);
				} else {
					gc.setFill(Color.BLUE);
				}
				gc.fillRect(x, y, dimensione, dimensione);
			}
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

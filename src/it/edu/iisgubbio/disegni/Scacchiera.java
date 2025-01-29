package it.edu.iisgubbio.disegni;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Scacchiera extends Application {
	Label eDimensione = new Label("dimensione");
	TextField cDimensione = new TextField();
	Button pDisegna = new Button("disegna");
	Canvas tela = new Canvas(400, 400);
	GraphicsContext gc = tela.getGraphicsContext2D();
	
	public void start(Stage finestra) throws Exception {
		
		GridPane pannello = new GridPane();
		pannello.add(eDimensione, 0, 0);
		pannello.add(cDimensione, 1, 0);
		pannello.add(pDisegna, 2, 0);
		pannello.add(tela, 0, 1, 3, 1);
		pannello.setMaxWidth(Integer.MAX_VALUE);
		eDimensione.setId("label");
		cDimensione.setId("textfield");
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
		
		int dimensione;
		
		dimensione = Integer.parseInt(cDimensione.getText());
		gc.setFill(Color.BLACK);
		for( int y = 0; y <= 400; y+= dimensione+1) {
			for( int x = 0; x <= 400; x+= dimensione+1) {
				gc.fillRect(x, y, dimensione, dimensione);
			}
		}
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}

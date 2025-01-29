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

public class Griglia extends Application {
	
	Label eDistanza = new Label("distanza");
	TextField cDistanza = new TextField();
	Button pDisegna = new Button("disegna");
	Button pPulisci = new Button("pulisci");
	Canvas tela = new Canvas(300, 300);
	GraphicsContext gc = tela.getGraphicsContext2D();
	
	public void start(Stage finestra) throws Exception {
		
		GridPane pannello = new GridPane();
		pannello.add(eDistanza, 0, 0);
		pannello.add(cDistanza, 1, 0);
		pannello.add(pDisegna, 2, 0);
		pannello.add(pPulisci, 3, 0);
		pannello.add(tela, 0, 1, 4, 1);
		pannello.setMaxWidth(Integer.MAX_VALUE);
		eDistanza.setId("label");
		cDistanza.setId("textfield");
		pDisegna.getStyleClass().add("button");
		pPulisci.getStyleClass().add("button");
		pannello.setId("sfondo");
				
		Scene scene = new Scene(pannello);
		scene.getStylesheets().add("it/edu/iisgubbio/disegni/stile.css");
		finestra.setTitle("Griglia");
		finestra.setScene(scene);
		finestra.show();
		pDisegna.setOnAction( e -> eseguiDisegna());
		pPulisci.setOnAction( e -> eseguiPulisci());
	}

	private void eseguiPulisci() {
		
		gc.setFill(Color.WHITE);
		gc.fillRect(0, 0, 300, 300);
	}

	private void eseguiDisegna() {
		
		double distanza;
		
		distanza = Integer.parseInt(cDistanza.getText());
		gc.setStroke(Color.GREEN);
	    gc.setLineWidth(5);
		for( int n = 0; n <= 300 ; n+= distanza) {
		    gc.strokeLine(n, 0, n, 300);
		    gc.strokeLine(0, n, 300, n);
		}
	}
	public static void main(String[] args) {
		launch(args);
	}

}

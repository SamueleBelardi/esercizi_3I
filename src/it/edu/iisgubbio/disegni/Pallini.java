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

public class Pallini extends Application {
	
	Label eNumero = new Label("numero");
	TextField cNumero = new TextField();
	Button pVai = new Button("vai");
	Canvas tela = new Canvas(400, 400);
	GraphicsContext gc = tela.getGraphicsContext2D();
	
	public void start(Stage finestra) throws Exception {
		
		GridPane pannello = new GridPane();
		pannello.add(eNumero, 0, 0);
		pannello.add(cNumero, 1, 0);
		pannello.add(pVai, 2, 0);
		pannello.add(tela, 0, 1, 3, 1);
		pannello.setMaxWidth(Integer.MAX_VALUE);
		eNumero.setId("label");
		cNumero.setId("textfield");
		pVai.setId("button");
		pannello.setId("sfondo");
		
		Scene scene = new Scene(pannello);
		scene.getStylesheets().add("it/edu/iisgubbio/disegni/stileDue.css");
		finestra.setTitle("Griglia");
		finestra.setScene(scene);
		finestra.show();
		pVai.setOnAction( e -> eseguiDisegna());
	
	}

	private void eseguiDisegna() {
		
		int numero, dimensione, distanza;
		
		numero = Integer.parseInt(cNumero.getText());
		dimensione = 10;
		distanza = 20;
		gc.setFill(Color.BLACK);
		for( int y = 0; y < numero; y++) {
			for( int x = 0; x < numero-y; x++) {
				gc.fillOval(x*distanza, y*distanza, dimensione, dimensione);
			}
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}


package it.edu.iisgubbio.disegni;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Disco extends Application {
	
	Button pAggiungi = new Button("aggiungi");
	Canvas tela = new Canvas(400, 200);
	GraphicsContext gc = tela.getGraphicsContext2D();
	int dimensione = 20;
	int contatore = 0;
	int contatoreDue = 0;

	
	public void start(Stage finestra) throws Exception {
		
		GridPane pannello = new GridPane();
		pannello.add(pAggiungi, 0, 0);
		pannello.add(tela, 0, 1);
		pAggiungi.setId("button");
		pannello.setId("sfondo");
		
		Scene scene = new Scene(pannello);
		scene.getStylesheets().add("it/edu/iisgubbio/disegni/stileDue.css");
		finestra.setTitle("Disco");
		finestra.setScene(scene);
		finestra.show();
		pAggiungi.setOnAction( e -> eseguiAggiungi());
	}

	private void eseguiAggiungi() {
		
		int dim ;
		
		dim = dimensione;
		gc.setFill(Color.RED);
		if(contatore<10) {
			gc.fillOval(dimensione*contatore, 0, dimensione, dimensione);
		} else {
			gc.fillOval(dim*contatoreDue, dimensione, dimensione, dimensione);
			contatoreDue++;
		}
		contatore++;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

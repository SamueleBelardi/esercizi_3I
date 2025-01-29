package it.edu.iisgubbio.negozi;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Panini extends Application {
	
	Label ePersone = new Label("persone");
	Label ePrezzo = new Label("prezzo");
	Label eCosto = new Label("??");
	Label eSconto = new Label("scontato");
	Label ePrezzoScontato = new Label("??"); 
	TextField cPersone = new TextField();
	TextField cPrezzo = new TextField();
	Button pTotale = new Button("totale");
	
	public void start(Stage finestra) throws Exception {
		
		GridPane griglia = new GridPane();
		griglia.add(ePersone, 0, 0);
		griglia.add(ePrezzo, 0, 1);
		griglia.add(eCosto, 1, 2);
		griglia.add(eSconto, 0, 3);
		griglia.add(ePrezzoScontato, 1, 3);
		griglia.add(cPersone, 1, 0);
		griglia.add(cPrezzo, 1, 1);
		griglia.add(pTotale, 0, 2);
		ePersone.getStyleClass().add("label");
		ePrezzo.getStyleClass().add("label");
		eSconto.getStyleClass().add("label");
		cPersone.getStyleClass().add("text-field");
		cPrezzo.getStyleClass().add("text-field");
		eCosto.getStyleClass().add("label-risposte");
		ePrezzoScontato.getStyleClass().add("label-risposte");
		pTotale.getStyleClass().add("button");
		griglia.getStyleClass().add("sfondo");
		
		Scene scena = new Scene(griglia);
		scena.getStylesheets().add("it/edu/iisgubbio/negozi/stileDue.css");
		finestra.setTitle("Panini");
		finestra.setScene(scena);
		finestra.show();
		pTotale.setOnAction( e -> eseguiTotale());
		
		
	}

	private void eseguiTotale() {
		
		double persone, prezzo, costo, sconto;
		
		prezzo = Double.parseDouble(cPrezzo.getText());
		persone = Double.parseDouble(cPersone.getText());
		costo = persone * prezzo;
		eCosto.setText("" + costo);
		if(costo>=100) {
			sconto = costo-((costo/100)*20);
			ePrezzoScontato.setText("" + sconto);
		} else {
			if(costo>=50) {
				sconto = costo-((costo/100)*10);
				ePrezzoScontato.setText("" + sconto);
			} else {
				ePrezzoScontato.setText("" + costo);
			}
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}

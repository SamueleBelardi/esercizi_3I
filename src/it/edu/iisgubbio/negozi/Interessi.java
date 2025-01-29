package it.edu.iisgubbio.negozi;

import it.edu.iisgubbio.conversioni.Temperatura;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Interessi extends Application{
	
	Label eCapitaleIniziale = new Label("capitale iniziale");
	Label eAnni = new Label("anni");
	Label eInteressi = new Label("interessi");
	Label eRisultato = new Label("??");
	TextField cCapitaleIniziale = new TextField();
	TextField cAnni = new TextField();
	TextField cInteressi = new TextField();
	Button pCalcola = new Button("calcola");
	
	public void start(Stage finestra) throws Exception {
		
		GridPane griglia = new GridPane();
		griglia.add(eCapitaleIniziale, 0, 0);
		griglia.add(eAnni, 0, 1);
		griglia.add(eInteressi, 0, 2);
		griglia.add(eRisultato, 1, 3);
		griglia.add(cCapitaleIniziale, 1, 0);
		griglia.add(cAnni, 1, 1);
		griglia.add(cInteressi, 1, 2);
		griglia.add(pCalcola, 0, 3);
		griglia.getStyleClass().add("sfondo");
		eCapitaleIniziale.getStyleClass().add("label");
		eAnni.getStyleClass().add("label");
		eInteressi.getStyleClass().add("label");
		cCapitaleIniziale.getStyleClass().add("text-field");
		cAnni.getStyleClass().add("text-field");
		cInteressi.getStyleClass().add("text-field");
		pCalcola.getStyleClass().add("button");
		eRisultato.setId("risultato");
		
		Scene scena = new Scene(griglia);
		scena.getStylesheets().add("it/edu/iisgubbio/negozi/stileTre.css");
		finestra.setTitle("Interessi");
		finestra.setScene(scena);
		finestra.show();
		pCalcola.setOnAction( e -> eseguiCalcola());
		
		
	}
	private void eseguiCalcola() {
		
		double capitaleIniziale, anni, interessi, risultato;
		
		capitaleIniziale= Double.parseDouble(cCapitaleIniziale.getText());
		anni = Double.parseDouble(cAnni.getText());
		interessi = Double.parseDouble(cInteressi.getText());
		risultato = capitaleIniziale;
		for( int n = 1; n <= anni; n++) {
			risultato = (risultato/100*interessi) + risultato;
			System.out.println(risultato);
		}
		eRisultato.setText("" + risultato);
		 
	
	}
	public static void main(String[] args) {
		launch(args);
	}

}

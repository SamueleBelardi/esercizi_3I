package it.edu.iisgubbio.vettori;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Cerca extends Application {
	
	Label eControllo = new Label("??");
	Label eNumero = new Label("numero");
	TextField cVettore = new TextField();
	TextField cNumeri = new TextField();
	Button pCerca = new Button("cerca");
	
	public void start(Stage finestra) throws Exception {
		
		GridPane griglia = new GridPane();
		griglia.add(cVettore, 0, 0, 3, 1);
		griglia.add(cNumeri, 1, 1);
		griglia.add(eNumero, 0, 1);
		griglia.add(pCerca, 2, 1);
		griglia.add(eControllo, 0, 2, 3, 1);
		cVettore.setPrefWidth(200);
		eControllo.setPrefWidth(200);
		griglia.setId("sfondo");
		
		Scene scene = new Scene(griglia);
		scene.getStylesheets().add("it/edu/iisgubbio/vettori/stile.css");
		scene.getStylesheets().add("it/edu/iisgubbio/vettori/stileCerca.css");
		finestra.setTitle("Griglia");
		finestra.setScene(scene);
		finestra.show();
		pCerca.setOnAction( e -> eseguiCerca());
	}
	
	private void eseguiCerca() {
		
		String testo, parti[];
		int numeri[], contatore = 0, numeroCercato;
		
		numeroCercato = Integer.parseInt(cNumeri.getText());
		testo = cVettore.getText();
		parti = testo.split(" ");
		numeri = new int[parti.length];
		for (int i = 0; i < parti.length; i++) {
			numeri[i] = Integer.parseInt(parti[i]);
			if (numeri[i]==numeroCercato) {
				contatore++;
			}
		}
		if(contatore==0) {
			eControllo.setText(numeroCercato + " non è presente");
			eControllo.setId("testo-sbagliato");
		} else {
			eControllo.setText(numeroCercato + " è presente");
			eControllo.setId("testo-corretto");
		}
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}

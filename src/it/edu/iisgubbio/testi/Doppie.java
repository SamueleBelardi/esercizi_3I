package it.edu.iisgubbio.testi;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Doppie extends Application {
	
	Label eTesto = new Label("testo");
	Label eNumeroDoppie = new Label("n.doppie");
	TextField cTesto = new TextField();
	TextField cNumeroDoppie = new TextField();
	TextField cCancella = new TextField();
	Button pConta = new Button("conta");
	
	public void start(Stage finestra) throws Exception {
		
		GridPane griglia = new GridPane();
		griglia.add(eTesto, 0, 0);
		griglia.add(cTesto, 1, 0);
		griglia.add(pConta, 1, 1);
		griglia.add(eNumeroDoppie, 0, 2);
		griglia.add(cNumeroDoppie, 1, 2);
		griglia.add(cCancella, 1, 3);
		griglia.setId("sfondo");
		
		Scene scene = new Scene(griglia);
		scene.getStylesheets().add("it/edu/iisgubbio/testi/stile.css");
		finestra.setTitle("Griglia");
		finestra.setScene(scene);
		finestra.show();
		pConta.setOnAction( e -> eseguiConta());
	}
	
	private void eseguiConta() {
		
		String parola;
		char car[];
		int contatore = 0;
		
		parola = cTesto.getText();
		car = parola.toCharArray();
		for( int i = 0; i < car.length-1; i++) {
			if(car[i]==car[i+1]) {
				contatore++;
				car[i] = '#';
				car[i+1] = '#';
			}
		}
		cNumeroDoppie.setText(contatore+"");
		String testo = new String(car);
		cCancella.setText(testo);
	}

	public static void main(String[] args) {
		launch(args);
	}
}

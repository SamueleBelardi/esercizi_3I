package it.edu.iisgubbio.testi;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class IP extends Application {

	Label eIndirizzo = new Label("indirizzo");
	TextField cIndirizzo = new TextField();
	TextField cRisultato = new TextField();
	Button pVerifica= new Button("verifica");
	
	public void start(Stage finestra) throws Exception {
		
		GridPane griglia = new GridPane();
		griglia.add(eIndirizzo, 0, 0);
		griglia.add(cIndirizzo, 1, 0);
		griglia.add(pVerifica, 0, 1);
		griglia.add(cRisultato, 1, 1);
		griglia.setId("sfondo");
		
		Scene scene = new Scene(griglia);
		scene.getStylesheets().add("it/edu/iisgubbio/testi/stile.css");
		finestra.setTitle("Griglia");
		finestra.setScene(scene);
		finestra.show();
		pVerifica.setOnAction( e -> eseguiVerifica());
	}

	private void eseguiVerifica() {
		
		String parti[], indirizzo = cIndirizzo.getText();
		parti = indirizzo.split("\\.");
		int iP[] = new int[parti.length];
		
		if(parti.length != 4) {
			cRisultato.setText("non e un indirizzo");
		}
		
		int posizione = 0;
		char controllo[] = indirizzo.toCharArray();
		for(int i = 0; i < controllo.length; i++) {
			if(controllo[i] >= 'A' && controllo[i] <= 'z') {
				cRisultato.setText("non e un indirizzo");
			}
		}
		
		for(int i = 0; i < controllo.length; i++) {
			iP[posizione] = Integer.parseInt(parti[posizione]);
			posizione++;
		}
		
		int numeriCorretti = 0;
		for(int i = 0; i < parti.length; i++) {
			if(iP[i] >= 0 && iP[i] <= 255) {
				numeriCorretti++;
			} else {
				cRisultato.setText("non e un indirizzo");
			}
		}
		
		if(numeriCorretti == 4) {
			cRisultato.setText("e un indirizzo");
		}
	}
	
	public static void main(String[] args) {
		launch(args);
		
	}
}

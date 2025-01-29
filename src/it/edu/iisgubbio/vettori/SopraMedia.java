package it.edu.iisgubbio.vettori;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SopraMedia extends Application {
	
	Label eRisultato = new Label();
	TextField cNumeri = new TextField();
	Button pMedia = new Button("media");
	
	public void start(Stage finestra) throws Exception {

		GridPane griglia = new GridPane();
		griglia.add(cNumeri, 0, 0, 2, 1);
		griglia.add(pMedia, 0, 1 );
		griglia.add(eRisultato, 0, 2);
		griglia.setId("sfondo");

		Scene scene = new Scene(griglia);
		scene.getStylesheets().add("it/edu/iisgubbio/vettori/stile.css");
		finestra.setTitle("Griglia");
		finestra.setScene(scene);
		finestra.show();
		pMedia.setOnAction( e -> eseguiMedia());
	}
	
	int[] testoNumeri (String testo) {
		String parti[];
		int numeri[];
		parti = testo.split(" ");
		numeri = new int[parti.length];
		for (int i = 0; i < parti.length; i++) {
			numeri[i] = Integer.parseInt(parti[i]);
		}
		return numeri;
	}

	private void eseguiMedia() {
		
		String x, risultato = "";
		int numeri[];
		double somma = 0, media;
		
		x = cNumeri.getText();
		numeri = testoNumeri(x);
		for (int i = 0; i < numeri.length; i++) {
			somma+= numeri[i];
		}
		media = somma/numeri.length;
		for (int i = 0; i < numeri.length; i++) {
			if(numeri[i]>media) {
				if (risultato=="") {
					risultato+= "" + numeri[i];
				} else {
					risultato+= ", " + numeri[i];
				}
			}
		}
		eRisultato.setText(risultato+"");	
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

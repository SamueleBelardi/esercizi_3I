package it.edu.iisgubbio.vettori;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ScambioMinMax extends Application {
	
	Label eValore = new Label("valore");
	Label eElenco = new Label("elenco");
	TextField cValore = new TextField("1 3 6 10");
	TextField cElenco = new TextField();
	Button pScambia = new Button("Scambia");
	
	public void start(Stage finestra) throws Exception {
		
		GridPane griglia = new GridPane();
		griglia.add(eValore, 0, 0);
		griglia.add(cValore, 1, 0);
		griglia.add(eElenco, 0, 1);
		griglia.add(cElenco, 1, 1);
		griglia.add(pScambia, 1, 2);
		griglia.setId("sfondo");
		
		Scene scene = new Scene(griglia);
		scene.getStylesheets().add("it/edu/iisgubbio/vettori/stile.css");
		finestra.setTitle("Griglia");
		finestra.setScene(scene);
		finestra.show();
		pScambia.setOnAction( e -> eseguiRicerca());

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

	private void eseguiRicerca() {
		
		String x, risultato = ""; 
		int massimo = 0, minimo = 0, posizioneMassimo = 0, posizioneMinimo = 0, numeri[];

		x = cValore.getText();
		numeri = testoNumeri(x);

		massimo = numeri[0];
		minimo = numeri[0];
		for (int i = 1; i < numeri.length; i++) {
			if(numeri[i]>massimo) {
				massimo = numeri[i];
				posizioneMassimo = i;
			}
			if(numeri[i]<minimo) {
				minimo = numeri[i];
				posizioneMinimo = i;
			}
		}
		numeri[posizioneMassimo] = minimo;
		numeri[posizioneMinimo] = massimo;
		for (int i = 0; i < numeri.length; i++) {
			if(risultato == "") {
				risultato+= " " + numeri[i];
			} else {
				risultato+= "; " + numeri[i];
			}
		}
		cElenco.setText(risultato);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

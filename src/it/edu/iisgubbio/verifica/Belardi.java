package it.edu.iisgubbio.verifica;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Belardi extends Application{

	int numeri[];
	TextField cNumeri = new TextField("1 3 4 6 4 2");
	TextField cPosizione = new TextField();
	Button pScambia = new Button("scambia");
	Button pElimina = new Button("elimina");
	Button pVisualizza = new Button("visualizza");
	Label eScambia = new Label("scambia");
	Label eElimina = new Label("elimina");
	Label eVisualizza = new Label("visualizza");

	public void start(Stage finestra) throws Exception {

		GridPane griglia = new GridPane();
		griglia.add(cNumeri, 0, 0);
		griglia.add(cPosizione, 1, 0);
		griglia.add(eScambia, 0, 1);
		griglia.add(pScambia, 1, 1);
		griglia.add(eElimina, 0, 2);
		griglia.add(pElimina, 1, 2);
		griglia.add(eVisualizza, 0, 3);
		griglia.add(pVisualizza, 1, 3);
		griglia.setId("sfondo");

		Scene scene = new Scene(griglia);
		scene.getStylesheets().add("it/edu/iisgubbio/verifica/BelardiStile.css");
		finestra.setTitle("Griglia");
		finestra.setScene(scene);
		finestra.show();
		pScambia.setOnAction( e -> eseguiScambia());
		pElimina.setOnAction( e -> eseguiElimina());
		pVisualizza.setOnAction( e -> eseguiVisualizza());
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

	private void eseguiVisualizza() {

		String risultato = "";

		for (int i = 0; i < numeri.length; i++) {
			if (numeri[i]!=-1) {
				if(risultato == "") {
					risultato+= " " + numeri[i];
				} else {
					risultato+= ", " + numeri[i];
				}
				
			}	
		}
		eVisualizza.setText(risultato);
	}

	private void eseguiElimina() {

		String x;
		int posizione;

		x = cNumeri.getText();
		numeri = testoNumeri(x);
		posizione = Integer.parseInt(cPosizione.getText());

		for (int i = 0; i < numeri.length; i++) {
			if(posizione == i) {
				numeri[i] = -1;
			}
		}
	}

	private void eseguiScambia() {

		String x; 
		int massimo = 0, minimo = 0, posizioneMassimo = 0, posizioneMinimo = 0;

		x = cNumeri.getText();
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
	}

	public static void main(String[] args) {
		launch(args);
	}
}

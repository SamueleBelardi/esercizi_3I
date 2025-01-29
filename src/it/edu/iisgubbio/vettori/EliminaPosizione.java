package it.edu.iisgubbio.vettori;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class EliminaPosizione extends Application {
	
	Label eElenco = new Label("elenco");
	Label ePosizione = new Label("posizione");
	TextField cElenco = new TextField("1 3 6 10");
	TextField cPosizione = new TextField();
	TextField cElimina = new TextField();
	Button pElimina = new Button("elimina posizione");
	
	public void start(Stage finestra) throws Exception {
		
		GridPane griglia = new GridPane();
		griglia.add(eElenco, 0, 0);
		griglia.add(cElenco, 1, 0);
		griglia.add(ePosizione, 0, 1);
		griglia.add(cPosizione, 1, 1);
		griglia.add(pElimina, 0, 2);
		griglia.add(cElimina, 1, 2);
		griglia.setId("sfondo");
		
		Scene scene = new Scene(griglia);
		scene.getStylesheets().add("it/edu/iisgubbio/vettori/stile.css");
		finestra.setTitle("Griglia");
		finestra.setScene(scene);
		finestra.show();
		pElimina.setOnAction( e -> eseguiElimina());
		
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

	private void eseguiElimina() {
		
		String x, risultato = "";
		int posizione, numeri[];

		x = cElenco.getText();
		numeri = testoNumeri(x);
		posizione = Integer.parseInt(cPosizione.getText());

		for (int i = 0; i < numeri.length; i++) {
			if(posizione == i) {
				numeri[i] = -1;
			}
		}
		for (int i = 0; i < numeri.length; i++) {
			if (numeri[i]!=-1) {
				if(risultato == "") {
					risultato+= " " + numeri[i];
				} else {
					risultato+= ", " + numeri[i];
				}
				
			}	
		}
		cElimina.setText(risultato);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

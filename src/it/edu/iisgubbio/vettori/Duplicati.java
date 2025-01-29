package it.edu.iisgubbio.vettori;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Duplicati extends Application{
	
	Label eDuplicati = new Label("");
	TextField cDuplicati = new TextField();
	Button pTrova = new Button("trova duplicati");
	
	public void start(Stage finestra) throws Exception {
		
		GridPane griglia = new GridPane();
		griglia.add(cDuplicati, 0, 0, 3, 1);
		griglia.add(pTrova, 0, 1, 3, 1);
		griglia.add(eDuplicati, 0, 2, 3, 1);
		cDuplicati.setPrefWidth(200);
		eDuplicati.setPrefWidth(200);
		pTrova.setPrefWidth(200);
		griglia.setId("sfondo");
		
		Scene scene = new Scene(griglia);
		scene.getStylesheets().add("it/edu/iisgubbio/vettori/stile.css");
		finestra.setTitle("Griglia");
		finestra.setScene(scene);
		finestra.show();
		pTrova.setOnAction( e -> eseguiTrova());
	}

	private void eseguiTrova() {
		
		String parti[], testo;
		int numeri[];
		boolean controllo = false;
		
		testo = cDuplicati.getText();
		parti = testo.split(" ");
		numeri = new int[parti.length];
		for (int i = 0; i < parti.length; i++) {
			numeri[i] = Integer.parseInt(parti[i]);
		}
		for (int i = 0; i < parti.length-1; i++) {
			if(numeri[i]==numeri[i+1]) {
				controllo = true;
			}
		}
		if(controllo == true) {
			eDuplicati.setText("Ci sono dei duplicati");
		} else {
			eDuplicati.setText("Non ci sono dei duplicati");
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

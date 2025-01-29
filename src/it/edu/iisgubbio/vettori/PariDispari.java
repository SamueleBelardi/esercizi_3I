package it.edu.iisgubbio.vettori;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PariDispari extends Application {

	Label eNumeroPari = new Label("pari:");
	Label eNumeroDispari = new Label("dispari:");
	Button pTrova = new Button("trova");
	TextField cNumeri = new TextField();

	public void start(Stage finestra) throws Exception {

		GridPane griglia = new GridPane();
		griglia.add(cNumeri, 0, 0, 2, 1);
		griglia.add(pTrova, 0, 1, 2, 1 );
		griglia.add(eNumeroPari, 0, 2);
		griglia.add(eNumeroDispari, 1, 2);
		cNumeri.setPrefWidth(200);
		pTrova.setPrefWidth(200);
		eNumeroDispari.setPrefWidth(100);
		eNumeroPari.setPrefWidth(100);
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
		int numeri[], pari = 0, dispari = 0;
	
		
		testo = cNumeri.getText();
		parti = testo.split(" ");
		numeri = new int[parti.length];
		for (int i = 0; i < parti.length; i++) {
			numeri[i] = Integer.parseInt(parti[i]);
		}
		for (int i = 0; i < parti.length; i++) {
			if(numeri[i]%2==0) {
				pari++;
			} else {
				dispari++;
			}
		}
		eNumeroPari.setText(pari + "");
		eNumeroDispari.setText(dispari + "");
	}

	public static void main(String[] args) {
		launch(args);
	}
}

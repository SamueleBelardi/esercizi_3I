package it.edu.iisgubbio.vettori;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TrovaPosizioneTutti extends Application {
	
	Label eNumero = new Label("numero");
	Label eCerca = new Label("??");
	TextField cNumero = new TextField();
	TextField cNumeri = new TextField();
	Button pCerca = new Button("cerca");
	
	public void start(Stage finestra) throws Exception {
		
		GridPane griglia = new GridPane();
		griglia.add(cNumeri, 0, 0, 3, 1);
		griglia.add(eNumero, 0, 1 );
		griglia.add(cNumero, 1, 1);
		griglia.add(pCerca, 2, 1);
		griglia.add(eCerca, 0, 2, 3, 1);
		cNumeri.setPrefWidth(200);
		eCerca.setPrefWidth(200);
		griglia.setId("sfondo");

		Scene scene = new Scene(griglia);
		scene.getStylesheets().add("it/edu/iisgubbio/vettori/stile.css");
		finestra.setTitle("Griglia");
		finestra.setScene(scene);
		finestra.show();
		pCerca.setOnAction( e -> eseguiCerca());
		
	}
	
	private void eseguiCerca() {
		
		String parti[], testo, posizione = "";
		int numeri[], numero;
		
		numero = Integer.parseInt(cNumero.getText());
		testo = cNumeri.getText();
		parti = testo.split(" ");
		numeri = new int[parti.length];
		for (int i = 0; i < parti.length; i++) {
			numeri[i] = Integer.parseInt(parti[i]);
		}
		for (int i = 0; i < parti.length; i++) {
			if(numero==numeri[i]) {
				if (i==0) {
					posizione+= " " + i;
				} else {
					posizione+= ", " + i;
				}
			}
		}
		eCerca.setText("trovato " + numero + " alla pos " + posizione);
	}

	public static void main(String[] args) {
		launch(args);
	}
}

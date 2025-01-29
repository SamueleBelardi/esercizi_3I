package it.edu.iisgubbio.vettori;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MinimoMassimo extends Application {

	Label eMinimo = new Label();
	Label eMassimo = new Label();
	TextField cNumeri = new TextField();
	Button pMinimo = new Button("minimo");
	Button pMassimo = new Button("massimo");
	
	public void start(Stage finestra) throws Exception {
		
		GridPane griglia = new GridPane();
		griglia.add(cNumeri, 0, 0, 2, 1);
		griglia.add(pMinimo, 0, 1 );
		griglia.add(pMassimo, 1, 1);
		griglia.add(eMinimo, 0, 2);
		griglia.add(eMassimo, 1, 2);
		griglia.setId("sfondo");

		Scene scene = new Scene(griglia);
		scene.getStylesheets().add("it/edu/iisgubbio/vettori/stile.css");
		finestra.setTitle("Griglia");
		finestra.setScene(scene);
		finestra.show();
		pMinimo.setOnAction( e -> eseguiMinimo());
		pMassimo.setOnAction( e-> eseguiMassimi());
		
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
	private void eseguiMassimi() {
		
		String x;
		int numeri[], massimo;
		
		x = cNumeri.getText();
		numeri = testoNumeri(x);
		
		massimo = numeri[0];
		for (int i = 1; i < numeri.length; i++) {
			if(numeri[i]>massimo) {
				massimo = numeri[i];
			}
		}
		eMassimo.setText("" + massimo);
	}

	private void eseguiMinimo() {
		int numeri[], minimo;
		numeri = testoNumeri(cNumeri.getText());
		
		minimo = numeri[0];
		for (int i = 1; i < numeri.length; i++) {
			if(numeri[i]<minimo) {
				minimo = numeri[i];
			}
		}
		eMinimo.setText("" + minimo);
	}

	public static void main(String[] args) {
		launch(args);
	}
}

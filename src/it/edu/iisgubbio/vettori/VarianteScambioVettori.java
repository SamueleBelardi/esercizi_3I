package it.edu.iisgubbio.vettori;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class VarianteScambioVettori extends Application{

	
	Label eNumeri = new Label("numeri");
	Label eRisultato = new Label("risultato");
	TextField cNumeri = new TextField("1 3 6 10");
	TextField cRisultato = new TextField();
	Button pScambia = new Button("scambia");
	
	public void start(Stage finestra) throws Exception {
		
		GridPane griglia = new GridPane();
		griglia.add(eNumeri, 0, 0);
		griglia.add(cNumeri, 1, 0);
		griglia.add(pScambia, 1, 1);
		griglia.add(eRisultato, 0, 2);
		griglia.add(cRisultato, 1, 2);
		griglia.setId("sfondo");

		Scene scene = new Scene(griglia);
		scene.getStylesheets().add("it/edu/iisgubbio/verifica/BelardiStile.css");
		finestra.setTitle("Griglia");
		finestra.setScene(scene);
		finestra.show();
		pScambia.setOnAction( e -> eseguiScambia());
		
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

	private void eseguiScambia() {
		
		String x, risultato = "";
		int numeriUno[], numeriDue[], contatore = 0;
		
		x = cNumeri.getText();
		numeriUno = testoNumeri(x);
		contatore = numeriUno.length-1;
		numeriDue = new int[numeriUno.length];
		
		for (int i = 0; i < numeriUno.length; i++) {
			for (int z = 0; z < numeriUno.length; z++) {
				
			}

		}
	}
	}
	
	
		

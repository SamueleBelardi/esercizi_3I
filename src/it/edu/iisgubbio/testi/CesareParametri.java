package it.edu.iisgubbio.testi;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CesareParametri extends Application{
	
	Label eParametro = new Label("parametro");
	TextField cParola = new TextField();
	TextField cParolaCifrata = new TextField();
	TextField cParametro = new TextField();
	Button pCifra = new Button("cifra");
	Button pDecifra = new Button("decifra");
	char frase[];
	
	public void start(Stage finestra) throws Exception {
		
		GridPane griglia = new GridPane();
		griglia.add(cParola, 0, 0, 2, 1);
		griglia.add(pCifra, 0, 1);
		griglia.add(pDecifra, 1, 1);
		griglia.add(cParolaCifrata, 0, 2, 2, 1);
		griglia.add(eParametro, 0, 3);
		griglia.add(cParametro, 1, 3);
		griglia.setId("sfondo");
		
		Scene scene = new Scene(griglia);
		scene.getStylesheets().add("it/edu/iisgubbio/testi/stile.css");
		finestra.setTitle("Griglia");
		finestra.setScene(scene);
		finestra.show();
		pCifra.setOnAction( e -> eseguiCifra());
		pDecifra.setOnAction( e -> eseguiDecifra());
		
	}

	private void eseguiCifra() {
		
		String parola = cParola.getText();
		frase = new char[parola.length()];
		frase = cParola.getText().toCharArray();
		int parametro = Integer.parseInt(cParametro.getText());
		
		int limite = (char) (122-parametro);
		
		for(int i = 0; i < frase.length; i++) {
			if(frase[i] >= limite) {
				frase[i] = ((char) (frase[i]-26)); 
			}
			frase[i] = ((char) (frase[i]+parametro)); 
		}
		
		String testo = new String(frase);
		cParolaCifrata.setText(testo);
	}

	private void eseguiDecifra() {
		
		int parametro = Integer.parseInt(cParametro.getText());
		int limite = (char) (97+parametro);
		
		for(int i = 0; i < frase.length; i++) {
			if(frase[i] <= limite) {
				frase[i] = ((char) (frase[i]+26)); 
			}
			frase[i] = ((char) (frase[i]-parametro)); 
		}
			
		String testo = new String(frase);
		cParola.setText(testo);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
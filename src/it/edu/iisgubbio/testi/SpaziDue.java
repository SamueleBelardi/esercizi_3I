package it.edu.iisgubbio.testi;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SpaziDue extends Application{
	
	Label eFrase = new Label("frase");
	TextField cFrase = new TextField();
	TextField cCompatta = new TextField();
	TextField cLunghzza = new TextField();
	TextField cEspandi = new TextField();
	Button pCompatta = new Button("controlla");
	Button pEspandi = new Button("espandi");
	
	public void start(Stage finestra) throws Exception {
		
		GridPane griglia= new GridPane();
		griglia.add(eFrase, 0, 0, 2, 1);
		griglia.add(cFrase, 2, 0, 2, 1);
		griglia.add(pCompatta,0, 1, 2, 1);
		griglia.add(cCompatta,2, 1, 2, 1);
		griglia.add(cLunghzza, 0, 2);
		griglia.add(pEspandi, 1, 2);
		griglia.add(cEspandi, 2, 2, 2, 1);
		eFrase.setMaxWidth(Integer.MAX_VALUE);
		pCompatta.setMaxWidth(Integer.MAX_VALUE);
		griglia.setId("sfondo");
		cFrase.getStyleClass().add("grande");
		cCompatta.getStyleClass().add("grande");
		cEspandi.getStyleClass().add("grande");
		cLunghzza.setId("lunghezza");
	
		Scene scene = new Scene(griglia);
		scene.getStylesheets().add("it/edu/iisgubbio/testi/stile.css");
		scene.getStylesheets().add("it/edu/iisgubbio/testi/stileSpazi.css");
		finestra.setTitle("Griglia");
		finestra.setScene(scene);
		finestra.show();
		pCompatta.setOnAction( e -> eseguiCompatta());
		pEspandi.setOnAction( e -> eseguiEspandi());
	}

	private void eseguiEspandi() {
		
		String frase;
		char car[], carEspanso[];
		int lunghezza, spaziAggiunti = 0;
		
		car = cFrase.getText().toCharArray();
		lunghezza = Integer.parseInt(cLunghzza.getText());
		carEspanso = new char[lunghezza];
		
		int spaziCar = 0;
		for(int i = 0; i < car.length; i++) {
			if(car[i]==' ') {
				spaziCar++;
			}
		}
		
		int spaziDaAggiungere = (carEspanso.length-car.length) / spaziCar;
		for(int i = 0; i < car.length; i++) {
			if(car[i]!=' ') {
				carEspanso[i+spaziAggiunti] = car[i];
			} else {
				for(int z = 1; z > spaziDaAggiungere; z++) {
					carEspanso[i+z+spaziDaAggiungere] = ' ';
				}
				spaziAggiunti+= spaziDaAggiungere;
			}
		}
		
		String espanso = new String(carEspanso);
		cEspandi.setText(espanso);
	}

	private void eseguiCompatta() {
		
		String frase;
		char car[], carCompattato[];
 
		frase = cFrase.getText();
		car = frase.toCharArray();
		
		int spazi = 0;
		for(int i = 0; i < car.length; i++) {
			if(car[i]==' ') {
				spazi++;
			}
		}
		int contatoreSpazi = 0;
		carCompattato = new char[car.length-spazi];
		for(int i = 0; i < car.length; i++) {
			if(car[i]!=' ') {
				carCompattato[i-contatoreSpazi] = car[i];
			} else {
				contatoreSpazi++;
			}
		}
		String f = new String(carCompattato);
		cCompatta.setText(f);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
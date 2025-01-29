package it.edu.iisgubbio.testi;



import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Palindromo extends Application {
	
	Label eTesto = new Label("testo");
	TextField cTesto = new TextField();
	TextField cControlla = new TextField();
	Button pControlla = new Button("controlla");
	
	public void start(Stage finestra) throws Exception {
		
		GridPane griglia= new GridPane();
		griglia.add(eTesto, 0, 0);
		griglia.add(cTesto, 1, 0);
		griglia.add(pControlla,0, 1, 2, 1);
		griglia.add(cControlla,0, 2, 2, 1);
		griglia.setId("sfondo");
	
		Scene scene = new Scene(griglia);
		scene.getStylesheets().add("it/edu/iisgubbio/testi/stile.css");
		finestra.setTitle("Griglia");
		finestra.setScene(scene);
		finestra.show();
		pControlla.setOnAction( e -> eseguiControlla());
	}

	private void eseguiControlla() {
		
		String parola;
		char car[], carInvertita[];
 
		parola = cTesto.getText();
		car = parola.toCharArray();
		carInvertita = new char[car.length];
		int contatore = car.length-1;
		
		for( int i = 0; i < car.length; i++) {
			carInvertita[contatore] = car[i];
			contatore--;
		}
		
		int controllo = 0;
		for( int i = 0; i < car.length; i++) {
			if(carInvertita[i] == car[i]) {
				controllo++;
			}
		}
		if(controllo == car.length) {
			cControlla.setText("si");
		} else {
			cControlla.setText("no");
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}

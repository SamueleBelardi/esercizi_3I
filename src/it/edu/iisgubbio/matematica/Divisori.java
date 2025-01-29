package it.edu.iisgubbio.matematica;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Divisori extends Application {
	
	Label eNumero = new Label("numero");
	Label eRisultato = new Label("??");
	TextField cNumero = new TextField();
	Button pDivisori = new Button("divisori");

	public void start(Stage finestra) throws Exception {
		
		GridPane griglia = new GridPane();
		griglia.add(eNumero, 0, 0);
		griglia.add(cNumero, 1, 0);
		griglia.add(pDivisori, 2, 0);
		griglia.add(eRisultato, 0, 1, 3, 1);
		eRisultato.setMaxWidth(Integer.MAX_VALUE);
		griglia.setId("sfondo");
		eRisultato.setId("risultato");
		eNumero.setId("numero");
		cNumero.setId("text-field");
		pDivisori.setId("button");
		
		
		Scene scena = new Scene(griglia);
		scena.getStylesheets().add("it/edu/iisgubbio/matematica/stileDue.css");
		finestra.setTitle("Divisori");
		finestra.setScene(scena);
		finestra.show();
		pDivisori.setOnAction( e -> eseguiDivisori());
		
	}
	
	private void eseguiDivisori() {
		
		int numero; boolean primoNumero;
		String divisori;
		
		primoNumero = true;
		divisori = ("divisori : ");
		numero = Integer.parseInt(cNumero.getText());
		for( int n = 2; numero-1 >= n; n++) {
			if(numero%n==0) {
				if(primoNumero) {
					divisori = (divisori + n);
					primoNumero = false;
				} else {
					divisori = (divisori + ", " +n);
				}
			} 	
		}
		
		eRisultato.setText(divisori);
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}

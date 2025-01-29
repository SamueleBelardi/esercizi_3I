package it.edu.iisgubbio.giochi;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class IndovinaNumero extends Application {
	
	Label eAiuto = new Label("??");
	TextField cNumero = new TextField();
	Button pProva = new Button("prova");
	int numeroCasuale = (int)(Math.random()*100)+1;
	
	public void start(Stage finestra) throws Exception {
		
		GridPane principale = new GridPane();
		principale.add(cNumero, 0, 0);
		principale.add(pProva, 0, 1);
		principale.add(eAiuto, 0, 2);
		eAiuto.getStyleClass().add("label");
		cNumero.getStyleClass().add("textfield");
		pProva.getStyleClass().add("button");
		principale.getStyleClass().add("spaziature");
		principale.getStyleClass().add("sfondo");

		Scene scena = new Scene(principale);
		scena.getStylesheets().add("it/edu/iisgubbio/giochi/stile.css");
		finestra.setTitle("IndovinaNumero");
		finestra.setScene(scena);
		finestra.show();
		
		pProva.setOnAction( e -> eseguiProva());
	}

	private void eseguiProva() {
		
		int nInserito, numero;
		
		numero = numeroCasuale;
		nInserito = Integer.parseInt(cNumero.getText());
		System.out.println(numero);
		if(nInserito==numero) {
			eAiuto.setText("indovinato");
		} else {
			if(nInserito>numero) {
				eAiuto.setText("più piccolo");
			} else {
				eAiuto.setText("più grande");
			}
		}
		
	}
	
	public static void main(String[] args) {
	    launch(args);

}

}

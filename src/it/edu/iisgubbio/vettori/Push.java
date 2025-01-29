package it.edu.iisgubbio.vettori;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Push extends Application {
	
	int numeroCaselle = 16;
	Button pPush = new Button("push");
	TextField caselle[] = new TextField[numeroCaselle];
	
	public void start(Stage finestra) throws Exception {
		
		GridPane griglia = new GridPane();
		for (int i = 0; i < caselle.length; i++) {
			caselle[i] = new TextField("");
			griglia.add(caselle[i], 0, i);
		}
		griglia.add(pPush, 1, numeroCaselle-1);
		griglia.setId("sfondo");

		Scene scene = new Scene(griglia);
		scene.getStylesheets().add("it/edu/iisgubbio/vettori/stile.css");
		finestra.setTitle("Griglia");
		finestra.setScene(scene);
		finestra.show();
		pPush.setOnAction( e -> eseguiPush());
	}
	
	private void eseguiPush() {
		
		String spostamento = "";
		int contatore = numeroCaselle-2;
		
		for (int i = numeroCaselle-1; i > 0; i--) {
			  	spostamento = caselle[i].getText();
			   	caselle[contatore].setText(spostamento);
			   	contatore--;
			   	if(caselle[contatore].getText()=="") {
			   		i = -1;
			   	}
			   	}
			}
	
	public static void main(String[] args) {
		launch(args);
	}

}

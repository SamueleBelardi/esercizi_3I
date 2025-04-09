package it.edu.iisgubbio.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Pizzeria extends Application {

	Label eNome = new Label("nome");
	TextField cPizza = new TextField();
	TextField cPrezzo = new TextField();
	Button pPrezzo = new Button("prezzo");
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		GridPane g = new GridPane();
		g.add(eNome, 0, 0);
		g.add(cPizza, 1, 0);
		g.add(pPrezzo, 0, 1);
		g.add(cPrezzo, 1, 1);
		g.setId("sfondo");
		
		Scene scena = new Scene(g);
		primaryStage.setTitle("pizzeria");
		scena.getStylesheets().add("it/edu/iisgubbio/vettori/stile.css");
		primaryStage.setScene(scena);
		primaryStage.show();
		pPrezzo.setOnAction( e -> eseguiPrezzo());
	}

	private void eseguiPrezzo() {
		String nomePizza = cPizza.getText();
		
		try (
			FileReader flussoCaratteri = new FileReader("c:\\Users\\samuelebelardi\\Desktop\\pizze.txt");
			BufferedReader lettoreDiRighe = new BufferedReader(flussoCaratteri);
		){
			boolean trovato = false;
			String rigaLetta = null, prezzo = null, nome = null;
			while( (rigaLetta = lettoreDiRighe.readLine())!=null ) {
				nome = rigaLetta.substring(2).trim();
				if(nomePizza.equals(nome)) {
					prezzo = rigaLetta.substring(0,2);
					trovato = true;
				}
		    }
			if(trovato) {
				cPrezzo.setText("la pizza costa " + prezzo + "€"); 
			} else {
				cPrezzo.setText("la pizza non è presente nel menu");
			}
		} catch (IOException e) {
			cPrezzo.setText(e.getLocalizedMessage());
		}
		
	}

	public static void main(String[] args) {
		launch(args);
	}

}

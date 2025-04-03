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

public class AnimaliRari extends Application {

	Label eNome = new Label("nome");
	TextField cAnimale = new TextField();
	TextField cLettura = new TextField();
	Button pCerca = new Button("leggi");
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		GridPane g = new GridPane();
		g.add(eNome, 0, 0);
		g.add(cAnimale, 1, 0);
		g.add(pCerca, 0, 1, 2, 1);
		g.add(cLettura, 0, 2, 2, 1);
		pCerca.setPrefWidth(500);
		g.setId("sfondo");
		
		Scene scena = new Scene(g);
		primaryStage.setTitle("Demo");
		scena.getStylesheets().add("it/edu/iisgubbio/vettori/stile.css");
		primaryStage.setScene(scena);
		primaryStage.show();
		pCerca.setOnAction( e -> eseguiCerca());
	}

	private void eseguiCerca() {
		String animale = cAnimale.getText();
		
		try (
			FileReader flussoCaratteri = new FileReader("c:\\Users\\samuelebelardi\\Desktop\\animaliRari.txt");
			BufferedReader lettoreDiRighe = new BufferedReader(flussoCaratteri);
		){
			boolean trovato = false;
			String rigaLetta = "";
			while( (rigaLetta = lettoreDiRighe.readLine())!=null ) {
				if(rigaLetta.equals(animale) && trovato == false) {
					trovato = true;
				}
		    }
			if(trovato) {
				cLettura.setText(animale + " è in lista"); 
			} else {
				cLettura.setText(animale + " NON è in lista");
			}
		} catch (IOException e) {
			cLettura.setText(e.getLocalizedMessage());
		}
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}

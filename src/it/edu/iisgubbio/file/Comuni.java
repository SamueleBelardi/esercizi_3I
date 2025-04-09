package it.edu.iisgubbio.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Comuni extends Application {

	Label eNomeComune = new Label("nome comune");
	Label eNomeProvincia = new Label("nome provincia");
	TextField cNomeComune = new TextField();
	TextField cNomeProvincia = new TextField();
	Label eCodice = new Label();
	Button pCodice = new Button("Cerca codice");
	Button pProvincia = new Button("Cerca provincia");
	ListView<String> lComuni = new ListView<String>();
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		GridPane g = new GridPane();
		g.add(eNomeComune, 0, 0);
		g.add(cNomeComune, 1, 0);
		g.add(eNomeProvincia, 0, 1);
		g.add(cNomeProvincia, 1, 1);
		g.add(pCodice, 0, 2);
		g.add(eCodice, 1, 2);
		g.add(pProvincia, 0, 3);
		g.add(lComuni, 2, 0, 2, 5);
		g.setId("sfondo");
		
		Scene scena = new Scene(g);
		primaryStage.setTitle("comuni");
		scena.getStylesheets().add("it/edu/iisgubbio/vettori/stile.css");
		primaryStage.setScene(scena);
		primaryStage.show();
		pCodice.setOnAction( e -> eseguiCodice());
		pProvincia.setOnAction( e -> eseguiProvincia());
	}

	private void eseguiProvincia() {
		String nomeProvincia = cNomeProvincia.getText();

		try (
			FileReader flussoCaratteri = new FileReader("c:\\Users\\samuelebelardi\\Desktop\\comuni.txt");
			BufferedReader lettoreDiRighe = new BufferedReader(flussoCaratteri);
		){
			String rigaLetta = null, comune = null, provincia = null;
			while( (rigaLetta = lettoreDiRighe.readLine())!=null ) {
				provincia = rigaLetta.substring(54,56).trim();
				if(nomeProvincia.equals(provincia) || 
						nomeProvincia.toLowerCase().equals(provincia.toLowerCase())) {
					comune = rigaLetta.substring(4,54).trim();
					lComuni.getItems().add(comune);
				} 
			}
		} catch (IOException e) {
			eCodice.setText(e.getLocalizedMessage());
		}
	}

	private void eseguiCodice() {
		String nomeComune = cNomeComune.getText();
		
		try (
			FileReader flussoCaratteri = new FileReader("c:\\Users\\samuelebelardi\\Desktop\\comuni.txt");
			BufferedReader lettoreDiRighe = new BufferedReader(flussoCaratteri);
		){
			boolean trovato = false;
			String rigaLetta = null, codiceCatastale = null, comune = null;
			while( (rigaLetta = lettoreDiRighe.readLine())!=null ) {
				comune = rigaLetta.substring(4,54).trim();
				if(nomeComune.equals(comune) || 
						nomeComune.toLowerCase().equals(comune.toLowerCase()) ||
						nomeComune.replace(" ", "").equals(comune.replace(" ", ""))) {					
					codiceCatastale = rigaLetta.substring(0,4);
					trovato = true;
				}
			}
			if(trovato) {
				eCodice.setText(codiceCatastale); 
			} else {
				eCodice.setText("Il comune non esiste");
			}
		} catch (IOException e) {
			eCodice.setText(e.getLocalizedMessage());
		}
		
	}

	public static void main(String[] args) {
		launch(args);
	}

}

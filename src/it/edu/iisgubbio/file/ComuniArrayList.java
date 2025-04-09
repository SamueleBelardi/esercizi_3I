package it.edu.iisgubbio.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ComuniArrayList extends Application {
	Label eNomeComune = new Label("nome comune");
	Label eNomeProvincia = new Label("nome provincia");
	TextField cNomeComune = new TextField();
	TextField cNomeProvincia = new TextField();
	Label eCodice = new Label();
	Button pCodice = new Button("Cerca codice");
	Button pProvincia = new Button("Cerca provincia");
	ListView<String> lComuni = new ListView<String>();
	ArrayList<Comune> aComuni;
	
	@Override
	public void start(Stage primaryStage) {
		
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
		
		// lettura del file
		aComuni = lettoreFile("comuni");
		Scene scena = new Scene(g);
		primaryStage.setTitle("comuni");
		scena.getStylesheets().add("it/edu/iisgubbio/vettori/stile.css");
		primaryStage.setScene(scena);
		primaryStage.show();
		pCodice.setOnAction( e -> eseguiCodice());
		pProvincia.setOnAction( e -> eseguiProvincia());
	}
	
	// metodo che legge le righe di un file
	ArrayList<Comune> lettoreFile(String nomeFile) {
		ArrayList<Comune> arrayList = new ArrayList<Comune>();
		try (
			FileReader flussoCaratteri = new FileReader("c:\\Users\\samuelebelardi\\Desktop\\" + nomeFile + ".txt");
			BufferedReader lettoreDiRighe = new BufferedReader(flussoCaratteri);
		){ 
			String rigaLetta;
			while( (rigaLetta = lettoreDiRighe.readLine())!=null ) {
				arrayList.add(new Comune(rigaLetta));
			}
		} catch (IOException e) {
			eCodice.setText(e.getLocalizedMessage());
		}
		return arrayList;
	}
	
	private void eseguiProvincia() {
		String nomeProvincia = cNomeProvincia.getText();
		
		String comune;
		String provincia;
		for(int i = 0; i < aComuni.size(); i++) {
			provincia = aComuni.get(i).provincia;
			if(nomeProvincia.equals(provincia)) {
				comune = aComuni.get(i).nome;
				lComuni.getItems().add(comune);
			}
		}
	}

	private void eseguiCodice() {
		
		String nomeComune = cNomeComune.getText(), comune, codiceCatastale = null ;
		
		for(int i = 0; i < aComuni.size(); i++) {
			comune = aComuni.get(i).nome;
			if(nomeComune.equals(comune)) {
				codiceCatastale = aComuni.get(i).codice;
			}
		}
		
		if(codiceCatastale!=null) {
			eCodice.setText(codiceCatastale);
		} else {
			eCodice.setText("il comune NON esiste");
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}

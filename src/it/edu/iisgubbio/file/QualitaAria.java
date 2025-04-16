package it.edu.iisgubbio.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class QualitaAria extends Application{
	
	Label eNomeComune = new Label("nome comune");
	Label eCerca = new Label();
	Label ePiuPulito = new Label();
	TextField cNomeComune = new TextField();
	Button pCerca = new Button("cerca");
	Button pPiuPulito = new Button("piu pulito");
	ArrayList <String> lista = new ArrayList<String>();

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		GridPane g = new GridPane();
		g.add(eNomeComune, 0, 0);
		g.add(cNomeComune, 1, 0);
		g.add(pCerca, 0, 1);
		g.add(eCerca, 1, 1);
		g.add(pPiuPulito, 0, 2);
		g.add(ePiuPulito, 1, 2);
		g.setId("sfondo");
		
		lista = lettoreFile("qualitaDellAria");
		Scene scena = new Scene(g);
		primaryStage.setTitle("QualitaAria");
		scena.getStylesheets().add("it/edu/iisgubbio/vettori/stile.css");
		primaryStage.setScene(scena);
		primaryStage.show();
		pCerca.setOnAction( e -> eseguiCerca());
		pPiuPulito.setOnAction( e -> eseguiPiuPulito());
		
	}
	
	ArrayList<String> lettoreFile(String nomeFile) {
		ArrayList<String> arrayList = new ArrayList<String>();
		try (
			FileReader flussoCaratteri = new FileReader("c:\\Users\\samuelebelardi\\Desktop\\" + nomeFile + ".csv");
			BufferedReader lettoreDiRighe = new BufferedReader(flussoCaratteri);
		){ 
			String rigaLetta;
			while( (rigaLetta = lettoreDiRighe.readLine())!=null ) {
				arrayList.add(rigaLetta);
			}
		} catch (IOException e) {
			eCerca.setText(e.getLocalizedMessage());
		}
		return arrayList;
	}
		
	// numero di giorni concentrazione media
	private void eseguiCerca() {
		String numeroGiorni = null;
		String comune = cNomeComune.getText();
		
		for(int i = 1; i < lista.size(); i++) {
			String [] rigaDivisa = lista.get(i).split(",");
			if(comune.equals(rigaDivisa[0] )) {
				if(rigaDivisa[2] != "-") {
					numeroGiorni = rigaDivisa[2];
				}
			}
		}
		
		if(numeroGiorni!=null) {
			eCerca.setText(numeroGiorni);
		} 
	}

	// comune con valore medio anno piu basso
	private void eseguiPiuPulito() {
		int valoreMedio = 400;
		String comuneMediaMinore = "";
		
		for(int i = 1; i < lista.size(); i++) {
			String [] rigaDivisa = lista.get(i).split(",");
			if(!rigaDivisa[3].equals("-")) {
				if(valoreMedio > Integer.parseInt(rigaDivisa[3])) {
						valoreMedio = Integer.parseInt(rigaDivisa[3]);
						comuneMediaMinore = rigaDivisa[0];
			    }
			}
		}
		
		ePiuPulito.setText(comuneMediaMinore + " con " + valoreMedio);
	
	}

	public static void main(String[] args) {
		launch(args);
	}
}

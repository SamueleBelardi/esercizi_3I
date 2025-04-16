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

public class Abbigliamento extends Application {
	
	Button pControllo = new Button("controlla");
	ListView <String> lista = new ListView<String>();
	ArrayList <String> lettoreFile = new ArrayList<String>();

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		GridPane g = new GridPane();
		g.add(pControllo, 0, 0);
		pControllo.setMaxWidth(Integer.MAX_VALUE);
		g.add(lista, 0, 1);
		g.setId("sfondo");
		
		lettoreFile = lettoreFile("abbigliamento");
		Scene scena = new Scene(g);
		primaryStage.setTitle("QualitaAria");
		scena.getStylesheets().add("it/edu/iisgubbio/vettori/stile.css");
		primaryStage.setScene(scena);
		primaryStage.show();
		pControllo.setOnAction( e -> eseguiControllo());
		
		
	}
	
	ArrayList<String> lettoreFile(String nomeFile) {
		ArrayList<String> arrayList = new ArrayList<String>();
		try (
			FileReader flussoCaratteri = new FileReader("c:\\Users\\samuelebelardi\\Desktop\\" + nomeFile + ".csv");
			BufferedReader lettoreDiRighe = new BufferedReader(flussoCaratteri);
		){ 
			String rigaLetta;
			lettoreDiRighe.readLine();
			while( (rigaLetta = lettoreDiRighe.readLine())!=null ) {
				arrayList.add(rigaLetta);
			}
		} catch (IOException e) {
			System.out.println(e.getLocalizedMessage());
		}
		return arrayList;
	}
	
	private void eseguiControllo() {
		
		for(int i = 0; i < lettoreFile.size(); i++) {
			int riga = i+1;
			String errore = "";
			String [] rigaDivisa = lettoreFile.get(i).split(",");
			
			if(rigaDivisa[0].length()!=5) {
				errore = "codice, ";
			}
			if(rigaDivisa.length > 50) {
				errore += "descrizione, ";
			}
			if(!(rigaDivisa[2].equals("S") ||
					rigaDivisa[2].equals("M") ||
					rigaDivisa[2].equals("L"))) {	
				errore += "taglia, ";
			}
			if(!(rigaDivisa[3].equals("bianco") ||
					rigaDivisa[3].equals("nero") ||
					rigaDivisa[3].equals("blu") ||
					rigaDivisa[3].equals("rosso") ||
					rigaDivisa[3].equals("giallo") ||
					rigaDivisa[3].equals("marrone") ||
					rigaDivisa[3].equals("viola") ||
					rigaDivisa[3].equals("fucsia") )) {
				errore += "colore, ";
			}
			if(Double.parseDouble(rigaDivisa[4]) > 200) {
				errore += "prezzo, "; 
			}
			if(!errore.equals("")) {
				lista.getItems().add("riga " + riga + " sbagliato " + errore);
			} else {
				lista.getItems().add("riga " + riga + " giusto");
			}
		}
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}

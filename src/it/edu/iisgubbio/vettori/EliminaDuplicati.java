package it.edu.iisgubbio.vettori;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class EliminaDuplicati extends Application {
	
	Label eNumeri = new Label("numeri");
	Label eRisposta = new Label("risposta");
	Label eRisultato = new Label("");
	TextField cNumeri = new TextField("1 7 3 4 4 7 2");
	Button pEliminaDuplicati = new Button("elimina duplucati");
	Button pContaDuplicati = new Button("conta duplicati");
	
	public void start(Stage finestra) throws Exception {
		
		GridPane griglia = new GridPane();
		griglia.add(eNumeri, 0, 0);
		griglia.add(cNumeri, 1, 0);
		griglia.add(pEliminaDuplicati, 1, 1);
		griglia.add(pContaDuplicati, 1, 2);
		griglia.add(eRisposta, 0, 3);
		griglia.add(eRisultato, 1, 3);
		griglia.setId("sfondo");

		Scene scene = new Scene(griglia);
		scene.getStylesheets().add("it/edu/iisgubbio/vettori/stile.css");
		finestra.setTitle("Griglia");
		finestra.setScene(scene);
		finestra.show();
		pEliminaDuplicati.setOnAction( e -> eseguiEliminaDuplicati());
		pContaDuplicati.setOnAction( e-> eseguiContaDuplicati());
	}

	int[] testoNumeri (String testo) {
		String parti[];
		int numeri[];
		parti = testo.split(" ");
		numeri = new int[parti.length];
		for (int i = 0; i < parti.length; i++) {
			numeri[i] = Integer.parseInt(parti[i]);
		}
		return numeri;
		
	}
	private void eseguiEliminaDuplicati() {
		
		String x, risultato = "";
		int numeri[], numeriSenzaDuplicati[], numeriGiusto[], puntoInserimento= 0;
		boolean presente;

		x = cNumeri.getText();
		numeri = testoNumeri(x);
		numeriSenzaDuplicati = new int[numeri.length];
		for (int i = 0; i < numeri.length; i++) {
			presente = false;
			for(int z = i+1; z < numeri.length; z++) {
				if(numeri[i]==numeri[z]) {
					presente = true;
				}
			}
			if(presente == false){
				numeriSenzaDuplicati[puntoInserimento] = numeri[i];
				puntoInserimento++;
			}
		}
		numeriGiusto = new int [puntoInserimento];
		for (int i = 0; i < puntoInserimento; i++) {
			numeriGiusto[i] = numeriSenzaDuplicati[i];
		}
		for (int i = 0; i < puntoInserimento; i++) {
			if(risultato == "") {
				risultato+= " " + numeriGiusto[i];
			} else {
				risultato+= ", " + numeriGiusto[i];
			}
		}
		eRisultato.setText(risultato);
	}

	private void eseguiContaDuplicati() {
		
		String x;
		int numeri[], duplicati = 0, contatore = 0;
		
		x = cNumeri.getText();
		numeri = testoNumeri(x);
		for (int i = 0; i < numeri.length; i++) {
			contatore = 0;
			for (int z = i; z < numeri.length; z++) {
				if(numeri[i]==numeri[z]) {
					contatore++;
					if(contatore==2) {
						duplicati++;
					}
				}
			}
		}
		eRisultato.setText("i duplicati sono " + duplicati);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

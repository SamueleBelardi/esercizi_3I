package it.edu.iisgubbio.casa;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class EsercizioVettoreUno extends Application{

	TextField cVettore = new TextField("2 10 4 6 21 12 13 8 9 15 13");
	Button pEsegui = new Button("esegui");
	Label eVettore = new Label();
	
	public void start(Stage finestra) throws Exception {
		
		GridPane griglia = new GridPane();
		griglia.add(cVettore, 0, 0);
		griglia.add(pEsegui, 0, 1);
		griglia.add(eVettore, 0, 2);
		cVettore.setPrefWidth(250);
		pEsegui.setPrefWidth(250);
		eVettore.setPrefWidth(250);
		griglia.setId("sfondo");
		
		Scene scena = new Scene(griglia);
		scena.getStylesheets().add("it/edu/iisgubbio/casa/stile.css");
		finestra.setTitle("IndovinaNumero");
		finestra.setScene(scena);
		finestra.show();
		pEsegui.setOnAction( e -> eseguiEsegui());
		
	}
	
	private void eseguiEsegui() {
		
		int vettoreUno[], vettoreDue[];
		
		String vettore = cVettore.getText();
		String parti[] = vettore.split(" ");
		vettoreUno = new int[parti.length];
		
		for (int i = 0; i < parti.length; i++) {
			vettoreUno[i] = Integer.parseInt(parti[i]);
		}
		
		int nMaggioriDieci = 0;
		for(int i = 0; i < vettoreUno.length; i++) {
			if(vettoreUno[i] > 10) {
				nMaggioriDieci++;
			}
		}
		
		int posizioneDue = 0, somma = 0;
		vettoreDue = new int[nMaggioriDieci];
		for(int i = 0; i < vettoreUno.length; i++) {
			if(vettoreUno[i] > 10) {
				vettoreDue[posizioneDue] = vettoreUno[i];
				somma+= vettoreDue[posizioneDue];
				posizioneDue++;
				
			}
		}
		
		int media = somma / (posizioneDue);
		String vettoreFinale = " ";
		for(int i = 0; i < vettoreDue.length; i++) {
			if(vettoreDue[i] != 0) {
				if(vettoreFinale == " ") {
					vettoreFinale+=  + vettoreDue[i];
				} else {
					vettoreFinale+= ", " + vettoreDue[i];
				}
			}
		}
		
		vettoreFinale += " e media " + media;
		eVettore.setText(vettoreFinale);
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

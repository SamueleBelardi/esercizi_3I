package it.edu.iisgubbio.testi;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Anagramma extends Application {
	
	Label eParolaUno = new Label("parola 1");
	Label eParolaDue = new Label("parola 2");
	TextField cParolaUno = new TextField();
	TextField cParolaDue = new TextField();
	TextField cRisultato = new TextField();
	Button pAnagramma = new Button("anagramma?");
	
	public void start(Stage finestra) throws Exception {
	
		GridPane griglia = new GridPane();
		griglia.add(eParolaUno, 0, 0);
		griglia.add(eParolaDue, 1, 0);
		griglia.add(cParolaUno, 0, 1);
		griglia.add(cParolaDue, 1, 1);
		griglia.add(pAnagramma, 0, 2);
		griglia.add(cRisultato, 1, 2);
		griglia.setId("sfondo");
		
		Scene scene = new Scene(griglia);
		scene.getStylesheets().add("it/edu/iisgubbio/testi/stile.css");
		finestra.setTitle("Griglia");
		finestra.setScene(scene);
		finestra.show();
		pAnagramma.setOnAction( e -> eseguiAnagramma());
	}

	private void eseguiAnagramma() {
		
		char parolaUno[] = cParolaUno.getText().toCharArray();
		char parolaDue[] = cParolaDue.getText().toCharArray();
		boolean trovato;
		
		int lettereUguali = 0;
		for(int i = 0; i < parolaUno.length; i++) {
			trovato = false;
			for(int z = 0; z < parolaUno.length && trovato == false; z++) {
				if(parolaUno[i] == parolaDue[z]) {
					lettereUguali++;
					trovato = true;
					// parolaUno[i] = '#';
					parolaDue[z] = '#';
				}
			}
		}
		
		if(lettereUguali == parolaUno.length) {
			cRisultato.setText("E un anagramma");
		} else {
			cRisultato.setText("Non è un anagramma");
		}
	}
	
	public static void main(String[] args) {
		launch(args);
		
	}
}

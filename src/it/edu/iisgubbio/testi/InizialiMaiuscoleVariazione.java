package it.edu.iisgubbio.testi;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class InizialiMaiuscoleVariazione extends Application {
	
	TextField cFrase = new TextField();
	Button pMaiuscole = new Button("maiuscole");
	
	public void start(Stage finestra) throws Exception {
		
		GridPane griglia = new GridPane();
		griglia.add(pMaiuscole, 0, 1);
		griglia.add(cFrase, 0, 0);
		griglia.setId("sfondo");
		
		Scene scene = new Scene(griglia);
		scene.getStylesheets().add("it/edu/iisgubbio/testi/stile.css");
		finestra.setTitle("Griglia");
		finestra.setScene(scene);
		finestra.show();
		pMaiuscole.setOnAction( e -> eseguiMaiuscole());
		
	}

	private void eseguiMaiuscole() {
		
		char frase[] = cFrase.getText().toCharArray();
		
		for(int i = 0; i < frase.length; i++) {
			if(i == 0 && frase[i] >= 'Z') {
				frase[i] = ((char) (frase[i]-32)); 
			}
			if(frase[i] == '.' && frase[i+2] >= 'Z') {
				frase[i+2] = ((char) (frase[i+2]-32)); 
			}
		}
		
		String testo = new String(frase);
		cFrase.setText(testo);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
package it.edu.iisgubbio.vettori;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Media extends Application {
	
	Label eMedia = new Label("??");
	TextField cNumeri = new TextField();
	Button pMedia = new Button("media");
	
	public void start(Stage finestra) throws Exception {
		
		GridPane griglia = new GridPane();
		griglia.add(cNumeri, 0, 0, 3, 1);
		griglia.add(pMedia, 0, 1, 3, 1);
		griglia.add(eMedia, 0, 2, 3, 1);
		pMedia.setMaxWidth(Integer.MAX_VALUE);
		eMedia.setMaxWidth(Integer.MAX_VALUE);
		griglia.setId("sfondo");
		
		Scene scene = new Scene(griglia);
		scene.getStylesheets().add("it/edu/iisgubbio/vettori/stile.css");
		finestra.setTitle("Griglia");
		finestra.setScene(scene);
		finestra.show();
		pMedia.setOnAction( e -> eseguiMedia());
		
	}
	
	private void eseguiMedia() {
		
		String testo, parti[];
		int numeri[];
		double media = 0,somma = 0;
		
		testo = cNumeri.getText();
		parti = testo.split(" ");
		numeri = new int[parti.length];
		for (int i = 0; i < parti.length; i++) {
			numeri[i] = Integer.parseInt(parti[i]);
			somma+= numeri[i];
		}
		media = somma/numeri.length;
		eMedia.setText(media +"");
	}

	public static void main(String[] args) {
		launch(args);
	}
}

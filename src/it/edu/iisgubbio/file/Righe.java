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

public class Righe extends Application {
	
	Label eNome = new Label("n");
	TextField cFile = new TextField();
	TextField cLettura = new TextField();
	Button pLeggi = new Button("leggi");
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		GridPane g = new GridPane();
		g.add(eNome, 0, 0);
		g.add(cFile, 1, 0);
		g.add(pLeggi, 0, 1, 2, 1);
		g.add(cLettura, 0, 2, 2, 1);
		pLeggi.setPrefWidth(500);
		g.setId("sfondo");
		
		Scene scena = new Scene(g);
		primaryStage.setTitle("Demo");
		scena.getStylesheets().add("it/edu/iisgubbio/vettori/stile.css");
		primaryStage.setScene(scena);
		primaryStage.show();
		pLeggi.setOnAction( e -> eseguiLeggi());
	}

	private void eseguiLeggi() {
		int riga = Integer.parseInt(cFile.getText());
		
		try {
			FileReader flussoCaratteri = new FileReader("c:\\Users\\samuelebelardi\\Desktop\\prova.txt");
			BufferedReader lettoreDiRighe = new BufferedReader(flussoCaratteri);
			String testo = null;
			for(int i = 0; i < riga; i++) {
				testo = lettoreDiRighe.readLine();
			}
			cLettura.setText(testo);
			lettoreDiRighe.close();
			flussoCaratteri.close();
		} catch (IOException e) {
			cLettura.setText(e.getLocalizedMessage());
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
	
}

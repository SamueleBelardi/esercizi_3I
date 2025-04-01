package it.edu.iisgubbio.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Demo extends Application {
	
	Label eNome = new Label("nome");
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
		String nomeFile = cFile.getText();
		
		try {
			FileReader flussoCaratteri = new FileReader("c:\\Users\\samuelebelardi\\Desktop\\" + nomeFile + ".txt");
			char caratteri[] = new char[1000];
			int caratteriLetti = flussoCaratteri.read(caratteri);
			String testo = new String(caratteri,0,caratteriLetti);
			System.out.println(testo);
			flussoCaratteri.close();
		} catch (FileNotFoundException e){
			cLettura.setText(e.getLocalizedMessage());
		} catch (IOException e) {
			cLettura.setText(e.getLocalizedMessage());
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}

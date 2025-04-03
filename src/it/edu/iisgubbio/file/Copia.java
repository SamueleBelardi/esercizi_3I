package it.edu.iisgubbio.file;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Copia extends Application {

	Label eDa = new Label("da");
	Label eA = new Label("a");
	TextField cFileCopia = new TextField();
	TextField cFileIncolla = new TextField();
	Button pVai = new Button("vai!");
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		GridPane g = new GridPane();
		g.add(eDa, 0, 0);
		g.add(eA, 0, 1);
		g.add(cFileCopia, 1, 0);
		g.add(cFileIncolla, 1, 1);
		g.add(pVai, 0, 2, 2, 1);
		pVai.setPrefWidth(500);
		g.setId("sfondo");
		
		Scene scena = new Scene(g);
		primaryStage.setTitle("Demo");
		scena.getStylesheets().add("it/edu/iisgubbio/vettori/stile.css");
		primaryStage.setScene(scena);
		primaryStage.show();
		pVai.setOnAction( e -> eseguiVai());
	}

	private void eseguiVai() {
		String nomeFile = cFileCopia.getText();
		String nomeCopia = cFileIncolla.getText();
		
		try {
			FileReader flussoCaratteriLettura = new FileReader("c:\\Users\\samuelebelardi\\Desktop\\" + nomeFile + ".txt");
			char caratteri[] = new char[1000];
			int caratteriLetti = flussoCaratteriLettura.read(caratteri);
			String testo = new String(caratteri,0,caratteriLetti);
			System.out.println(testo);
			FileWriter flussoCaratteriScrittura = new FileWriter("c:\\Users\\samuelebelardi\\Desktop\\" + nomeCopia + ".txt");
			flussoCaratteriScrittura.write(testo);
			flussoCaratteriScrittura.close();
			flussoCaratteriLettura.close();
		} catch (IOException e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}

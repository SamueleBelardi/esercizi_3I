package it.edu.iisgubbio.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Somma extends Application {
	
	TextField cSomma = new TextField();
	Button pSomma = new Button("somma");
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		GridPane g = new GridPane();
		g.add(cSomma, 0, 1);
		g.add(pSomma, 0, 0);
		cSomma.setPrefWidth(300);
		pSomma.setPrefWidth(300);
		g.setId("sfondo");
		
		Scene scena = new Scene(g);
		primaryStage.setTitle("Demo");
		scena.getStylesheets().add("it/edu/iisgubbio/vettori/stile.css");
		primaryStage.setScene(scena);
		primaryStage.show();
		pSomma.setOnAction( e -> eseguiSomma());
	}

	private void eseguiSomma() {
		
		try {
			FileReader flussoCaratteri = new FileReader("c:\\Users\\samuelebelardi\\Desktop\\prova.txt");
			BufferedReader lettoreDiRighe = new BufferedReader(flussoCaratteri);
			String rigaLetta;
			int somma = 0;
			do {
			    rigaLetta = lettoreDiRighe.readLine();
			    if(rigaLetta!=null) {
			        somma += Integer.parseInt(rigaLetta);
			    }
			}while(rigaLetta!=null);
			cSomma.setText("" + somma);
			lettoreDiRighe.close();
			flussoCaratteri.close();
		} catch (IOException e) {
			cSomma.setText(e.getLocalizedMessage());
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}

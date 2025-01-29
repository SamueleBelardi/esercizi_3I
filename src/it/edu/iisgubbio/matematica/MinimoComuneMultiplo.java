package it.edu.iisgubbio.matematica;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MinimoComuneMultiplo extends Application{
	
	Label eNumeroUno = new Label("n1");
	Label eNumeroDue = new Label("n2");
	Label eRisultato = new Label("??");
	TextField cNumeroUno = new TextField();
	TextField cNumeroDue = new TextField();
	Button pMCM = new Button("MCM");

	public void start(Stage finestra) throws Exception {
		
		GridPane griglia = new GridPane();
		griglia.add(eNumeroUno, 0, 0);
		griglia.add(eNumeroDue, 0, 1);
		griglia.add(cNumeroUno, 1, 0);
		griglia.add(cNumeroDue, 1, 1);
		griglia.add(pMCM, 0, 2);
		griglia.add(eRisultato, 1, 2);
		griglia.setId("sfondo");
		eNumeroUno.getStyleClass().add("label");
		eNumeroDue.getStyleClass().add("label");
		eRisultato.getStyleClass().add("label");
		cNumeroUno.getStyleClass().add("text-field");
		cNumeroDue.getStyleClass().add("text-field");
		pMCM.getStyleClass().add("button");
		
		Scene scena = new Scene(griglia);
		scena.getStylesheets().add("it/edu/iisgubbio/matematica/stileTre.css");
		finestra.setTitle("MinimoComuneMultiplo");
		finestra.setScene(scena);
		finestra.show();
		pMCM.setOnAction( e -> eseguiMCM());
		cNumeroDue.setOnAction( e -> eseguiVariante());
	}

	private void eseguiVariante() {
		
		int numeroUno, numeroDue, minimoComuneMultiplo;
		
		minimoComuneMultiplo = 0;
		numeroUno = Integer.parseInt(cNumeroUno.getText());
		numeroDue = Integer.parseInt(cNumeroDue.getText());
		for( int n = numeroUno * numeroDue; n >= 1; n--) {
			minimoComuneMultiplo = numeroUno*n;
			if(minimoComuneMultiplo%numeroDue==0 ) {
				System.out.println(minimoComuneMultiplo);
				eRisultato.setText("" + minimoComuneMultiplo);
			} 
		}
	}

	private void eseguiMCM() {
		
		int numeroUno, numeroDue, minimoComuneMultiplo;
		
		minimoComuneMultiplo = 0;
		numeroUno = Integer.parseInt(cNumeroUno.getText());
		numeroDue = Integer.parseInt(cNumeroDue.getText());
		for( int n = 1; n <= numeroUno * numeroDue; n++) {
			minimoComuneMultiplo = numeroUno*n;
			if(minimoComuneMultiplo%numeroDue==0 ) {
				System.out.println(minimoComuneMultiplo);
				eRisultato.setText("" + minimoComuneMultiplo);
				break;
			} 
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}

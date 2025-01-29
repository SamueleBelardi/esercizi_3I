package it.edu.iisgubbio.numeri;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Fattoriale extends Application{

	Label eRisultato = new Label();
	TextField cNumero = new TextField();
	Button pFattorialeIterativo = new Button("Fattoriale Iterativo");
	Button pFattorialeRicorsivo = new Button("Fattoriale Ricorsivo");
	
	public void start(Stage finestra) throws Exception {
		
		GridPane griglia = new GridPane();
		griglia.add(cNumero, 0, 0);
		griglia.add(pFattorialeIterativo, 0, 1);
		griglia.add(pFattorialeRicorsivo, 0, 2);
		griglia.add(eRisultato, 0, 3);
		griglia.setId("sfondo");

		Scene scene = new Scene(griglia);
		scene.getStylesheets().add("it/edu/iisgubbio/vettori/stile.css");
		finestra.setTitle("Griglia");
		finestra.setScene(scene);
		finestra.show();
		pFattorialeIterativo.setOnAction( e -> eseguiIterativo());
		pFattorialeRicorsivo.setOnAction( e -> eseguiRicorsivo());
	}
	
	int fattorialeFor(int x) {
		int fattoriale=1;
		for(int i=1;i<=x;i++) {
			fattoriale=fattoriale*i;
		}
		return fattoriale;
	}
	int fattorialeRicorsivo(int x) {
		if(x==1) {
			return 1;
		}else {
			return x*fattorialeRicorsivo(x-1);
		}
		
	}
	private void eseguiIterativo() {
		int n=Integer.parseInt(cNumero.getText());
		int f=fattorialeFor(n);
		eRisultato.setText(""+f);
		
	}
	private void eseguiRicorsivo() {
		int n=Integer.parseInt(cNumero.getText());
		int f=fattorialeRicorsivo(n);
		eRisultato.setText(""+f);
		
	}
	public static void main(String[] args) {
		launch(args);
	}
}

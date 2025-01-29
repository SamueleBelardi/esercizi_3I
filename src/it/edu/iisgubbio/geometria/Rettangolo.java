package it.edu.iisgubbio.geometria;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Rettangolo extends Application {
	
	TextField cBase = new TextField();
	TextField cAltezza = new TextField();
	Label eBase = new Label("Base");
	Label eAltezza = new Label("Altezza");
	Label eArea = new Label("Area");
	Label ePerimetro = new Label("Perimetro");
	Button pArea = new Button("calcola l'area"); 
	Button pPerimetro = new Button("calcola il perimetro");


	
	public void start (Stage finestra) throws Exception {
		
		GridPane principale = new GridPane();
		principale.add(eBase, 0, 0);
		principale.add(eAltezza, 0, 1);
		principale.add(eArea, 1, 3);
		principale.add(ePerimetro, 0, 3);
		principale.add(cBase, 1, 1);
		principale.add(cAltezza, 1, 0);
		principale.add(pArea, 1, 2);
		principale.add(pPerimetro, 0, 2);
		
		Scene scena = new Scene(principale);
		finestra.setTitle("Rettangolo");
		finestra.setScene(scena);
		finestra.show();
		
		pArea.setOnAction( e -> eseguiArea( ));
		pPerimetro.setOnAction( e -> eseguiPerimetro());
	}
	
	private void eseguiPerimetro() {
		
		String base, altezza, perimetro;
		int baseI, altezzaI, perimetroI;
		

		base = cBase.getText();
		altezza = cAltezza.getText();
		baseI = Integer.parseInt(base);
		altezzaI = Integer.parseInt(altezza);
		perimetroI = (baseI * 2)+(altezzaI * 2);
		perimetro = "" + perimetroI;
		ePerimetro.setText(perimetro);
		
	
	}

	private void eseguiArea(){
		
		String base, altezza, area;
		int baseI, altezzaI, areaI;
		
		base = cBase.getText();
		altezza = cAltezza.getText();
		baseI = Integer.parseInt(base);
		altezzaI = Integer.parseInt(altezza);
		areaI = baseI * altezzaI;
		area = "" + areaI;
		eArea.setText(area);
		
		
		
	}

	 public static void main(String[] args) {
		    launch(args);
		  }
			
	

}


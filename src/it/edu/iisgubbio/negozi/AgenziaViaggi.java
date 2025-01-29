package it.edu.iisgubbio.negozi;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AgenziaViaggi extends Application {
	
	Label eNumeroPersone = new Label("numero persone");
	Label eCapienzaAutobus = new Label("capienza autobus");
	Label eCostoAutobus = new Label("costo autobus");
	Label eAutobusNecessari = new Label("autobus necessari:");
	Label eCostoPersona = new Label("costo a persona:");
	TextField cNumeroPersone = new TextField();
	TextField cCapienzaAutobus = new TextField();
	TextField cCostoAutobus = new TextField();

	public void start(Stage finestra) throws Exception {
		
		GridPane griglia = new GridPane();
		griglia.add(eNumeroPersone, 0, 0);
		griglia.add(eCapienzaAutobus, 0, 1);
		griglia.add(eCostoAutobus, 0, 2);
		griglia.add(eAutobusNecessari, 0, 3, 2, 1);
		griglia.add(eCostoPersona, 0, 4, 2, 1);
		griglia.add(cNumeroPersone, 1, 0);
		griglia.add(cCapienzaAutobus, 1, 1);
		griglia.add(cCostoAutobus, 1, 2);
		eNumeroPersone.getStyleClass().add("label-dati");
		eCapienzaAutobus.getStyleClass().add("label-dati");
		eCostoAutobus.getStyleClass().add("label-dati");
		eAutobusNecessari.getStyleClass().add("label-risposte");
		eCostoPersona.getStyleClass().add("label-risposte");
		cNumeroPersone.getStyleClass().add("text-field");
		cCapienzaAutobus.getStyleClass().add("text-field");
		cCostoAutobus.getStyleClass().add("text-field");
		griglia.getStyleClass().add("griglia");
		eAutobusNecessari.setMaxWidth(Integer.MAX_VALUE);
		eCostoPersona.setMaxWidth(Integer.MAX_VALUE);
		
		Scene scena = new Scene(griglia);
		scena.getStylesheets().add("it/edu/iisgubbio/negozi/stile.css");
		finestra.setTitle("AgenziaViaggi");
		finestra.setScene(scena);
		finestra.show();
		
		cCostoAutobus.setOnAction( e -> esuguiCosto());
	}
	
	private void esuguiCosto() {
		
		int numeroPersone, capienzaAutobus, costoAutobus, autobusNecessari;
		double costoPersona;
		
		numeroPersone = Integer.parseInt(cNumeroPersone.getText());
		capienzaAutobus = Integer.parseInt(cCapienzaAutobus.getText());
		costoAutobus = Integer.parseInt(cCostoAutobus.getText());
		if(numeroPersone%capienzaAutobus!=0) {
			autobusNecessari = (numeroPersone/capienzaAutobus) + 1;
		} else {
			autobusNecessari = (numeroPersone/capienzaAutobus);
		}
		costoPersona = ((costoAutobus*autobusNecessari)/numeroPersone);
		eAutobusNecessari.setText("autobus necessari: " + autobusNecessari);
		eCostoPersona.setText("costo a persona: " + costoPersona);
	}

	public static void main(String[] args) {
		launch(args);
	}

}

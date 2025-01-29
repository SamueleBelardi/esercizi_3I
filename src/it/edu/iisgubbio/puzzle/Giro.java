package it.edu.iisgubbio.puzzle;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Giro extends Application {
	
	TextField cUno = new TextField();
	TextField cDue = new TextField(); 
	TextField cTre = new TextField(); 
	TextField cQuattro = new TextField();
	Button pGiro = new Button();

public void start(Stage finestra) throws Exception {
		
	GridPane principale = new GridPane();
	principale.add(cUno, 0, 0);
	principale.add(cDue, 2, 0);
	principale.add(cTre, 0, 2);
	principale.add(cQuattro, 2, 2);
	principale.add(pGiro, 1, 1);
		
		
	Scene scena = new Scene(principale);
	finestra.setTitle("Giro");
	finestra.setScene(scena);
	finestra.show();
		
	pGiro.setOnAction( e -> eseguiGiro());
	
	}

private void eseguiGiro() {
		
	String Uno, Due, Tre, Quattro;
	Uno = cUno.getText();
	Due = cDue.getText();
	Tre = cTre.getText();
	Quattro = cQuattro.getText();
	cUno.setText(Tre);
	cDue.setText(Uno);
	cQuattro.setText(Due);
	cTre.setText(Quattro);
		
		
		
	}
	
	 public static void main(String[] args) {
		    launch(args);
	}

	
}

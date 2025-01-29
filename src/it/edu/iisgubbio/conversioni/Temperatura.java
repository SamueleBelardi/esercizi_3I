package it.edu.iisgubbio.conversioni;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Temperatura extends Application {
	
	Label eCelsius = new Label("celsius");
	Label eFahrenheit = new Label("fahrenheit");
	TextField cCelsius = new TextField();
	TextField cFahrenheit = new TextField();
	Button pCelsius = new Button("converti in C");
	Button pFahrenheit = new Button("converti in F");

	public void start(Stage finestra) throws Exception {
		
		GridPane principale = new GridPane();
		principale.add(eCelsius, 0, 0);
		principale.add(eFahrenheit, 1, 0);
		principale.add(cCelsius, 0, 1);
		principale.add(cFahrenheit, 1, 1);
		principale.add(pCelsius, 2, 0);
		principale.add(pFahrenheit, 2, 1);
		
		principale.setHgap(10);
		principale.setVgap(10);
		principale.setPadding(new Insets(10));
		
		Scene scena = new Scene(principale);
		finestra.setTitle("Temperatura");
		finestra.setScene(scena);
		finestra.show();
		
		pCelsius.setOnAction( e -> eseguiCelsius( ));
		pFahrenheit.setOnAction( e -> eseguiFahrenheit());
		
		cCelsius.setOnAction( e -> eseguiCelsiusC( ));
		cFahrenheit.setOnAction( e -> eseguiFahrenheitC());
		
		
		
	}

	private void eseguiCelsiusC() {
		
		String celsius, fahrenheit;
		double celsiusI, fahrenheitI;
		
		celsius = cCelsius.getText();
		celsiusI = Double.parseDouble(celsius);
		fahrenheitI = (celsiusI*9/5)+32;
		fahrenheit = "" + fahrenheitI;
		cFahrenheit.setText(fahrenheit);
	}

	private void eseguiFahrenheitC() {
		
		String celsius, fahrenheit;
		double celsiusI, fahrenheitI;
		
		fahrenheit = cFahrenheit.getText();
		fahrenheitI = Double.parseDouble(fahrenheit);
		celsiusI = (fahrenheitI-32)/1.8;
		celsius = "" + celsiusI;
		cCelsius.setText(celsius);
	}
		
	private void eseguiFahrenheit() {
		
		String celsius, fahrenheit;
		double celsiusI, fahrenheitI;
		
		celsius = cCelsius.getText();
		celsiusI = Double.parseDouble(celsius);
		fahrenheitI = (celsiusI*9/5)+32;
		fahrenheit = "" + fahrenheitI;
		cFahrenheit.setText(fahrenheit);
	}

	private void eseguiCelsius() {
		
		String celsius, fahrenheit;
		double celsiusI, fahrenheitI;
		
		fahrenheit = cFahrenheit.getText();
		fahrenheitI = Double.parseDouble(fahrenheit);
		celsiusI = (fahrenheitI-32)/1.8;
		celsius = "" + celsiusI;
		cCelsius.setText(celsius);
	}
	
	
		 public static void main(String[] args) {
			    launch(args);
		
	}
	}
	


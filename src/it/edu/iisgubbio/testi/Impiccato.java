package it.edu.iisgubbio.testi;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Impiccato extends Application{
	
	Image i = new Image(getClass().getResourceAsStream("6.png"));
    ImageView iw = new ImageView(i);
	Label eLettera = new Label("lettera");
	Label eTentativi = new Label("tentativi");
	Label eLettereSbagliate = new Label("lettere usate");
	TextField cParola = new TextField();
	TextField cLettera = new TextField();
	TextField cTentativi = new TextField("6");
	TextField cLettereSbagliate = new TextField();
	Button pVia = new Button("vai");
	Button pProva = new Button("prova");
	char car[];
	char soluzione[];
	int errori = 0;
	
	public void start(Stage finestra) throws Exception {
		
		GridPane griglia = new GridPane();
		griglia.add(cParola, 0, 0, 2, 1);
		griglia.add(pVia, 2, 0);
		griglia.add(eLettera, 0, 1);
		griglia.add(cLettera, 1, 1);
		griglia.add(pProva, 2, 1);
		griglia.add(eTentativi, 0, 2);
		griglia.add(cTentativi, 1, 2);
		griglia.add(eLettereSbagliate, 0, 3);
		griglia.add(cLettereSbagliate, 1, 3);
		griglia.setId("sfondo");
		cParola.getStyleClass().add("textfield");
		cLettera.getStyleClass().add("textfield");
		griglia.add(iw, 2, 2, 1, 3);

		Scene scene = new Scene(griglia);
		scene.getStylesheets().add("it/edu/iisgubbio/testi/stile.css");
		scene.getStylesheets().add("it/edu/iisgubbio/testi/stileImpiccato.css");
		finestra.setTitle("Griglia");
		finestra.setScene(scene);
		finestra.show();
		pVia.setOnAction( e -> eseguiVia());
		pProva.setOnAction( e -> eseguiProva());
	}
	
	private void eseguiProva() {
		
		char lettera;
		boolean presenza = false;
		int contatore = 0, presente = 0, tentativi = 0;
		String parola, letteraUsate = cLettereSbagliate.getText() ;
		
		tentativi = Integer.parseInt(cTentativi.getText());
		parola = cLettera.getText();
		lettera = parola.charAt(0);

		for(int i = 1; i < car.length-1; i++) {
			if(lettera==soluzione[i]) {
				car[i] = soluzione[i]; 
				presente++;
				presenza = true;
			}
		}
		
		cLettereSbagliate.setText("" + letteraUsate + ", " + lettera);
		if(presente==0) {
			errori++;
		}
		if(presenza==false) {
			tentativi--;
			iw.setImage(new Image(getClass().getResourceAsStream(tentativi+".png")));
			
			cTentativi.setText("" + tentativi);
		}
		
		String testo = new String(car);
		cParola.setText(testo);
		
		for(int i = 0; i < car.length; i++) {
			if(car[i] == soluzione[i]) {
				contatore++;
			}
		}
		if(contatore == car.length) {
			cTentativi.setText("HAI VINTO :)");
		}
		if(errori >= 6) {
			cTentativi.setText("HAI PERSO :(");
		}
	
	}

	private void eseguiVia() {
		
		String parola;
		
		parola = cParola.getText();
		car = parola.toCharArray();
		soluzione = parola.toCharArray();
		
		for( int i = 1; i < car.length-1; i++) {
			if(car[i]!=' ') {
				car[i] = '-';
			}
		}
		String testo = new String(car);
		cParola.setText(testo);
	}

	public static void main(String[] args) {
		launch(args);
		
	}

}

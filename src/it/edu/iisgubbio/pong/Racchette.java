package it.edu.iisgubbio.pong;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Racchette extends Application {

	static final double DIMENSIONE_X = 400;
	static final double DIMENSIONE_Y = 400;
	static final double DIMENSIONE_RACCHETTA_X = 20;
	static final double DIMENSIONE_RACCHETTA_Y = 100;
	Pane areaDiGioco = new Pane();
	Rectangle racchettaSinistra = new Rectangle(DIMENSIONE_RACCHETTA_X, DIMENSIONE_RACCHETTA_Y );
	Rectangle racchettaDestra = new Rectangle(DIMENSIONE_RACCHETTA_X, DIMENSIONE_RACCHETTA_Y);
	double posizioneSinistraX = 0;
	double posizioneSinstraY = 40;
	double posizioneDestraX = 380;
	double posizioneDestraY = 40;
	
	
	public void start(Stage finestra) throws Exception {

		areaDiGioco.setPrefSize(DIMENSIONE_X, DIMENSIONE_Y);
		areaDiGioco.getChildren().add(racchettaSinistra);
		racchettaSinistra.setX(posizioneSinistraX);
		racchettaSinistra.setY(posizioneSinstraY);
		areaDiGioco.getChildren().add(racchettaDestra);
		racchettaDestra.setX(posizioneDestraX);
		racchettaDestra.setY(posizioneDestraY);

		Scene scena = new Scene(areaDiGioco);
		finestra.setTitle("Racchette"); 
		finestra.setScene(scena);
		finestra.show();
		scena.setOnKeyPressed( e -> tastoPremuto(e));
	}

	private void tastoPremuto(KeyEvent e) {
		System.out.println(e.getText());
		if(e.getText().equals("s")) {
			posizioneSinstraY+= 5;
		}
		if(e.getText().equals("w")) {
			posizioneSinstraY-= 5;
		}
		if(e.getCode()==KeyCode.DOWN) {
			posizioneDestraY+= 5;
		}
		if(e.getCode()==KeyCode.UP) {
			posizioneDestraY-= 5;
		}
		if(posizioneSinstraY>DIMENSIONE_Y-DIMENSIONE_RACCHETTA_Y) {
			posizioneSinstraY = DIMENSIONE_Y-DIMENSIONE_RACCHETTA_Y;
		}
		if(posizioneSinstraY<0) {
			posizioneSinstraY = 0;
		}
		if(posizioneDestraY>DIMENSIONE_Y-DIMENSIONE_RACCHETTA_Y) {
			posizioneDestraY = DIMENSIONE_Y-DIMENSIONE_RACCHETTA_Y;
		}
		if(posizioneDestraY<0) {
			posizioneDestraY = 0;
		}
		racchettaSinistra.setY(posizioneSinstraY);
		racchettaDestra.setY(posizioneDestraY);
	}

	public static void main(String[] args) {
		launch(args);
	}
}

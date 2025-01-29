package it.edu.iisgubbio.pong;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Pong extends Application {

	Rectangle racchettaSinistra = new Rectangle(DIMENSIONE_RACCHETTA_X, DIMENSIONE_RACCHETTA_Y );
	Rectangle racchettaDestra = new Rectangle(DIMENSIONE_RACCHETTA_X, DIMENSIONE_RACCHETTA_Y);
	static final double DIMENSIONE_RACCHETTA_X = 10;
	static final double DIMENSIONE_RACCHETTA_Y = 100;
	static final double DIMENSIONE_X = 600;
	static final double DIMENSIONE_Y = 400;
	double posizioneSinistraX = 40;
	double posizioneSinstraY = 150;
	double posizioneDestraX = 550;
	double posizioneDestraY = 150;
	double numeroRimbalzi = 0;
	double incrementoDue = 2;
	double incremento = 2;
	double velocita = 0;
	double raggio = 10;
	int punteggioUno = 0;
	int punteggioDue = 0;
	Pane areaDiGioco = new Pane();
	Circle cerchio = new Circle(raggio);
	Text utenteUno = new Text();
	Text utenteDue = new Text();


	public void start(Stage finestra) throws Exception {

		areaDiGioco.setPrefSize(DIMENSIONE_X, DIMENSIONE_Y);
		areaDiGioco.getChildren().add(racchettaSinistra);
		racchettaSinistra.setX(posizioneSinistraX);
		racchettaSinistra.setY(posizioneSinstraY);
		areaDiGioco.getChildren().add(racchettaDestra);
		racchettaDestra.setX(posizioneDestraX);
		racchettaDestra.setY(posizioneDestraY);
		areaDiGioco.getChildren().add(cerchio);
		cerchio.setCenterX(200);
		cerchio.setCenterY(150);
		areaDiGioco.getChildren().add(utenteUno);
		utenteUno.setX((DIMENSIONE_X/2)+20);
		utenteUno.setY(30);
		utenteUno.setText(punteggioUno+"");
		areaDiGioco.getChildren().add(utenteDue);
		utenteDue.setX((DIMENSIONE_X/2)-20);
		utenteDue.setY(30);
		utenteDue.setText(punteggioDue+"");
		utenteDue.setFill(Color.RED);
		racchettaSinistra.setId("racchetta-sinistra");
		racchettaDestra.setId("racchetta-destra");
		utenteUno.setId("utente-uno");
		utenteDue.setId("utente-due");
		cerchio.setId("pallina");
		areaDiGioco.setId("sfondo");
		
		Scene scena = new Scene(areaDiGioco);
		scena.getStylesheets().add("it/edu/iisgubbio/pong/stile.css");
		finestra.setTitle("Racchette"); 
		finestra.setScene(scena);
		finestra.show();
		scena.setOnKeyPressed( e -> tastoPremuto(e));

		Timeline timeline = new Timeline(new KeyFrame(
				Duration.seconds(0.02), 
				x -> aggiornaPallina()));
		timeline.setCycleCount(-1);
		timeline.play();

	}

	private void tastoPremuto(KeyEvent e) {
		
		if(e.getText().equals("s") || e.getText().equals("S")) {
			posizioneSinstraY+= 10;
		}
		
		if(e.getText().equals("w") || e.getText().equals("W")) {
			posizioneSinstraY-= 10;
		}
		
		if(e.getCode()==KeyCode.DOWN) {
			posizioneDestraY+= 10;
		}
		
		if(e.getCode()==KeyCode.UP) {
			posizioneDestraY-= 10;
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

	private void aggiornaPallina() {
		
		double z = 0;
		Bounds b1 = cerchio.getBoundsInParent();
        Bounds b2 = racchettaSinistra.getBoundsInParent();
        Bounds b3 = racchettaDestra.getBoundsInParent();
		cerchio.setCenterX(cerchio.getCenterX()+incremento);
		cerchio.setCenterY(cerchio.getCenterY()+incrementoDue);
		z = Math.random()-0.5;

		if(cerchio.getCenterX() >= DIMENSIONE_X-raggio) {
			incremento = -4 + z;
			punteggioDue++;
			utenteDue.setText(punteggioDue+"");
			cerchio.setCenterX(DIMENSIONE_X / 2);
			cerchio.setCenterY(DIMENSIONE_Y / 2);

		}

		if(cerchio.getCenterX() <= raggio) {
			incremento = 4 + z;
			punteggioUno++;
			utenteUno.setText(punteggioUno+"");
			cerchio.setCenterX(DIMENSIONE_X / 2);
			cerchio.setCenterY(DIMENSIONE_Y / 2); 
		}

		if(cerchio.getCenterY() >= DIMENSIONE_Y-raggio) {
			incrementoDue = -4 + z; 
		}

		if(cerchio.getCenterY() <= raggio) {
			incrementoDue = 4 + z;
		}
		
		if(b1.intersects(b2)) {
			incremento = 4 + z;
		}
		
		if(b1.intersects(b3)) {
			incremento = -4 + z;
		}
}

	public static void main(String[] args) {
		launch(args);
	}
}

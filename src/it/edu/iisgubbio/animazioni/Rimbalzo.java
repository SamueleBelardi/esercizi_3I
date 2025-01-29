package it.edu.iisgubbio.animazioni;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Rimbalzo extends Application {

	static final double DIMENSIONE_X = 600;
	Pane areaDiGioco = new Pane();
	Circle cerchio = new Circle(20); 
	int incremento = 0;
	double raggio = 20;
	double posizione = 20;

	
	public void start(Stage finestra) throws Exception {

		areaDiGioco.setPrefSize(DIMENSIONE_X, 200);
		cerchio.setCenterX(raggio);
		cerchio.setCenterY(raggio);
		cerchio.setFill(Color.BLACK );
		areaDiGioco.getChildren().add(cerchio);
		Timeline timeline = new Timeline(new KeyFrame(
				Duration.seconds(0.05), 
				x -> aggiornaPallina()));
		timeline.setCycleCount(-1);
		timeline.play();

		Scene scene = new Scene(areaDiGioco);
		finestra.setTitle("PannelloPallina"); 
		finestra.setScene(scene);
		finestra.show();
	}

	private void aggiornaPallina() {
		
		cerchio.setCenterX(cerchio.getCenterX()+incremento);
		if(cerchio.getCenterX() >= DIMENSIONE_X-raggio) {
			incremento = -10;
		}
		if(cerchio.getCenterX() <= raggio) {
			incremento = 10;
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}

package it.edu.iisgubbio.pong;
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

	static final double DIMENSIONE_X = 400;
	static final double DIMENSIONE_Y = 400;
	Pane areaDiGioco = new Pane();
	double raggio = 10;
	Circle cerchio = new Circle(raggio); 
	double z = 0;
	int incremento = 20;
	int incrementoDue = 5;

	public void start(Stage finestra) throws Exception {

		areaDiGioco.setPrefSize(DIMENSIONE_X, DIMENSIONE_Y);
		cerchio.setCenterX(200);
		cerchio.setCenterY(150);
		cerchio.setFill(Color.BLACK );
		areaDiGioco.getChildren().add(cerchio);
		Timeline timeline = new Timeline(new KeyFrame(
				Duration.seconds(0.05), 
				x -> aggiornaPallina()));
		timeline.setCycleCount(-1);
		timeline.play();

		Scene scene = new Scene(areaDiGioco);
		finestra.setTitle("Rimbalzo"); 
		finestra.setScene(scene);
		finestra.show();
	}

	private void aggiornaPallina() {
		
		cerchio.setCenterX(cerchio.getCenterX()+incremento);
		cerchio.setCenterY(cerchio.getCenterY()+incrementoDue);
		z = Math.random();
		if(cerchio.getCenterX() >= DIMENSIONE_X-raggio) {
			if(z>0.5) {
				incremento = -20;
			} else {
				incremento = -15;
			}
		}
		if(cerchio.getCenterX() <= raggio) {
			if(z>0.5) {
				incremento = 20;
			} else {
				incremento = 15;
			}
		}
		if(cerchio.getCenterY() >= DIMENSIONE_Y-raggio) {
			if(z>0.5) {
				incrementoDue = -5;
			} else {
				incrementoDue = -10;
			}
		}
		if(cerchio.getCenterY() <= raggio) {
			if(z>0.5) {
				incrementoDue = 5;
			} else {
				incrementoDue = 10;
			}
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}

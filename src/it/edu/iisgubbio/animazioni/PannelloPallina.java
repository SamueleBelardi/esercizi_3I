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

public class PannelloPallina extends Application{
	
	Pane areaDiGioco = new Pane();
    Circle cerchio = new Circle(30); 
    double posizione = 30;
    double grandezza = 30;
    
	public void start(Stage finestra) throws Exception {
		
	    areaDiGioco.setPrefSize(300, 300);
	    cerchio.setCenterX(30);
	    cerchio.setCenterY(30);
	    cerchio.setFill(Color.BLACK );
	    areaDiGioco.getChildren().add(cerchio);
	    
		Scene scene = new Scene(areaDiGioco);
		finestra.setTitle("PannelloPallina"); 
		finestra.setScene(scene);
		finestra.show();
		
		Timeline timeline = new Timeline(new KeyFrame(
		Duration.seconds(0.1), 
		x -> aggiornaPallina()));
	    timeline.setCycleCount(100);
	    timeline.play();
		
	}
    
    private void aggiornaPallina() {
		
    	posizione+= 5;
    	grandezza-= 0.5;
    	cerchio.setCenterX(posizione);
    	cerchio.setRadius(grandezza);
	}

	public static void main(String[] args) {
		launch(args);
	}
}

package it.edu.iisgubbio.animazioni;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Animazione extends Application {
	
	double direzioneX=2, direzioneY=2;
	static final double START_X = 0, START_Y = 0, END_X = 50, END_Y = 50, WIDHT_LINEA = 5;
	Line linea = new Line(START_X, START_Y, END_X, END_Y);
	Pane areaDiGioco = new Pane();
    
    public void start(Stage primaryStage) throws Exception {
        
    	areaDiGioco.setPrefSize(400, 400);
        areaDiGioco.getChildren().add(linea);
        linea.setStrokeWidth(WIDHT_LINEA);
                
        Scene scena = new Scene(areaDiGioco);
        primaryStage.setScene(scena);
        primaryStage.setTitle("Pannello Pallina");
        primaryStage.show();
      
	    Timeline timeline = new Timeline(new KeyFrame(
	    		Duration.seconds(0.02), 
	  	     	x -> aggiornaRimbalzo()));
	    timeline.setCycleCount(-1);
	  	timeline.play();
	  	   
    }
    
	private void aggiornaRimbalzo() {
		
		linea.setStartX(linea.getStartX()+direzioneX);
		linea.setEndX(linea.getEndX()+direzioneX);
		linea.setStartY(linea.getStartY()+direzioneY);
		linea.setEndY(linea.getEndY()+direzioneY);
		
  		if (linea.getStartX()>=START_X-WIDHT_LINEA) {	
  			direzioneX=-2;
  		}
  	
  		if(linea.getStartY()>=START_Y-WIDHT_LINEA) {		
  			direzioneY=-2;		
  		}      
  		
  		if(linea.getStartX()<=END_X-WIDHT_LINEA) {
  			direzioneX=+2;
  		}
  		
  		if(linea.getStartY()<=END_Y-WIDHT_LINEA) {	
  			direzioneY=+2;
  		} 
  	}
	

    public static void main(String[] args) {
        launch(args);
    }
}
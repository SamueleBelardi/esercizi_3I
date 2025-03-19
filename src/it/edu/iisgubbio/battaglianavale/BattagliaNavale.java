package it.edu.iisgubbio.battaglianavale;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class BattagliaNavale extends Application {
	ImageView [][] q;
	Image acqua = new Image(getClass().getResourceAsStream("acqua.png"));
	Image affondato = new Image(getClass().getResourceAsStream("affondato.png"));
	Image colpito = new Image(getClass().getResourceAsStream("colpito.png"));
	
	
	@Override 
	public void start(Stage primaryStage) throws Exception {
		GridPane g = new GridPane();
		q = new ImageView[10][10];
		for(int x = 0; x < q[x].length; x++) {
			for(int y = 0; y < q[y].length; y++) {
				q[x][y] = new ImageView(acqua);
				g.add(q[x][y], x, y);
			}
		}
		q[2][1].setImage(colpito);
		
		Scene scena = new Scene(g);
		primaryStage.setTitle("BattagliaNavale");
		primaryStage.setScene(scena);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

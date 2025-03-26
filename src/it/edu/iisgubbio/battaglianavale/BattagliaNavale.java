package it.edu.iisgubbio.battaglianavale;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class BattagliaNavale extends Application {
	ImageView [][] q;
	Image acqua = new Image(getClass().getResourceAsStream("acqua.png"));
	Image affondato = new Image(getClass().getResourceAsStream("affondato.png"));
	Image colpito = new Image(getClass().getResourceAsStream("colpito.png"));
	Image nonColpito = new Image(getClass().getResourceAsStream("nonColpito.png"));
	TextField coordinateX = new TextField();
	TextField coordinateY = new TextField();
	Button spara = new Button("spara");
	Label esito = new Label("???");

	Nave [] flotta = new Nave[4];
	
	@Override 
	public void start(Stage primaryStage) throws Exception {
		GridPane g = new GridPane();
		q = new ImageView[10][10];
		for(int x = 0; x < q.length; x++) {
			for(int y = 0; y < q[x].length; y++) {
				q[x][y] = new ImageView(acqua);
				g.add(q[x][y], x, y);
			}
		}
		
		for (int i = 0; i < flotta.length; i++) {
			boolean sonoSovrapposte = false;
			do {
				if(Math.random()<0.5) {
					flotta[i] = new Nave("Schettino's boat", (int) (Math.random()*(10-4)), 
							(int) (Math.random()*(10)), 4, true);
				} else {
					flotta[i] = new Nave("Schettino's boat", (int) (Math.random()*(10)), 
							(int) (Math.random()*(10-4)), 4, false);
				}
				sonoSovrapposte = false;
				for(int p = 0; p < i; p++) {
					if(flotta[i].sovrappone(flotta[p])) {
						sonoSovrapposte = true;
					}
				}
				System.out.println(sonoSovrapposte);
			} while(sonoSovrapposte);
			System.out.println(flotta[i]);
		}
		
		g.add(coordinateX, 0, 10);
		g.add(coordinateY, 1, 10);
		g.add(spara, 2, 10, 2, 1);
		g.add(esito, 4, 10, 3, 1);
		coordinateX.setPrefWidth(30);
		coordinateX.setPromptText("coordinate x");
		coordinateY.setPrefWidth(30);
		coordinateY.setPromptText("coordinate y");
		
		Scene scena = new Scene(g);
		primaryStage.setTitle("BattagliaNavale");
		primaryStage.setScene(scena);
		primaryStage.show();
		spara.setOnAction( e -> eseguiSpara());
	}
	
	private void eseguiSpara() {
		int cX, cY;
		cX = Integer.parseInt(coordinateX.getText());
		cY = Integer.parseInt(coordinateY.getText());
		
		q[cX][cY].setImage(nonColpito);
		for( int i = 0; i < flotta.length; i++) {
			if(flotta[i].colpo(cX, cY)) {
				q[cX][cY].setImage(colpito);
			}
		}
		
		for( int i = 0; i < flotta.length; i++) {
			if(flotta[i].affondato()) {
				for(int p = 0; p < flotta.length; p++) {
					Pezzo[] pezzi = flotta[i].getPezzi();
					q[pezzi[p].x][pezzi[p].y].setImage(affondato);
				}
			}
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}

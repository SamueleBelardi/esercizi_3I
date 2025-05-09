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

	// se la nave è lunga 2: si chiama incrociatore
	// se la nave è lunga 3: si chiama sottomarino
	// se la nave è lunga 4: si chiama porta arei
	int [] misure = {2, 3, 3, 4, 4};
	Nave [] flotta = new Nave[misure.length];
	
	@Override 
	public void start(Stage primaryStage) throws Exception {
		GridPane g = new GridPane();
		q = new ImageView[10][10];
		
		// for che imposta lo sfondo della griglia
		for(int x = 0; x < q.length; x++) {
			for(int y = 0; y < q[x].length; y++) {
				q[x][y] = new ImageView(acqua);
				g.add(q[x][y], x, y);
			}
		}
		
		// costruzione della flotta di navi
		for (int i = 0; i < flotta.length; i++) {
			boolean sonoSovrapposte;
			String nomeNave = switch (misure[i]) {
				case 2 -> "incrociatore";
				case 3 -> "sottomarino";
				case 4 -> "porta aerei";
				default -> "nave";
			};
		
			do {
				if(Math.random()<0.5) {
					flotta[i] = new Nave(
							nomeNave, 
							(int) (Math.random()*(10-misure[i])), 
							(int) (Math.random()*(10)), 
							misure[i], 
							true);
				} else {
					flotta[i] = new Nave(
							nomeNave, 
							(int) (Math.random()*(10)), 
							(int) (Math.random()*(10-misure[i])),
							misure[i], 
							false);
				}
	
				sonoSovrapposte = false;
				// controlla se le nuova nave si sovrappone con quelle gia presenti
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
				esito.setText("colpito");
			}
		}
		
		// controlla se la nave è affondata
		for( int i = 0; i < flotta.length; i++) {
			if(flotta[i].affondato()) {
				Pezzo[] pezzi = flotta[i].getPezzi();
				for(int p = 0; p < pezzi.length; p++) {
					q[pezzi[p].x][pezzi[p].y].setImage(affondato);
					esito.setText("nave affondata");
				}
			}
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}

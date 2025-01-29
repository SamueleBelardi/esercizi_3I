package it.edu.iisgubbio.geometria;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class VerificaTriangolo extends Application {
	
	Label eLatoUno = new Label("lato 1");
	Label eLatoDue = new Label("lato 2");
	Label eLatoTre = new Label("lato 3");
	Label eRisultato = new Label("??");
	Label eTipo = new Label("??");
	Label eRettangolo = new Label("??");
	TextField cLatoUno = new TextField();
	TextField cLatoDue = new TextField();
	TextField cLatoTre = new TextField();
	Button pControlla = new Button("Controlla");
	Button pTipo = new Button("tipo");
	Button pRettangolo = new Button("rettangolo");
	

	public void start(Stage finestra) throws Exception {
		
		GridPane griglia = new GridPane();
		griglia.add(eLatoUno, 0, 0);
		griglia.add(eLatoDue, 0, 1);
		griglia.add(eLatoTre, 0, 2);
		griglia.add(eRisultato, 0, 3, 3, 1);
		griglia.add(eTipo, 3, 2);
		griglia.add(eRettangolo, 4, 2);
		griglia.add(cLatoUno, 1, 0);
		griglia.add(cLatoDue, 1, 1);
		griglia.add(cLatoTre, 1, 2);
		griglia.add(pControlla, 2, 0, 1, 3);
		griglia.add(pTipo, 3, 0, 1, 2);
		griglia.add(pRettangolo, 4, 0, 1, 2);
		pTipo.setMaxHeight(Integer.MAX_VALUE);
		pControlla.setMaxHeight(Integer.MAX_VALUE);
		eRisultato.setMaxHeight(Integer.MAX_VALUE);
		pRettangolo.setMaxHeight(Integer.MAX_VALUE);
		
		Scene scena = new Scene(griglia);
		finestra.setTitle("Temperatura");
		finestra.setScene(scena);
		finestra.show();
		
		pControlla.setOnAction( e -> eseguiControlla());
		pTipo.setOnAction( e -> eseguiTipo());
		pRettangolo.setOnAction( e -> eseguiRettangolo());
	}

	private void eseguiRettangolo() {
		
		int lato1, lato2, lato3;
		
		lato1 = Integer.parseInt(cLatoUno.getText());
		lato2 = Integer.parseInt(cLatoDue.getText());
		lato3 = Integer.parseInt(cLatoTre.getText());
		
		if((lato1 * lato1)+(lato2 * lato2) == (lato3 * lato3) || (lato1 * lato1)+(lato3 * lato3) == (lato2 * lato2) || (lato3 * lato3)+(lato2 * lato2) == (lato1 * lato1)) {
			eRettangolo.setText("si");
		} else {
			eRettangolo.setText("no");
		}
		
	}

	private void eseguiTipo() {
		
		int lato1, lato2, lato3;
		
		lato1 = Integer.parseInt(cLatoUno.getText());
		lato2 = Integer.parseInt(cLatoDue.getText());
		lato3 = Integer.parseInt(cLatoTre.getText());
		
		if(lato1 == lato2 && lato1 == lato3 && lato2 == lato3)  {
			eTipo.setText("equialtero");
		} else  {
			if(lato1 == lato2 || lato2 == lato3 || lato1 == lato3)  {
				eTipo.setText("isoscele");
			} else {
				eTipo.setText("scaleno");
			}
		}
	}

	private void eseguiControlla() {
		
		int lato1, lato2, lato3;
		
		lato1 = Integer.parseInt(cLatoUno.getText());
		lato2 = Integer.parseInt(cLatoDue.getText());
		lato3 = Integer.parseInt(cLatoTre.getText());
		
		if(lato1 + lato2 > lato3 && lato1 + lato3 > lato2 & lato2 + lato3 > lato1) {
			eRisultato.setText("il traingolo puo esistere");
		} else {
			eRisultato.setText("il traingolo non puo esistere");
		}
				
	}
	
	 public static void main(String[] args) {
		    launch(args);
	
}
}

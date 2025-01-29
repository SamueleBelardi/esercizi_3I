package it.edu.iisgubbio.geometria;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TriangoloRettangolo extends Application {
	
	Label eCatetoUno = new Label("cateto 1");
	Label eCatetoDue = new Label("cateto2");
	Label eIpotenusa = new Label("Ipotenusa");
	TextField cCatetoUno = new TextField();
	TextField cCatetoDue = new TextField();
	TextField cIpotenusa = new TextField();
	Button pCatetoUno = new Button("calcola cateto 1");
	Button pCatetoDue = new Button("calcola cateto 2");
	Button pIpotenusa = new Button("calcola ipotenusa");
	
	
	public void start(Stage finestra) throws Exception {
		
		GridPane principale = new GridPane();
		principale.add(eCatetoUno, 0, 0);
		principale.add(eCatetoDue, 0, 1);
		principale.add(eIpotenusa, 0, 2);
		principale.add(cCatetoUno, 1, 0);
		principale.add(cCatetoDue, 1, 1);
		principale.add(cIpotenusa, 1, 2);
		principale.add(pCatetoUno, 2, 0);
		principale.add(pCatetoDue, 2, 1);
		principale.add(pIpotenusa, 2, 2);
		
		Scene scena = new Scene(principale);
		finestra.setTitle("TriangoloRettangolo");
		finestra.setScene(scena);
		finestra.show();
		
		pCatetoUno.setOnAction( e -> eseguiCatetoUno( ));
		pCatetoDue.setOnAction( e -> eseguiCatetoDue());
		pIpotenusa.setOnAction( e -> eseguiIpotenusa());
			
	}


	private void eseguiIpotenusa() {
		
		String catetoUno, catetoDue, ipotenusa;
		double catetoUnoI, catetoDueI, ipotenusaI;
		
		catetoUno = cCatetoUno.getText();
		catetoDue = cCatetoDue.getText();
		catetoUnoI = Float.parseFloat(catetoUno);
		catetoDueI = Float.parseFloat(catetoDue);
		ipotenusaI = Math.sqrt((catetoUnoI*catetoUnoI) + (catetoDueI*catetoDueI));
		ipotenusa = "" + ipotenusaI;
		cIpotenusa.setText(ipotenusa);
	}

	private void eseguiCatetoDue() {
		
		String catetoUno, catetoDue, ipotenusa;
		double catetoUnoI, catetoDueI, ipotenusaI;
		
		catetoUno = cCatetoUno.getText();
		ipotenusa = cIpotenusa.getText();
		catetoUnoI = Float.parseFloat(catetoUno);
		ipotenusaI = Float.parseFloat(ipotenusa);
		catetoDueI = Math.sqrt((ipotenusaI*ipotenusaI) - (catetoUnoI*catetoUnoI));
		catetoDue = "" + catetoDueI;
		cCatetoDue.setText(catetoDue);
		
	}

	private void eseguiCatetoUno() {
		
		String catetoUno, catetoDue, ipotenusa;
		double catetoUnoI, catetoDueI, ipotenusaI;
		
		catetoDue = cCatetoUno.getText();
		ipotenusa = cIpotenusa.getText();
		catetoDueI = Float.parseFloat(catetoDue);
		ipotenusaI = Float.parseFloat(ipotenusa);
		catetoUnoI = Math.sqrt((ipotenusaI*ipotenusaI) - (catetoDueI*catetoDueI));
		catetoUno = "" + catetoUnoI;
		cCatetoUno.setText(catetoUno);
		
	}
		
		 public static void main(String[] args) {
			    launch(args);
				

	}
}	
	

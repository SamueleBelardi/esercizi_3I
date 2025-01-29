package it.edu.iisgubbio.saluti; /* nome cartella */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * La mia prima classe
 */
public class CiaoMondo extends Application  { /* nome file */

  Button pSaluto = new Button(); /* assegnazione variabile */
  Button pUno = new Button();
  Button pDue = new Button();
  Label eCiao = new Label();

  public void start(Stage finestra) {
    pSaluto.setText("gatto"); /* tipo print in python (seleziona testo) */
    pUno.setText("Uno");
    pDue.setText("Due");
    eCiao.setText("Ciao");
    pSaluto.setOnAction(e -> esegui()); /* comando che esegue la scritta */

    GridPane principale = new GridPane(); 
    principale.add(pSaluto,0,0);
    principale.add(pUno,1,0);
    principale.add(pDue,0,1);
    principale.add(eCiao,3,1);

    Scene scena = new Scene(principale); /* finestra e grandezza finestra*/

    finestra.setTitle("Hello World!"); /* nome della finestra*/ 
    finestra.setScene(scena);
    finestra.show();
  }

  private void esegui(){
    pSaluto.setText("Ciao Mondo!");
  }

  public static void main(String[] args) {
    launch(args);
  }
}
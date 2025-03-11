package it.edu.iisgubbio.oggetti.vivaio;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * possibili ulteriori espansioni:
 *   - mettere pulsante per pulire la lista
 *   - far si che le descrizioni occupino due righe (basta un "\n" nel toString)
 *     così vedono che poi non cambia nulla oltre alla rappresentazione
 *   
 */
public class Cassa extends Application{
    //fiore
    Label lFiore = new Label("FIORE");
    Label fNome = new Label ("Nome:");
    TextField tfNome = new TextField ();
    Label fPrezzo = new Label("Prezzo:");
    TextField tfPrezzo = new TextField ();
    Label fcolore = new Label("Colore:");
    TextField tfColore = new TextField ();
    Label fStagione = new Label("Stagione Fioritura:");
    TextField tfStagione = new TextField ();
    Button bFiore = new Button ("Aggiungi fiore");
    
    
    //commestibile
    Label lCommestibile = new Label("COMMESTIBILE");
    Label cNome = new Label ("Nome:");
    TextField tcNome = new TextField ();
    Label cPrezzo = new Label("Prezzo:");
    TextField tcPrezzo = new TextField ();
    Label cQuantita = new Label("Quantita:");
    TextField tcQuantita = new TextField ();
    Label cStagione = new Label("Stagione Raccolto");
    TextField tcStagione = new TextField ();
    Button bCommestibile = new Button ("Aggiungi commestibile");
    
    //bonsai
    Label lBonsai = new Label("BONSAI");
    Label bNome = new Label ("Nome:");
    TextField tbNome = new TextField ();
    Label bPrezzo = new Label("Prezzo:");
    TextField tbPrezzo = new TextField ();
    Label bEta = new Label("Eta:");
    TextField tbEta = new TextField ();
    Button bBonsai= new Button ("Aggiungi bonsai");
    
    ListView<Pianta> lista = new ListView<>(); 
    Button bTotale = new Button("totale"); 
    Label lDettagli = new Label("dettagli scontrino");
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane griglia = new GridPane();
        
        griglia.add(lista,      0, 0, 1, 9);
        lista.setPrefSize(300, 100);
        griglia.add(bTotale,    0, 9);
        bTotale.setMaxWidth(Integer.MAX_VALUE);
        
        //fiore
        griglia.add(lFiore, 1, 0);
        griglia.add(fNome, 1, 1);
        griglia.add(tfNome, 1, 2);
        griglia.add(fPrezzo, 1, 3);
        griglia.add(tfPrezzo, 1, 4);
        griglia.add(fcolore, 1, 5);
        griglia.add(tfColore, 1, 6);
        griglia.add(fStagione, 1, 7);
        griglia.add(tfStagione, 1, 8);
        griglia.add(bFiore, 1, 9);
        bFiore.setMaxWidth(Integer.MAX_VALUE);
        
        //commestibile
        griglia.add(lCommestibile, 2, 0);
        griglia.add(cNome, 2, 1);
        griglia.add(tcNome, 2, 2);
        griglia.add(cPrezzo, 2, 3);
        griglia.add(tcPrezzo, 2, 4);
        griglia.add(cQuantita, 2, 5);
        griglia.add(tcQuantita, 2, 6);
        griglia.add(cStagione, 2, 7);
        griglia.add(tcStagione, 2, 8);
        griglia.add(bCommestibile, 2, 9);
        bCommestibile.setMaxWidth(Integer.MAX_VALUE);
        
        //bonsai
        griglia.add(lBonsai, 3, 0);
        griglia.add(bNome, 3, 1);
        griglia.add(tbNome, 3, 2);
        griglia.add(bPrezzo, 3, 3);
        griglia.add(tbPrezzo, 3, 4);
        griglia.add(bEta, 3, 5);
        griglia.add(tbEta, 3, 6);
        griglia.add(bBonsai, 3, 9);
        bBonsai.setMaxWidth(Integer.MAX_VALUE);
        
        griglia.add(lDettagli, 0, 10, 4, 1);
        
        griglia.setHgap(5);
        griglia.setVgap(5);
        griglia.setPadding(new Insets(5));
        
        Scene s = new Scene(griglia);
        
        primaryStage.setScene(s);
        primaryStage.setTitle("Cassa vivaio dettagliata");
        primaryStage.show();
        bFiore.setOnAction( e -> eseguiFiore());
        bCommestibile.setOnAction( e -> eseguiCommestibile());
        bBonsai.setOnAction( e -> eseguiBonsai());
        bTotale.setOnAction( e -> eseguiTotale());
    } 
    
    private void eseguiTotale() {
    	double totale = 0;
		int numeroPezzi = lista.getItems().size();
			
		// for come facciamo noi
		/*for(int i = 0; i < numeroPezzi; i++) {
			Pianta pianta = lista.getItems().get(i);
			totale += pianta.getCosto(); 
		} */
		
		for(Pianta p: lista.getItems()) {
			if(p instanceof Commestibile) {
				Commestibile c = (Commestibile) p;
				totale += c.getCosto() * c.getQuantita();
			} else {
				totale += p.getCosto();
			}
		}
		lDettagli.setText("" + totale);
	}

	private void eseguiFiore() {
		String nome = tfNome.getText();
		double prezzo = Double.parseDouble(tfPrezzo.getText());
		String colore = tfColore.getText();
		String stagioneFioritura = tfStagione.getText();
		Fiore f = new Fiore(nome, prezzo, colore, stagioneFioritura);
		lista.getItems().add(f);
	}

	private void eseguiCommestibile() {
		String nome = tcNome.getText();
		double prezzo = Double.parseDouble(tcPrezzo.getText());
		int quantita = Integer.parseInt(tcQuantita.getText());
		String stagioneProduzione = tcStagione.getText();
		Commestibile c = new Commestibile(nome, prezzo);
		c.setQuantita(quantita);
		c.setStagioneProduzione(stagioneProduzione);
		lista.getItems().add(c);
	}

	private void eseguiBonsai() {
		String nome = tbNome.getText();
		double prezzo = Double.parseDouble(tbPrezzo.getText());
		int eta= Integer.parseInt(tbEta.getText());
		Bonsai b = new Bonsai(nome, prezzo, eta);
		lista.getItems().add(b);
	}
	public static void main(String[] args) {
        launch(args);
    }
}
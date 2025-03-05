package it.edu.iisgubbio.oggetti.vivaio;

public class Fiore extends Pianta{
	private String colore;
	private int stagioneFioritura;
	
	public Fiore(String nome, double costo, String colore, String stagione) {
		super(nome, costo);
		this.colore = colore;
		setStagioneFioritura(stagione);
	}
	
	public String getColore() {
		return colore;
	}
	public void setColore(String colore) {
		this.colore = colore;
	}
	
	public String getStagioneFioritura() {
		String x;
		switch (this.stagioneFioritura) {
		case 1:
			x = "primavera";
			break;
		case 2:
			x = "estate";
			break;
		case 3:
			x = "autunno";
			break;
		case 4:
			x = "inverno";
			break;
		default:
			x = " ";
		}
		return x;
	}
	
	public void setStagioneFioritura(String stagione) {
		switch (stagione) {
		case "primavera":
			this.stagioneFioritura = 1;
			break;
		case "estate":
			this.stagioneFioritura = 2;
			break;
		case "autunno":
			this.stagioneFioritura = 3;
			break;
		case "inverno":
			this.stagioneFioritura = 4;
			break;
		default:
			this.stagioneFioritura = 0;
		}
	}
	
	public String toString() {
		String descrizione = "Commestibile [nome=" + getNome() + " costo=" + getCosto() + 
				" colore=" + colore + " stagioneProduzione=" + getStagioneFioritura() +"]";
				return descrizione;
	}
	
}

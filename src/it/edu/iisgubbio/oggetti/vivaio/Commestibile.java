package it.edu.iisgubbio.oggetti.vivaio;

public class Commestibile extends Pianta {
	private int quantita;
	private int stagioneProduzione;
	
	public Commestibile(String nome, double costo) {
		super(nome, costo);
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public int getStagioneProduzione() {
		return stagioneProduzione;
	}

	public void setStagioneProduzione(int stagioneProduzione) {
		this.stagioneProduzione = stagioneProduzione;
	}

	@Override
	public String toString() {
		String descrizione = "Commestibile [nome=" + getNome() + " costo=" + getCosto() + " quantita=" + quantita + " stagioneProduzione=" +stagioneProduzione +"]";
		return descrizione;
	}
	
	
}

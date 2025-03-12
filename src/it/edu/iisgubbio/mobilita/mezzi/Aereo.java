package it.edu.iisgubbio.mobilita.mezzi;

public class Aereo extends Volante {
	private boolean reazione;
	private int distanzaMassima;
	
	public Aereo(String nome) {
		super();
		this.nome = nome;
	}
	
	public String toString() {
		return "Aereo: " + nome + ", percorrenza massima " + distanzaMassima + "km";
	}
	
	public boolean puoRaggiungere(int distanza) {
		if(getDistanzaMassima()<distanza) {
			return false;
		} else {
			return true;
		}
	}

	public boolean isReazione() {
		return reazione;
	}

	public void setReazione(boolean reazione) {
		this.reazione = reazione;
	}

	public int getDistanzaMassima() {
		return distanzaMassima;
	}

	public void setDistanzaMassima(int distanzaMassima) {
		this.distanzaMassima = distanzaMassima;
	}
}

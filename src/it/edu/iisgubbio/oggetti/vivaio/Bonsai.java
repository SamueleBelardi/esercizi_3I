package it.edu.iisgubbio.oggetti.vivaio;

public class Bonsai extends Pianta{
	private int eta;

	public Bonsai(String nome, double costo, int eta) {
		super(nome, costo);
		this.eta = eta;
	}
	
	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	public boolean Vecchio() {
		if(eta > 20) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Bonsai [nome=" + getNome() + " costo=" + getCosto() + " eta=" + eta + "]";
	}
	
	
}

package it.edu.iisgubbio.oggetti.vivaio;

public class Bonsai extends Pianta implements Imballabile{
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

	public boolean vecchio() {
		return eta>20; 
	}

	@Override
	public String toString() {
		return "Bonsai [nome=" + getNome() + " costo=" + getCosto() + " eta=" + eta + "]";
	}

	@Override
	public double getVolumeImballaggio() {
		return 8;
	}

	@Override
	public int getPezziPerImballo() {
		return 1;
	}
	
}

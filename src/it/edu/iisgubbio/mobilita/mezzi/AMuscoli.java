package it.edu.iisgubbio.mobilita.mezzi;

public class AMuscoli extends MezzoDiTrasporto {
	private String muscoliCoinvolti;

	public AMuscoli() {
		super();
	}

	public AMuscoli(String nome, double costo, String muscoliCoinvolti) {
		super(nome, costo);
		this.muscoliCoinvolti = muscoliCoinvolti;
	}
	
	public boolean parteAlta() {
		if(getMuscoliCoinvolti().equals("bicipite") || getMuscoliCoinvolti().equals("petto")) {
			return true;
		} else {
			return false;
		}
	}
	
	public String toString() {
		 return "Veicolo a muscoli: " + nome + ", " + costo + "€ (usa " + muscoliCoinvolti + ")";
	}

	public String getMuscoliCoinvolti() {
		return muscoliCoinvolti;
	}

	public void setMuscoliCoinvolti(String muscoliCoinvolti) {
		this.muscoliCoinvolti = muscoliCoinvolti;
	}
}

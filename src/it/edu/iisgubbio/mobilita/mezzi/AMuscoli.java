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
		boolean x = false;
		switch (this.muscoliCoinvolti) {
		case "bicipiti":
			x = true;
			break;
		case "petto":
			x = true;
			break;
		case "tricipiti":
			x = true;
			break;
		case "deltoidi":
			x = true;
			break;
		default:
		}	
		return x;
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

package it.edu.iisgubbio.mobilita.mezzi;

public class Skateboard extends AMuscoli {
	private int lunghezza;
	
	public Skateboard(String nome, double costo) {
		super(nome, costo, "polpaccio");
		this.lunghezza = 60;
	}
	
	public Skateboard(String nome, double costo, int lunghezza) {
		super(nome, costo, "polpaccio");
		this.lunghezza = lunghezza;
	}
	
	public String toString() {
		 String descrizione = "";
		 if(longboard()) {
			 descrizione += "skateboard longboard";
		 } else {
			 descrizione += "skateboard";
		 }
		 descrizione += " lungo " + lunghezza + "cm costa " + costo +"€";
		 return descrizione;
	}
	
	public boolean longboard() {
		if(lunghezza > 80) {
			return true;
		} else {
			return false;
		}
	}

	public int getLunghezza() {
		return lunghezza;
	}

	public void setLunghezza(int lunghezza) {
		this.lunghezza = lunghezza;
	}

}

package it.edu.iisgubbio.oggetti.fattoria;

public class Carne extends Prodotto {
	private boolean bianca;
	private boolean kosher;
	
	public Carne(String nome, double prezzoAlKg, boolean bianca, boolean kosher) {
		super(nome, prezzoAlKg);
		this.bianca = bianca;
		this.kosher = kosher;
	}
	
	public String toString() {
		String descrizione = nome + " " + prezzoAlKg + "€/Kg";
		
		if(kosher) {
			descrizione += " kosher ";
		} else {
			descrizione += " NON kosher";
		}
		
		if(bianca) {
			descrizione += " [carne bianca]";
		} else {
			descrizione += " [carne rossa]";
		}
		return descrizione;
	}

	public boolean isBianca() {
		return bianca;
	}

	public boolean isKosher() {
		return kosher;
	}
	
	
	
}

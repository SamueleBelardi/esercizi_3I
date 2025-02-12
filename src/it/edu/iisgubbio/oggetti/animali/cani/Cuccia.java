package it.edu.iisgubbio.oggetti.animali.cani;

public class Cuccia {
	private boolean interno;
	private double prezzo;
	private int numeroPosti;
	private String colore;
	
	public String toString() {
		String testo = "";
 		testo+= "numero posti " + numeroPosti + " prezzo " + prezzo;
 		
		if(this.interno) {
			testo+= " da interno ";
		} else {
			testo+= " da esterno ";
		}
		
		if(this.colore != null) {
			testo+= colore;
		}
	
		return testo;
	}
	public boolean isInterno() {
		return interno;
	}
	public void setInterno(boolean interno) {
		this.interno = interno;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public int getNumeroPosti() {
		return numeroPosti;
	}
	public void setNumeroPosti(int numeroPosti) {
		this.numeroPosti = numeroPosti;
	}
	public String getColore() {
		return colore;
	}
	public void setColore(String colore) {
		this.colore = colore;
	}
	
	
	
}

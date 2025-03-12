package it.edu.iisgubbio.mobilita.mezzi;

public class Volante extends AMotore {
	private double quotaMassima;
	
	public Volante() {
		super();
	}
	
	public Volante(String nome, double costo) {
		super();
		this.nome = nome;
		this.costo = costo;
		setQuotaMassima(2400);
	}
	
	public String toString() {
		return "Mezzo volante: " + nome + 
		" (" + costo + "€) vola fino a " +quotaMassima + "m di quota";
	}
	
	public boolean isNecessariaPressurizzazione() {
		if(quotaMassima>300) {
			return true;
		} else {
			return false;
		}
	}

	public double getQuotaMassima() {
		return quotaMassima;
	}

	public void setQuotaMassima(double quotaMassima) {
		this.quotaMassima = quotaMassima;
	}
}

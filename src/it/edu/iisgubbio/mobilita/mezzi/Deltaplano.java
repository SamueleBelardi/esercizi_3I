package it.edu.iisgubbio.mobilita.mezzi;

public class Deltaplano extends Volante{
	private int numeroDiPosti;
	
	public Deltaplano(String nome, double costo, int numeroDiPosti) {
		super();
		this.nome = nome;
		this.costo = costo;
		this.numeroDiPosti = numeroDiPosti;
	}
	
	public String toString() {
		String descrizione = "Deltaplano: ";
		if(accettaPasseggero()) {
			descrizione += "2 posti";
		} else {
			descrizione += "monoposto";
		}
		return descrizione;
	}
	
	public boolean accettaPasseggero() {
		if(numeroDiPosti>1) {
			return true;
		} else {
			return false;
		}
	}

	public int getNumeroDiPosti() {
		return numeroDiPosti;
	}

	public void setNumeroDiPosti(int numeroDiPosti) {
		this.numeroDiPosti = numeroDiPosti;
	}
}

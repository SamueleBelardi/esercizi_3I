package it.edu.iisgubbio.mobilita.mezzi;

public class Bicicletta extends AMuscoli{
	private int numeroDiRapporti;
	private double peso;

	public Bicicletta(double costo, double peso) {
		super("bicicletta" , costo, "quadricipite");
		this.costo = costo;
		this.peso = peso;
	}
	
	public String toString() {
		String descrizione = "pesa" + peso + "Kg";
		if(leggera()) {
			descrizione += " (leggera) ";
		}
		descrizione += "costa " + costo +"€ (ha " + getNumeroDiRapporti() +"rapporti)";
		return descrizione;
	}
	
	public boolean leggera() {
		if(peso < 10)  {
			return true;
		} else {
			return false;
		}
	}

	public int getNumeroDiRapporti() {
		return numeroDiRapporti;
	}

	public void setNumeroDiRapporti(int numeroDiRapporti) {
		this.numeroDiRapporti = numeroDiRapporti;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	
}

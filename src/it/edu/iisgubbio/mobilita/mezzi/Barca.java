package it.edu.iisgubbio.mobilita.mezzi;

public class Barca extends AMuscoli{
	private int numeroDiRemi;
	private boolean singoloRemo;
	
	public Barca(String nome, double costo, int numeroDiRemi, boolean singoloRemo) {
		super(nome, costo, "bicipiti");
		this.numeroDiRemi = numeroDiRemi;
		this.singoloRemo = singoloRemo;
	}
	
	public String toString() {
		String descrizione = "Barca: " + nome + " con remi " + numeroDiRemi +" (";
		if(singoloRemo) {
			descrizione += "uno per vogatore)";
		} else {
			descrizione += "due per vogatore)";
		}
		return descrizione;
	}

	public int getNumeroDiRemi() {
		return numeroDiRemi;
	}

	public boolean getSingoloRemo(boolean singoloRemo) {
		return singoloRemo;
	}
	
	public int numeroVogatori() {
		if(getSingoloRemo(singoloRemo)) {
			return getNumeroDiRemi();
		} else {
			return getNumeroDiRemi() / 2;
		}
	}
}

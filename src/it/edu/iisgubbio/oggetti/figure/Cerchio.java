package it.edu.iisgubbio.oggetti.figure;

public class Cerchio {
	private double raggio;
	
	// costruttore per impostare un valore ad un raggio
	public Cerchio(double raggio) {
		this.raggio = raggio;
	}
	
	// costruttore se non metto nessun valore al raggio = 1
	public Cerchio() {
		raggio = 1;
	}
	
	// costruttore per cambiare il valore del raggio
	public void setRaggio(double raggio) {
		this.raggio = raggio;
	}
	
	// costruttore per leggeer il valore del raggio
	public double getRaggio() {
		return raggio;
	}

	public double diametro() {
		double d = raggio * 2;
		return d;
	}
	
	public double circonferenza() { 
		return raggio * 2 * Math.PI;
	}	
}



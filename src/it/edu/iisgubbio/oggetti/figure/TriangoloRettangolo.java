package it.edu.iisgubbio.oggetti.figure;

public class TriangoloRettangolo {
	private double base;
	private double altezza;
	
	// costruttotri per impostare valori
	public TriangoloRettangolo(double base, double altezza) {
		super();
		this.base = base;
		this.altezza = altezza;
	}
	
	public TriangoloRettangolo() {
		base = 1;
		altezza = 1;
	}
	//
	 
	// costruttori riguardanti get e set
	public double getBase() {
		return base;
	}
	public void setBase(double base) {
		this.base = base;
	}
	public double getAltezza() {
		return altezza;
	}
	public void setAltezza(double altezza) {
		this.altezza = altezza;
	}
	//
	
	// metodi per calcoli
	public double ipotenusa() {
		return Math.sqrt(base * base + altezza * altezza);
	}
	
	public double perimetro() {
		return base + altezza + ipotenusa();
	}
	
	public double area() {
		return base * altezza / 2;
	}
	//
	
	public String toString() {
		return "TriangoloRettangolo " + base + "x" + altezza;
	}
	
	
	
}

package it.edu.iisgubbio.mobilita.mezzi;

public class Motoslitta extends Terrestre{
	private double temperaturaMinima;
	
	public Motoslitta(String nome, double costo, double velocita) {
		super();
		this.nome = nome;
		this.costo = costo;
		this.setVelocita(velocita);
		
	}
	
	public String toString() {
		return "Motoslitta: " + nome + ", funziona fino a -" + temperaturaMinima + "°C";
	}
	
	public boolean puoFunzionare(int tempo) {
		if(tempo<getTemperaturaMinima()) {
			return false;
		} else {
			return true;
		}
	}
	public double getTemperaturaMinima() {
		return temperaturaMinima;
	}

	public void setTemperaturaMinima(double temperaturaMinima) {
		this.temperaturaMinima = temperaturaMinima;
	}
	
	
	
}

package it.edu.iisgubbio.oggetti.vivaio;

public class Fiore extends Pianta{
	private String colore;
	private int stagioneFioritura;
	
	public Fiore(String nome, double costo, String colore, String stagioneFioritura) {
		super(nome, costo);
		this.colore = colore;
		if(stagioneFioritura.equals("primavera")) {
			this.stagioneFioritura = 1;
		} else {
			this.stagioneFioritura = 0;
		}
		if(stagioneFioritura.equals("estate")) {
			this.stagioneFioritura = 2;
		} else {
			this.stagioneFioritura = 0;
		}
		if(stagioneFioritura.equals("autunno")) {
			this.stagioneFioritura = 3;
		} else {
			this.stagioneFioritura = 0;
		}
		if(stagioneFioritura.equals("inverno")) {
			this.stagioneFioritura = 4;
		} else {
			this.stagioneFioritura = 0;
		}
	}
	
	public String getColore() {
		return colore;
	}
	public void setColore(String colore) {
		this.colore = colore;
	}
	public int getStagioneFioritura() {
		return stagioneFioritura;
	}
	
	public void setStagioneFioritura(String stagioneFioritura) {
		if(stagioneFioritura.equals("primavera")) {
			this.stagioneFioritura = 1;
		} else {
			this.stagioneFioritura = 0;
		}
		if(stagioneFioritura.equals("estate")) {
			this.stagioneFioritura = 2;
		} else {
			this.stagioneFioritura = 0;
		}
		if(stagioneFioritura.equals("autunno")) {
			this.stagioneFioritura = 3;
		} else {
			this.stagioneFioritura = 0;
		}
		if(stagioneFioritura.equals("inverno")) {
			this.stagioneFioritura = 4;
		} else {
			this.stagioneFioritura = 0;
		}
	}
	
	
}

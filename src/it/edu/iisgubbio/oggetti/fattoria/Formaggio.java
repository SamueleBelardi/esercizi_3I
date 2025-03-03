package it.edu.iisgubbio.oggetti.fattoria;

public class Formaggio extends Prodotto {
	protected int tempoStagionaturaInMesi;
	protected boolean dOP;
	
	// ha due costruttori uno che imposta tutte le prioprieta e uno che imposta
	// nome prezzoAlKg e stagionatura perchè serve a creare formaggi non DOP
	
	public Formaggio(String nome, double prezzoAlKg, int tempoStagionaturaInMesi, boolean dOP) {
		super(nome, prezzoAlKg);
		this.tempoStagionaturaInMesi = tempoStagionaturaInMesi;
		this.dOP = dOP;
	}

	public Formaggio(String nome, double prezzoAlKg, int tempoStagionaturaInMesi) {
		super(nome, prezzoAlKg);
		this.tempoStagionaturaInMesi = tempoStagionaturaInMesi;
		this.dOP = false;
	}
	
	public String toString() {
		String descrizione = "Formaggio: nome=" + nome + ", prezzoAlKg=" + prezzoAlKg;
		if(dOP) {
			descrizione += ", DOP";
		} else {
			descrizione += ", NON DOP";
		}
		
		if(this.tempoStagionaturaInMesi == 0) {
			return descrizione;
		} else {
			return descrizione += ", stagionatura=" + tempoStagionaturaInMesi; 
		}
	}

	public void setTempoStagionaturaInMesi(int tempoStagionaturaInMesi) {
		this.tempoStagionaturaInMesi = tempoStagionaturaInMesi;
	}

	public void setdOP(boolean dOP) {
		this.dOP = dOP;
	}
	
	
}
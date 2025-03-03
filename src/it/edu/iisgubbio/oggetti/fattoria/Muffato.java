package it.edu.iisgubbio.oggetti.fattoria;

public class Muffato extends Formaggio {
	protected String muffa;
	protected boolean interno;
	
	public Muffato(String nome, double prezzoAlKg, String muffa) {
		super(nome, prezzoAlKg, 0, false );
		this.muffa = muffa;
		this.interno = true;
	}


	public void setInterno(boolean interno) {
		this.interno = interno;
	}
	
	public String toString() {
		String descrizione = "Muffato: nome=" + nome + ", prezzoAlKg=" + prezzoAlKg;
		if(dOP) {
			descrizione += ", DOP";
		} else {
			descrizione += ", NON DOP";
		}
		
		if(this.tempoStagionaturaInMesi != 0) {
			descrizione += ", stagionatura=" + tempoStagionaturaInMesi; 
		}
		descrizione += ", nomeMuffa:" + muffa; 
		
		if(interno) {
			descrizione += ", muffa interna";
		} else  {
			descrizione += ", muffa NON interna";
		}
		
		return descrizione;
	}
	
}
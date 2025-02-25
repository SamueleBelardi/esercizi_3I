package it.edu.iisgubbio.oggetti.fattoria;

public class Muffato extends Formaggio {
	protected String muffa;
	protected boolean interno;
	
	public Muffato(String nome, double prezzoAlKg, int tempoStagionaturaInMesi, boolean dOP, String muffa) {
		super(nome, prezzoAlKg, tempoStagionaturaInMesi, dOP);
		this.dOP = false;
		this.tempoStagionaturaInMesi = 0;
		this.muffa = muffa;
		this.interno = true;
	}
	
	
}

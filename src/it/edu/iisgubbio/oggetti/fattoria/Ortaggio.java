package it.edu.iisgubbio.oggetti.fattoria;

public class Ortaggio extends Prodotto{
	protected boolean biologico;
	
	public Ortaggio(String nome, double prezzoAlKg,boolean biologico ) {
		super(nome,prezzoAlKg);
		this.biologico = biologico;
	}

	public boolean isBiologico() {
		return biologico;
	}
	
	public void setBiologico(boolean biologico ) {
		this.biologico = biologico;
	}
	
	@Override
	public String toString() {
		if(biologico == true) {
			return "Ortaggio [Ortaggio:" + nome + " costo al chilo " + prezzoAlKg + " l'ortaggio è biologico " + "]";
		} else {
			return "Ortaggio [Ortaggio:" + nome + " costo al chilo " + prezzoAlKg + " l'ortaggio NON è biologico " + "]";
		}
	}
	
	
}

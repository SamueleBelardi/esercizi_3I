package it.edu.iisgubbio.oggetti.fattoria;

public class Prodotto {
	
	protected String nome;
	protected double prezzoAlKg;
	
	public Prodotto(String nome,double prezzoAlKg) {
		super();
		this.nome = nome;
		this.prezzoAlKg = prezzoAlKg;
	}
	
	public Prodotto() {
		super();
	}
	
	@Override
	public String toString() {
		return "Prodotto [nome=" + nome + ", prezzoAlKg=" + prezzoAlKg + "]";
	}
	public double calcolaPrezzo(double peso){
		return peso*prezzoAlKg;
	}
	
	
}

package it.edu.iisgubbio.mobilita.mezzi;

public class MezzoDiTrasporto {
	protected double costo;
	protected String nome;
	
	public MezzoDiTrasporto() {
		super();
	}
	
	public MezzoDiTrasporto(String nome, double costo) {
		super();
		this.costo = costo;
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "MezzoDiTrasporto [costo=" + costo + ", nome=" + nome + "]";
	}

	public double importoRata(int numeroRate) {
		return this.costo / numeroRate;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}

package it.edu.iisgubbio.oggetti.animali.cani;

public class Cane {
	 private String nome;
	 private String razza;
	 private int anno;
	 private int grammiCibo;
	 private String nomePropietario;
	 
	 public Cane(String nome, String razza, int anno, int grammiCibo, String nomePropietario) {
		super();
		this.nome = nome;
		this.razza = razza;
		this.anno = anno;
		this.grammiCibo = grammiCibo;
		this.nomePropietario = nomePropietario;
	}

	public Cane() {
		 nome = "";
		 razza = "";
		 anno = 0; 
		 grammiCibo = 0; 
		 nomePropietario = "";
	 }
	
	public String toString() {
		return "Cane: " + nome + " di razza " + razza;
	}
	
	// metodo verifica propiaterio
	// dato un nome dice se e proprietario o no
	public boolean verificaPropietario() {
		boolean controllo = false;
		String nome = "samuele";
		
		if(nomePropietario == nome) {
			controllo = true;
		}
		return controllo;
	}
	
}

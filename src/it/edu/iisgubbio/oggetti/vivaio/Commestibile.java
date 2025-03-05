package it.edu.iisgubbio.oggetti.vivaio;

public class Commestibile extends Pianta implements Imballabile{
	private int quantita;
	private int stagioneProduzione;
	
	public Commestibile(String nome, double costo) {
		super(nome, costo);
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public String getStagioneProduzione() {
		String x;
		switch (this.stagioneProduzione) {
		case 1:
			x = "primavera";
			break;
		case 2:
			x = "estate";
			break;
		case 3:
			x = "autunno";
			break;
		case 4:
			x = "inverno";
			break;
		default:
			x = " ";
		}
		return x;
	}

	public void setStagioneProduzione(String stagione) {
		switch (stagione) {
		case "primavera":
			this.stagioneProduzione= 1;
			break;
		case "estate":
			this.stagioneProduzione = 2;
			break;
		case "autunno":
			this.stagioneProduzione = 3;
			break;
		case "inverno":
			this.stagioneProduzione = 4;
			break;
		default:
			this.stagioneProduzione = 0;
		}
	}

	@Override
	public String toString() {
		String descrizione = "Commestibile [nome=" + getNome() + " costo=" + getCosto() + 
		" quantita=" + quantita + " stagioneProduzione=" + getStagioneProduzione() +"]";
		return descrizione;
	}

	@Override
	public double getVolumeImballaggio() {
		return 16;	}

	@Override
	public int getPezziPerImballo() {
		return 20;
	}
	
	
}

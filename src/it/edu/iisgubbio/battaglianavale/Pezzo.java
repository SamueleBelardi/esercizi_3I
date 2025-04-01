package it.edu.iisgubbio.battaglianavale;
/**
 * Rappresenta un pezzo della nave
 */
public class Pezzo {
	protected int x;
	protected int y;
	private boolean colpito;
	
	/**
	 * costruttore dell'oggetto pezzo
	 * @param x coordinate x
	 * @param y coordinate y
	 * @return restituisce il pezzo con i valori assegnati
	 */
	public Pezzo(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		this.colpito = false;
	}
	
	/**
	 * Il metodo serve per sparare contro il pezzo
	 * @param x coordinate riga del colpo
	 * @param y coordinate colonna del colpo
	 * @return true se il pezzo è stato colpito
	 */
	public boolean colpo(int x, int y) {
		if(this.x == x && this.y == y) {
			this.colpito = true;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Verifica se il pezzo è stato colpito
	 * @return true se è stato colpito
	 */
	public boolean isColpito() {
		return colpito;
	}
	
	@Override
	public String toString() {
		String descrizione = "Il pezzo ha cordinate x: " + x + " y: " + y;
		if(colpito) {
			descrizione += " È stato colpito";
		} else {
			descrizione += " NON è stato colpito";
		}
		return descrizione;
	}
}

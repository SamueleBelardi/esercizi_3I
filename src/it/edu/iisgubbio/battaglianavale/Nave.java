package it.edu.iisgubbio.battaglianavale;

public class Nave {
	private Pezzo [] pezzi;
	private String nome;
	
	/**
	 * costruisce una nuova nava
	 * @param x coordinata "x" inizio nave
	 * @param y coordinata "y" inizio nave
	 * @param lunghezza lunghezza della nave
	 * @param direzione true è orizzontale, false verticale
	 */
	public Nave(String nome, int x, int y, int lunghezza, boolean direzione) {
		super();
		this.nome = nome;
		pezzi = new Pezzo[lunghezza];
		for(int i = 0; i < lunghezza; i++) {
			if(direzione) {
				pezzi[i] =  new Pezzo(x+i, y);
			} else {
				pezzi[i] =  new Pezzo(x, y+i);
			}	
		}
	}
	
	/**
	 * metodo per colpire un pezzo della nave
	 * @param x coordinata x
	 * @param y coordinata y
	 * @return true se colpito
	 */
	public boolean colpo(int x, int y) {
		boolean colpito = false;
		for(int i = 0; i < pezzi.length; i++ ) {
			if(pezzi[i].colpo(x, y)) {
				colpito = true;
			}
		}
		return colpito;
	}
	
	/**
	 * metodo che controlla se la nave è stata affondata
	 * @return true se la nave è affondata
	 */
	public boolean affondato() {
		int pezziColpiti = 0;
		for(int i = 0; i < pezzi.length; i++) {
			if(pezzi[i].isColpito() == true) {
				pezziColpiti++;
			}
		}
		// altrimenti ritorna false
		return pezziColpiti == pezzi.length;
	}
	
	/**
	 * metodo che controlla se due navi sono sovrapposte
	 * @param n l'altra Nave da controllare se sovrappone 
	 * @return true se le due navi si sovrappongono
	 */
	public boolean sovrappone(Nave n) {
		for(int i = 0; i < pezzi.length; i++) {
			// TODO bisognerebbe lasciare uno spazio ttra una nave e l'altra
			for(int iAltra = 0; iAltra < n.pezzi.length; iAltra++) {
				if(pezzi[i].x == n.pezzi[iAltra].x && 
						pezzi[i].y == n.pezzi[iAltra].y) {
					return true;
				}
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		String descrizione = "Nome: " + nome;
		for(int i = 0; i < pezzi.length; i++) {
			descrizione += "\n" + (i+1) + ": " + pezzi[i].toString() ;
		}
		return descrizione;
	}

	/**
	 * 
	 * @return vettore dei pezzi che compongono la nave
	 */
	public Pezzo[] getPezzi() {
		return pezzi;
	}

	/**
	 * metodo che modifica il vettore di pezzi della nave
	 * @param pezzi pezzo della nave
	 */
	public void setPezzi(Pezzo[] pezzi) {
		this.pezzi = pezzi;
	}

	/**
	 * metodo che modifica il nome della nave
	 * @param nome nome della nave
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
}

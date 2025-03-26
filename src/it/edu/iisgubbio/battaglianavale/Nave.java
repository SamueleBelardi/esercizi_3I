package it.edu.iisgubbio.battaglianavale;

public class Nave {
	private Pezzo [] pezzi;
	private String nome;
	
	/**
	 * costruisce una nuova nava
	 * @param x coordinata "x" inizio nave
	 * @param y coordinata "y" inizio nave
	 * @param lunghezza lunghezza della nave
	 * @param direzione direzione della nave se true, è orizzontale
	 *        altrimenti è verticale
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
	
	public boolean colpo(int x, int y) {
		boolean colpito = false;
		for(int i = 0; i < pezzi.length; i++ ) {
			if(pezzi[i].colpo(x, y)) {
				colpito = true;
			}
		}
		return colpito;
	}
	
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
	
	public boolean sovrappone(Nave n) {
		for(int i = 0; i < pezzi.length; i++) {
			for(int iAltra = 0; iAltra < n.pezzi.length; iAltra++) {
				if(pezzi[i].x == n.pezzi[iAltra].x && 
						pezzi[i].y == n.pezzi[iAltra].y) {
					return true;
				}
			}
		}
		return false;
	}
	
	public String toString() {
		String descrizione = "Nome: " + nome;
		for(int i = 0; i < pezzi.length; i++) {
			descrizione += "\n" + (i+1) + ": " + pezzi[i].toString() ;
		}
		return descrizione;
	}

	public Pezzo[] getPezzi() {
		return pezzi;
	}

	public void setPezzi(Pezzo[] pezzi) {
		this.pezzi = pezzi;
	}
	
	
}

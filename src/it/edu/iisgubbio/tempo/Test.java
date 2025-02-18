package it.edu.iisgubbio.tempo;
/*
 * nel metodo mai nella classe test creara una istanza 
 * di orario che rappesenta l'orario di fine lezioni
 */
public class Test {

	public static void main(String[] args) {
		Orario fineLezioni = new Orario(13, 35,0x0);
		System.out.println(fineLezioni);
		
		fineLezioni.aggiungiMinuti(8);
		fineLezioni.aggiungiSecondi(30);
		System.out.println(fineLezioni);
		
		Orario orarioAggiunto = new Orario(1, 2, 20);
		fineLezioni.aggiungiOrario(orarioAggiunto);
		System.out.println(fineLezioni);
		
	}	
}

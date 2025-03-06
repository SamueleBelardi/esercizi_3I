package it.edu.iisgubbio.oggetti.vivaio;

public class Prova {

	public static void main(String[] args) {
		Commestibile fragola = new Commestibile("fragola", 10);
		fragola.setQuantita(24);
		fragola.setStagioneProduzione("primavera");
		System.out.println(fragola);
		
		System.out.println("------------------------------");
		Bonsai economico = new Bonsai("acero", 30, 7);
		System.out.println(economico);
		if(economico.vecchio()) {
			System.out.println("bell'acquisto");
		}
		
		int numeriImballi = 0;
		numeriImballi += fragola.getQuantita() / fragola.getPezziPerImballo();
		if(fragola.getQuantita()%fragola.getPezziPerImballo() > 0) {
			numeriImballi++;
		}
		System.out.println(numeriImballi);
	}
}

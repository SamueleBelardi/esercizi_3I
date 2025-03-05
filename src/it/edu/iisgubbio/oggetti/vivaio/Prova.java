package it.edu.iisgubbio.oggetti.vivaio;

public class Prova {

	public static void main(String[] args) {
		Commestibile fragola = new Commestibile("fragola", 10);
		fragola.setQuantita(1);
		fragola.setStagioneProduzione("primavera");
		System.out.println(fragola);
		
		System.out.println("------------------------------");
		Bonsai economico = new Bonsai("acero", 30, 7);
		System.out.println(economico);
		if(economico.vecchio()) {
			System.out.println("bell'acquisto");
		}
		
		Imballabile x = economico;
	}

}

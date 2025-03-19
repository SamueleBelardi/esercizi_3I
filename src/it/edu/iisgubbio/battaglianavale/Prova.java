package it.edu.iisgubbio.battaglianavale;

public class Prova {
	
	public static void main(String[] args) {
		Pezzo pezzo = new Pezzo(3, 4);
		System.out.println(pezzo);
		boolean x = pezzo.colpo(3, 4);
		System.out.println("risultato colpo " + x);
		System.out.println(pezzo);
		System.out.println("colpito ?" + pezzo.isColpito());
		
		System.out.println("----------NAVE----------");
		Nave nave = new Nave("nave", 1, 1, 3, true);
		Nave naveDue = new Nave("nave", 3, 1 , 3, true);
		System.out.println(nave);
		System.out.println(nave.affondato());
		nave.colpo(1, 1);
		nave.colpo(2, 1);
		nave.colpo(3, 1);
		System.out.println(nave);
		System.out.println(nave.affondato());
		System.out.println(naveDue.sovrappone(nave));
	}
}

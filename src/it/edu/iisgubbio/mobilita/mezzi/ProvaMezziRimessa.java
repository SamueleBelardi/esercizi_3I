package it.edu.iisgubbio.mobilita.mezzi;

public class ProvaMezziRimessa {

	public static void main(String[] args) {
		MezzoDiTrasporto m = new MezzoDiTrasporto("Space shuttle", 100000);
		System.out.println(m);
		
		System.out.println(" ");
		System.out.println("AMuscoli");
		AMuscoli aMuscoli = new AMuscoli("triciclo", 150, "quadricipite");
		System.out.println(aMuscoli);
		System.out.println(aMuscoli.parteAlta());
		
		System.out.println("------------------");
		Skateboard skateboard = new Skateboard("skateboard", 340, 90);
		System.out.println(skateboard);
		System.out.println(skateboard.longboard());
		
		System.out.println("------------------");
		Bicicletta bicicletta = new Bicicletta(340, 8);
		bicicletta.setNumeroDiRapporti(13);
		System.out.println(bicicletta);
		System.out.println(bicicletta.leggera());
		
		System.out.println(" ");
		System.out.println("AMotore");
		AMotore aMotore = new AMotore("elicottero", 50000, 210, "gasolio");
		System.out.println(aMotore);
		System.out.println(aMotore.possibileCentriAbitati());
		
		System.out.println("------------------");
		Terrestre terrestre = new Terrestre();
		terrestre.setNome("Motocarro di Luigi");
		terrestre.setCarburante("benzina");
		terrestre.setVelocita(130);
		terrestre.tempoDiPercorrenza(130);
		System.out.println(terrestre);
		
		System.out.println("------------------");
		Automobile automobile = new Automobile("Maserati di Mario", 20000, 5);
		automobile.setTarga("BF5567UU");
		System.out.println(automobile);
		
		System.out.println("------------------");
		Motocicletta motocicletta = new Motocicletta("MotoGuzzi", 2000, 345);
		motocicletta.setNumeroPosti(2);
		System.out.println(motocicletta);
		System.out.println(motocicletta.puoTrasportare(2));
	}

}

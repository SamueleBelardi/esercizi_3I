package it.edu.iisgubbio.mobilita.mezzi;

public class ProvaMezziRimessa {

	public static void main(String[] args) {
		System.out.println("------MezzoDiTrasporto--------");
		MezzoDiTrasporto m = new MezzoDiTrasporto("Space shuttle", 100000);
		System.out.println(m);
		
		System.out.println(" ");
		System.out.println("---------AMuscoli----------");
		AMuscoli aMuscoli = new AMuscoli("triciclo", 150, "quadricipiti");
		System.out.println(aMuscoli);
		System.out.println(aMuscoli.parteAlta());
		
		System.out.println("------Skateboard----------");
		Skateboard skateboard = new Skateboard("skateboard", 340, 90);
		System.out.println(skateboard);
		System.out.println(skateboard.longboard());
		
		System.out.println("--------Bicicletta-------");
		Bicicletta bicicletta = new Bicicletta(340, 8);
		bicicletta.setNumeroDiRapporti(13);
		System.out.println(bicicletta);
		System.out.println(bicicletta.leggera());
		
		System.out.println("--------Barca-------");
		Barca barca = new Barca("canoa", 50, 8, false);
		System.out.println(barca);
		
		System.out.println(" ");
		System.out.println("-----------AMotore-----------");
		AMotore aMotore = new AMotore("elicottero", 50000, 210, "gasolio");
		System.out.println(aMotore);
		System.out.println(aMotore.possibileCentriAbitati());
		
		System.out.println("------Terrestre---------");
		Terrestre terrestre = new Terrestre();
		terrestre.setNome("Motocarro di Luigi");
		terrestre.setCarburante("benzina");
		terrestre.setVelocita(130);
		terrestre.tempoDiPercorrenza(130);
		System.out.println(terrestre);
		
		System.out.println("--------Automobile---------");
		Automobile automobile = new Automobile("Maserati di Mario", 20000, 5);
		automobile.setTarga("BF5567UU");
		System.out.println(automobile);
		
		System.out.println("--------Motocicletta---------");
		Motocicletta motocicletta = new Motocicletta("MotoGuzzi", 2000, 345);
		motocicletta.setNumeroPosti(2);
		System.out.println(motocicletta);
		System.out.println(motocicletta.puoTrasportare(2));
		
		System.out.println("--------Motocislitta---------");
		Motoslitta motoslitta = new Motoslitta("motoslitta di Mark", 20, 90);
		motoslitta.setTemperaturaMinima(30);
		System.out.println(motoslitta);
		
		System.out.println("--------Volante---------");
		Volante volante = new Volante("elicottero", 50000);
		volante.setQuotaMassima(1900);
		System.out.println(volante);
		
		System.out.println("--------Deltaplano---------");
		Deltaplano deltaplano = new Deltaplano("deltaplano", 20, 1);
		System.out.println(deltaplano);
		
		System.out.println("--------Aereo---------");
		Aereo aereo = new Aereo("A340");
		aereo.setDistanzaMassima(4500);
		System.out.println(aereo);
	}

}

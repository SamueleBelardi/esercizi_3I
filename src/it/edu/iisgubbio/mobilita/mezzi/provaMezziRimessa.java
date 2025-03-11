package it.edu.iisgubbio.mobilita.mezzi;

public class provaMezziRimessa {

	public static void main(String[] args) {
		MezzoDiTrasporto m = new MezzoDiTrasporto("macchina", 200);
		System.out.println(m);
		System.out.println(m.importoRata(2));
		
		System.out.println("Mezzi AMuscoli");
		AMuscoli a = new AMuscoli("bici", 20, "quadricipite");
		AMuscoli a2 = new AMuscoli();
		System.out.println(a);
		System.out.println(a.parteAlta());
		System.out.println(a2);
		
		System.out.println("-------------------------");
		Skateboard sUno = new Skateboard("skateboard", 20, 90);
		Skateboard sDue= new Skateboard("skateboard", 20);
		System.out.println(sUno);
		System.out.println(sDue);
		System.out.println(sUno.longboard());
		System.out.println(sDue.longboard());
		
		System.out.println("-------------------------");
		Bicicletta b = new Bicicletta(20, 9);
		System.out.println(b);
		System.out.println(b.leggera());
		
		System.out.println("Mezzi AMotore");
		AMotore aM = new AMotore("auto", 1000, 67, "diesel");
		System.out.println(aM);
		System.out.println(aM.possibileCentriAbitati());
		
		System.out.println("-------------------------");
		Terrestre t = new Terrestre();
		t.setNome("macchina");
		t.setCosto(1000);
		t.setRumorosita(60);
		t.setCarburante("gasolio");
		t.setVelocita(130);
		System.out.println(t);
		System.out.println(t.tempoDiPercorrenza(60));
	}

}

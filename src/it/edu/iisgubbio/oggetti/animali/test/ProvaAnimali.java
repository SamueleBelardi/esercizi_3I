package it.edu.iisgubbio.oggetti.animali.test;

import it.edu.iisgubbio.oggetti.animali.cani.Cane;
import it.edu.iisgubbio.oggetti.animali.cani.Cuccia;

public class ProvaAnimali {

	public static void main(String[] args) {
		Cane forrest = new Cane("Forrest", "husky", 2017, 412, "pierucci");
		Cane pluto = new Cane("Pluto", "bassotto", 2019, 120, "Morini");
		Cuccia casaPierucci  = new Cuccia();
		
		System.out.println(pluto);
		casaPierucci.setInterno(false);
		casaPierucci.setNumeroPosti(1);
		casaPierucci.setPrezzo(87);
		
		System.out.println(forrest);
		System.out.println(casaPierucci);
		System.out.println(forrest.eta(2025));
		
		if(forrest.verificaPropietario("pierucci")) {
			System.out.println("propietario");
		} else {
			System.out.println("NON propietario");
		}
	}

}

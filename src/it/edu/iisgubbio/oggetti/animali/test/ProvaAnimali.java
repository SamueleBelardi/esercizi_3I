package it.edu.iisgubbio.oggetti.animali.test;

import it.edu.iisgubbio.oggetti.animali.cani.Cane;
import it.edu.iisgubbio.oggetti.animali.cani.Cuccia;

public class ProvaAnimali {

	public static void main(String[] args) {
		Cane forrest = new Cane("Forrest", "husky", 7, 412, "Pierucci");
		Cane pluto = new Cane("Pluto", "bassotto", 4, 120, "Morini");
		Cuccia casaPierucci  = new Cuccia();
		
		casaPierucci.setInterno(false);
		casaPierucci.setNumeroPosti(1);
		casaPierucci.setPrezzo(87);
		
		System.out.println(forrest);
		System.out.println(casaPierucci);
	}

}

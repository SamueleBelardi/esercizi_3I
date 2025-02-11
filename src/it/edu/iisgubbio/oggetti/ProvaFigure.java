package it.edu.iisgubbio.oggetti;

import it.edu.iisgubbio.oggetti.figure.Cerchio;
import it.edu.iisgubbio.oggetti.figure.TriangoloRettangolo;

public class ProvaFigure {

	public static void main(String[] args) {
		System.out.println("Prove con Cerchio");
		Cerchio c;
		c = new Cerchio(7);
		
		System.out.println(c.circonferenza());
		Cerchio p = new Cerchio(22);
		
		c.setRaggio(10);
		System.out.println(p.getRaggio());
		
		System.out.println("//////////////////////////////////");
		System.out.println("Prove con Triangolo");
		
		TriangoloRettangolo t;
		t = new TriangoloRettangolo(3, 4);
		
		System.out.println(t.ipotenusa());
		System.out.println(t.perimetro());
		System.out.println(t.area());
		
		t.setAltezza(6);
		
		System.out.println(t.ipotenusa());
		System.out.println(t.perimetro());
		System.out.println(t.area());
		
		System.out.println(t.toString());
	}

}

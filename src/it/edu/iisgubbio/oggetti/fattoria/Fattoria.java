package it.edu.iisgubbio.oggetti.fattoria;
	
public class Fattoria {
		public static void main(String[]args) {
			Prodotto carote = new Prodotto("carote",2.50);
			
			System.out.println(carote);
			double p=carote.calcolaPrezzo(4);
			System.out.println(p);
			
			System.out.println("------------------------------");
			Ortaggio pomodoro = new Ortaggio("pomodoro", 2, true);
			
			System.out.println(pomodoro);
			double c = pomodoro.calcolaPrezzo(0.5);
			System.out.println(c);
			System.out.println(pomodoro.calcolaPrezzo(0.5));
	}
}
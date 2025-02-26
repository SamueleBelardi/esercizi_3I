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

		System.out.println("------------------------------");
		Formaggio taleggio = new Formaggio("taleggio", 25.0, 1, true);
		Formaggio ricotta = new Formaggio("ricotta", 4.0, 0);

		System.out.println(taleggio);
		System.out.println(ricotta);

		System.out.println("------------------------------");
		Carne costarella = new Carne("costarella", 9.5, false, false);
		Carne pollo = new Carne("pollo", 12.0, true, false);

		System.out.println(costarella);
		System.out.println(pollo);
		System.out.println(pollo.isBianca());

	}
}
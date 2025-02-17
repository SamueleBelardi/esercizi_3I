package it.edu.iisgubbio.tempo;
/*l'oggetto va costruito specificando ora minuto secondo tutte le proprieta
 *devono essere private, implementare il metodo toString che deve rappresentare
 *l'oggetto come testo ad esempio "10:13:02"
 */
public class Orario {
	private int ora;
	private int minuto;
	private int secondo;
	
	public Orario(int ora, int minuto, int secondo) {
		super();
		this.ora = ora;
		this.minuto = minuto;
		this.secondo = secondo;
	}
	
	public String toString() {
		return ora + ":" + minuto + ":" + secondo + ":";
	}
	
	
}

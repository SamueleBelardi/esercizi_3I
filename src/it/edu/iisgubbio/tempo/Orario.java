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
	
	public void aggiungiOre(int ore) {
		this.ora = this.ora + ore;
	}
	
	
	public void aggiungiMinuti(int minuti) {
		int oreDaAggiungere;
		this.minuto = this.minuto + minuti;
		if(this.minuto>=60) {
			oreDaAggiungere = this.minuto/60;
			aggiungiOre(oreDaAggiungere);
			this.minuto = this.minuto-oreDaAggiungere*60;
		}
	}
	
	public void aggiungiSecondi(int secondi) {
		int minutiDaAggiungere;
		this.secondo = this.secondo + secondi;
		if(this.secondo >= 60) {
			minutiDaAggiungere = this.secondo/60;
			aggiungiMinuti(minutiDaAggiungere);
			this.secondo = this.secondo-minutiDaAggiungere*60;
		}
	}
	
	public void aggiungiOrario(Orario x) {
		aggiungiOre(x.ora);
		aggiungiMinuti(x.minuto);
		aggiungiSecondi(x.secondo);
	}
	
	@Override
	public String toString() {
		return ora + ":" + minuto + ":" + secondo;
	}
}

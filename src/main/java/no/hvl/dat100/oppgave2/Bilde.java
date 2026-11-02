package no.hvl.dat100.oppgave2;

import no.hvl.dat100.common.TODO;

public class Bilde extends Tekst {

	private String url;
	
	public Bilde(int id, String bruker, String dato, String tekst, String url) {
		super(id, bruker, dato, tekst);
		this.url = url;
	}

	public Bilde(int id, String bruker, String dato, int likes, String tekst, String url) {
		super(id, bruker, dato, likes, tekst);
		this.url = url;
	}
	
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return String.format("BILDE\n%s\n%s\n%s\n%s\n%s\n%s\n", this.id, this.bruker, this.dato, this.likes, this.tekst, this.url);

	}

	// Metoden nedenfor er kun for valgfri oppgave 6
	public String toHTML() {

		return String.format(
				"<h2>%s@%s [%s]</h2> \n" +
				"<p>%s</p> \n" +
				"<iframe src=\"%s\" height=600 width=800></iframe><hr> \n",  this.bruker, this.dato, this.likes, this.tekst, this.url);
				
	}
}

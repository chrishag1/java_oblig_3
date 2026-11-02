package no.hvl.dat100.oppgave2;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;

public class Tekst extends Innlegg {

	protected String tekst;

	public Tekst () {
		super();
	}

	public Tekst(int id, String bruker, String dato, String tekst) {
		super(id, bruker, dato);
		this.tekst =  tekst;
	}
	
	public Tekst(int id, String bruker, String dato, int likes, String tekst) {
		super(id, bruker, dato, likes);
		this.tekst =  tekst;
	}
	
	public String getTekst() {
		return this.tekst;
	}

	public void setTekst(String tekst) {
		this.tekst = tekst;
	}

	@Override
	public String toString() {
		return String.format("TEKST\n%s\n%s\n%s\n%s\n%s\n", this.id, this.bruker, this.dato, this.likes, this.tekst);
	}
	
	// Metoden nedenfor er kun for valgfri oppgave 6
	public String toHTML() {
			
		return String.format(
				"<h2>%s@%s [%s]</h2> \n" +
				"<p>%s</p> \n" +
				"<hr> \n", this.bruker, this.dato, this.likes, this.tekst);
	}
}

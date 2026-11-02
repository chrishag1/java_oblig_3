package no.hvl.dat100.oppgave6;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.Innlegg;
import no.hvl.dat100.oppgave3.Blogg;

public class HtmlBlogg extends Blogg {

	public HtmlBlogg() {
		super();
	}
	
	private static String HTMLPREFIX = 
			"<html>\n\t<head>\n\t\t<title>DAT100 Blogg</title>\n\t</head>\n\t<body>\n";

	private static String HTMLPOSTFIX = 
			"\t</body>\n</html>";
	
	@Override
	public String toString() {

		StringBuilder tekst = new StringBuilder();
		tekst.append(HTMLPREFIX);

		Innlegg[] innlegg = this.getSamling();
		int antall = this.getAntall();

		for (int i = 0; i < antall; i++){
			tekst.append(innlegg[i].toHTML());
		}

		tekst.append(HTMLPOSTFIX);

		return tekst.toString();
	}
}

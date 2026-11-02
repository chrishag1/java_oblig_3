package no.hvl.dat100.oppgave3;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;

public class Blogg {

	private Innlegg[] innleggtabell;
	private int nesteledig = 0;

	public Blogg() {
		this.innleggtabell = new Innlegg[20];
	}

	public Blogg(int lengde) {
		this.innleggtabell = new Innlegg[lengde];
	}

	public int getAntall() {
		return nesteledig;
	}
	
	public Innlegg[] getSamling() {
		return this.innleggtabell;
	}
	
	public int finnInnlegg(Innlegg innlegg) {
		for (int i = 0; i < nesteledig; i++){
			if (innlegg.erLik(this.innleggtabell[i])){
				return i;
			}
		}
		return -1;
	}

	public boolean finnes(Innlegg innlegg) {
		return finnInnlegg(innlegg) > -1;
	}

	public boolean ledigPlass() {
		return this.nesteledig < this.innleggtabell.length;
	}
	
	public boolean leggTil(Innlegg innlegg) {
		if (finnes(innlegg)){
			return false;
		}
		this.innleggtabell[this.nesteledig] = innlegg;
		this.nesteledig++;

		return true;
	}
	
	public String toString() {
		StringBuilder tekst = new StringBuilder(String.format("%s\n", this.nesteledig));
		for (int i = 0; i < this.nesteledig; i++){
			tekst.append(this.innleggtabell[i]);
		}

		return tekst.toString();
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		Innlegg[] utvidet = new Innlegg[this.innleggtabell.length*2];
		for (int i = 0; i < this.nesteledig; i++){
			utvidet[i] = this.innleggtabell[i];
		}
		this.innleggtabell = utvidet;
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {

		if (!leggTil(innlegg)){
			return false;
		}
		if ( !ledigPlass() ){
			utvid();
		}
		leggTil(innlegg);
		return true;
		
	}
	
	public boolean slett(Innlegg innlegg) {
		int innlegg_index = finnInnlegg(innlegg);
		if (innlegg_index == -1){
			return false;
		}
		this.innleggtabell[innlegg_index] = null;
		for (int i = innlegg_index; i < nesteledig-1; i++){
			this.innleggtabell[i] = innleggtabell[i+1];
		}
		this.nesteledig--;

		return true;
	}
	
	public int[] search(String keyword) {
		int[] alle_ider = new int[1];
		int neste_index = 0;
		for (int i = 0; i < this.nesteledig; i++){
			if (this.innleggtabell[i].toString().contains(keyword)){
				if (neste_index >= alle_ider.length){
					int[] utvidet = new int[neste_index+1];
					for (int y = 0; y < this.nesteledig; i++){
						utvidet[y] = alle_ider[y];
					}
					alle_ider = utvidet;
				}
				alle_ider[i] = this.innleggtabell[i].getId();
				neste_index++;
			}
		}
		return alle_ider;
	}
}
package no.hvl.dat100.oppgave4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.File;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave3.*;

public class SkrivBlogg {

	public static boolean skriv(Blogg samling, String mappe, String filnavn) {

		File fil = new File(mappe + filnavn);

		try ( PrintWriter printer = new PrintWriter(fil) ) {

			printer.print(samling.toString());

		} catch (FileNotFoundException e) {
            System.out.println("fant ikke filen " + e);
			return false;
        }

		return true;
	}
}

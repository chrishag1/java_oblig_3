package no.hvl.dat100.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Scanner;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;
import no.hvl.dat100.oppgave2.*;
import no.hvl.dat100.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String mappe, String filnavn) {

		File fil = new File(mappe + filnavn);

		try{
			Scanner leser = new Scanner(fil);

			Blogg blogg = new Blogg(Integer.parseInt(leser.nextLine()));

			while (leser.hasNextLine()) {
				String type = leser.nextLine();

				int id = Integer.parseInt(leser.nextLine());
				String bruker = leser.nextLine();
				String dato = leser.nextLine();
				String tekst = leser.nextLine();
				int likes = 0;

				//Hvis "tekst" er int, så er det egentlig likes
				try{
					likes = Integer.parseInt(tekst);
					tekst = leser.nextLine();
				}
				catch (NumberFormatException _){
				}

				if (type.equals(TEKST)){
					blogg.leggTil(new Tekst(id, bruker, dato, likes, tekst));
				}
				else if (type.equals(BILDE)){
					String bilde = leser.nextLine();
					blogg.leggTil(new Bilde(id, bruker, dato, likes, tekst, bilde));
				}

			}

			return blogg;
		}
		catch (FileNotFoundException e){
			System.out.println("Kunne ikke lese filen " + e);

		}

		return null;
	}
}

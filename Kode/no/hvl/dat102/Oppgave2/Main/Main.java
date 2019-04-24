package no.hvl.dat102.Oppgave2.Main;

import java.util.*;
import static no.hvl.dat102.Oppgave2.Main.Utils.*;

public class Main {

	public static void main(String[] args) {
		System.out.println("Oppgave 2\n");

		flereTre();

		System.out.println();
	}
	
	public static KjedetBSTre<Integer> genereringTre(int size, int max) {
		KjedetBSTre<Integer> bs = new KjedetBSTre<Integer>();
		Random r = new Random();

		for (int i = 0; i < size; i++) {
			Integer n = new Integer(r.nextInt(max));
			bs.leggTil(n);
		}
		
		return bs;
	}

	private static void flereTre() {
		final int ANTALL_TRAER = 100;
		final int ANTALL_NODER = 1024;
		final int MAKS_VERDI = 512;

		ArrayList<Integer> hoyder = new ArrayList<Integer>();

		for (int i = 0; i < ANTALL_TRAER; i++) {
			KjedetBSTre<Integer> bs = genereringTre(ANTALL_NODER, MAKS_VERDI);

			hoyder.add(bs.hoyde());
		}

		System.out.println("Generert " + ANTALL_TRAER + " trær med " + ANTALL_NODER + " noder hver.\n");

		System.out.println("Minste teoretiske høyde: " + minTeoretiskHoyde(ANTALL_NODER));
		System.out.println("Største teoretiske høyde: " + (ANTALL_NODER - 1) + "\n");

		System.out.println("Minste høyde i kjøring: " + minVal(hoyder));
		System.out.println("Største høyde i kjøring: " + maxVal(hoyder));
		System.out.println("Gjennomsnittlig høyde i kjøring: " + avgVal(hoyder));

		System.out.println();
	}

}

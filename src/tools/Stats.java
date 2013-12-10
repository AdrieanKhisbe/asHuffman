/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

/**
 * 
 * @author Steph
 */
public class Stats {
	public static int nbCharDiff = 0;
	public static int nbTotalChar = 0;
	public static int nbSwap = 0;
	public static int nbMajList = 0; // -> O(n*n);
	public static long timeSwap = 0;
	public static long timeList = 0; // -> O(n*n);
	public static long timeBinaryWrite = 0;
	
	public static long tempsAvant = 0;
	public static long tempsApres = 0;

	public static boolean printIOD = false;
	public static boolean printIOC = false;
	public static boolean printStats = true;
	public static boolean printTemps = true;
	public static boolean printDebug = false;

	public static void switchTprintStats() {
		printStats = true;
	}

	public static void switchFprintStats() {
		printStats = false;
	}

	public static void switchTprintTempsD() {
		printTemps = true;
	}

	public static void switchFprintTempsD() {
		printTemps = false;
	}

	public static void switchTprintIOC() {
		printIOC = true;
	}

	public static void switchFprintIOC() {
		printIOC = false;
	}

	public static void switchTprintIOD() {
		printIOD = true;
	}

	public static void switchFprintIOD() {
		printIOD = false;
	}

	public static void switchTprintDebug() {
		printDebug = true;
	}

	public static void switchFprintDebug() {
		printDebug = false;
	}

	public static void printStats() {
		printStats(true);
	}

	public static void printStats(boolean reset) {
		if (printStats) {
			System.out.println("Nombre de caractere different : "
					+ Stats.nbCharDiff);
			System.out.println("Nombre de caractere Total : "
					+ Stats.nbTotalChar);
			
			// TODO: stat compression!!

			// Swap
			System.out.println("Nombre de Swap: " + Stats.nbSwap);
			long percentSwap = (Stats.timeSwap / 10) / Stats.getChrono(); // *100 stat /1000 s

			System.out.println("Temps passé à swapper: " + Stats.timeSwap
					+ " ms, soit " + percentSwap + "% du temps total");

			// Liste
			System.out.println("Nombre de Maj ordre de la liste : "
					+ Stats.nbMajList);

			long percentList = (Stats.timeList / 10) / Stats.getChrono();

			Stats.printDebug("t list:" + timeList);
			System.out.println("Temps passé à réordonner la liste: "
					+ Stats.timeList + " ms, soit " + percentList
					+ "% du temps total");
			System.out.println("\n");
			if (reset)
				resetStats();
		}
	}
	public static void printCompressionWriteStats(){
		long percentWrite = (Stats.timeBinaryWrite / 10) / Stats.getChrono(); // *100 stat /1000 s

		System.out.println("Temps passé à écrire en binaire: " + Stats.timeBinaryWrite
				+ " ms, soit " + percentWrite + "% du temps total");

	}
	

	public static void resetStats() {
		nbCharDiff = 0;
		nbTotalChar = 0;
		nbSwap = 0;
		nbMajList = 0; // -> O(n*n); fffffuuuuu
		timeSwap = 0;
		timeList = 0;
		timeBinaryWrite = 0;

	}

	public static void lanceChrono() {
		tempsAvant = System.currentTimeMillis();
	}

	public static void stopChrono() {
		tempsApres = System.currentTimeMillis();
	}

	public static long getChrono() {
		return ((long) (tempsApres - tempsAvant)) / 1000l;
	}

	public static void printChrono(String s) {
		if (printTemps) {
			System.out.println("Temps de " + s + " : " + Stats.getChrono()
					+ " sec");
		}
	}

	public static void printCharIOC(String s) {
		if (printIOC) {
			System.out.println(s);
		}
	}

	public static void printCharIOD(String s) {
		if (printIOD) {
			System.out.println(s);
		}
	}

	public static void printDebug(String s) {
		if (printDebug) {
			System.out.println(s);
		}
	}

	/**
	 * function timing
	 */
	public static void resetTimeSwap() {
		timeSwap = 0;
	}

	public static void addTimeSwap(long time) {
		timeSwap += time;
	}

	public static void resetTimeList() {
		timeList = 0;
	}

	public static void addTimeList(long time) {
		timeList += time;
	}
	public static void resetTimeBinaryWrite() {
		timeBinaryWrite = 0;
	}

	public static void addTimeBinaryWrite(long time) {
		timeBinaryWrite += time;
	}
	
}

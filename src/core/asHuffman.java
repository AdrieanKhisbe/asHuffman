package core;

import com.beust.jcommander.JCommander;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import tools.Stats;

public class asHuffman {

	public static void main(String[] args) throws IOException {
		// Stéphane, uuun throws ici....

		/*
		 * Options jct = new Options(); JCommander jCommander = null; String[]
		 * argv = { "-arg", "1", "test", "test" };
		 * 
		 * try { jCommander = new JCommander(jct, argv); } catch
		 * (com.beust.jcommander.ParameterException e) { System.out.println(e);
		 * String[] ex = { "-arg", "1", "test" }; JCommander exe = new
		 * JCommander(jct, ex); exe.usage(); }
		 */
		if (args.length == 0) {
			System.out.println("Lancement en mode test");
			testMode("fichier_original.txt", "fichier_compresse.dat",
					"fichier_decompresse.txt");
			System.out.println("Fin du test");
		} else if (args.length == 3) {

			switch (args[0]) {

			case "compression":

				break;

			case "decompression":
				
			case "test":

				break;
			default:
				System.err.println("Usage: (de)compression inputfile outputfile");
				System.exit(1);
			}

		}

		/*
		 * // TODO: vite changer cette ....Belle chose :) switch (jct.getOpt())
		 * { case 1: break; case 2: break; case 3: break; default:
		 * System.out.println("Mauvais numéro utilisé en argument \"arg\"");
		 * jCommander.usage(); break; }
		 */

	}

	// TODO : amélioration On remontre jusqua la racine obligatoirement ?
	// SWAP 2 FEUILLE PAS DE MAJ code ?
	private static void compressMode(String inputFile, String compressedFile)throws IOException{
		
	}
	private static void decompressMode(String compressedFile,
	String outPutFile) throws IOException{
		
	}

	private static void testMode(String inputFile, String compressedFile,
			String outPutFile) throws IOException {

		// TODO: tester existance fichiers

		Stats.lanceChrono();
		Compresseur c = new Compresseur(inputFile, compressedFile);
		c.compression();

		Stats.stopChrono();
		Stats.printChrono("compression");
		Stats.printDebug("Fin Compression");
		Stats.printCompressionWriteStats();
		Stats.printStats();

		Stats.printDebug("Début Decompression");
		Stats.lanceChrono();
		Decompresseur d = new Decompresseur(compressedFile, outPutFile);
		d.decompression();
		Stats.stopChrono();
		Stats.printChrono("decompression");
		Stats.printStats();

	}

}

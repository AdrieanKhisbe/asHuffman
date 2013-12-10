package core;

import com.beust.jcommander.JCommander;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import tools.Stats;

public class asHuffman {

	public static void main(String[] args) throws IOException {

		final String USAGE = "Usage: (de)compression inputfile outputfile";
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
		
		//TODO: desactiver après tests...
		if (args.length == 0) {
			System.out.println("Lancement en mode test");
			testMode("fichier_original.txt", "fichier_compresse.dat",
					"fichier_decompresse.txt");
			System.out.println("Fin du test");
			
			// System.err.println(USAGE);
			// System.exit(1);
			
		} else if (args.length == 3) {

			// TODO: argument checking!!

			switch (args[0].toLowerCase()) {

			case "c":
			case "compression":
				System.out.println("Lancement AsHuffman en mode compression");
				compressMode(args[1], args[2]);
				break;
				
			case "d":
			case "decompression":
				System.out.println("Lancement AsHuffman en mode decompression");
				decompressMode(args[1], args[2]);
				break;

			case "test": case "t":
				System.out.println("Lancement AsHuffman en mode test");
				testMode(args[1], args[2]);
				break;

			default:
				System.err.println(USAGE);
				System.exit(1);
			}

		} else {
			System.err.println((args[0].equals(egmp))? eegg:USAGE);
			System.exit(1);
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
	private static void compressMode(String inputFile, String compressedFile)
			throws IOException {
		System.out.println(">> Compression du fichier " + inputFile + " vers "
				+ compressedFile);

		//§DISStats.lanceChrono();
		Compresseur c = new Compresseur(inputFile, compressedFile);
		c.compression();

		//§DISStats.stopChrono();
		//§DISStats.printChrono("compression");
		//§DISStats.printDebug("Fin Compression");
		//§DISStats.printCompressionWrite//§DISStats();
		//§DISStats.print//§DISStats();
	}

	private static void decompressMode(String compressedFile, String outPutFile)
			throws IOException {
		System.out.println(">> DeCompression du fichier " + compressedFile
				+ " vers " + outPutFile);

		//§DISStats.printDebug("Début Decompression");
		//§DISStats.lanceChrono();
		Decompresseur d = new Decompresseur(compressedFile, outPutFile);
		d.decompression();
		//§DISStats.stopChrono();
		//§DISStats.printChrono("decompression");
		//§DISStats.print//§DISStats();
	}

	private static void testMode(String inputFile, String compressedFile,
			String outPutFile) throws IOException {
		// TODO: tester existance fichiers
		compressMode(inputFile, compressedFile);
		decompressMode(compressedFile, outPutFile);
	}

	private static void testMode(String inputFile, String outPutFile)
			throws IOException {
		testMode(inputFile, "/tmp/compress", outPutFile);
		// marchera que sur unix.
	}
	
	private static String egmp= "troll", eegg="Attention, coeur application conçu par un Clown, bozo";
	
}

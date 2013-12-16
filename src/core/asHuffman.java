package core;

import java.io.File;
import java.io.IOException;

import tools.Dot;
import tools.Files;
import tools.Stats;

public class asHuffman {

	public static void main(String[] args) {

		final String USAGE = "Usage:\n" + ""
				+ "  c[ompression] fichier_à_compresser fichier_compressé \n"
				+ "  d[ecompression] fichier_compressé fichier_decompressé\n"
				+ "  t[est] fichier_à_compresser fichier_decompressé \n"
				+ "  chaine chainacompresser fichier_compressé \n"
				+ "  chainetest chainacompresser fichier_compressé \n";

		try {

			if (args.length == 0) {
				System.err.println(USAGE);
				System.exit(1);

			} else {
				// BONUX: argument checking!!

				switch (args[0].toLowerCase()) {

				case "c":
				case "compression":
					System.out
							.println("Lancement AsHuffman en mode compression");
					compressMode(args[1], args[2]);
					break;

				case "d":
				case "decompression":
					System.out
							.println("Lancement AsHuffman en mode decompression");
					decompressMode(args[1], args[2]);
					break;

				case "test":
				case "t":
					System.out.println("Lancement AsHuffman en mode test");
					testMode(args[1], args[2]);
					break;

				case "chaine":
					System.out.println("Lancement AsHuffman en mode chaine");
					compressChaineMode(args[1], args[2], false);
					break;

				case "chainetest":
					System.out
							.println("Lancement AsHuffman en mode chaine test (création arbre pour chaque noued)");
					compressChaineMode(args[1], args[2], true);
					break;
					
				case "batchtest":
					//TOBE IMPLEMENTED

				default:
					System.err.println((args[0].equals(egmp)) ? eegg : USAGE);
					System.exit(1);
				}

			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("Le nombre de paramètre est incorrect\n"
					+ " Arret du programme\n" + USAGE);
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Le fichier d'input spécifié n'existe pas\n"
					+ " Arret du programme");
			// TODO: HERE IOException pourrait venir d'ailleur: tout problème de fichier arrivant en cours de route
			System.exit(1);
		}

	}

	// TODO : amélioration On remontre jusqua la racine obligatoirement ?
	// SWAP 2 FEUILLE PAS DE MAJ code ?
	private static void compressMode(String inputFile, String compressedFile)
			throws IOException {

		Files.checkFileExists(inputFile);

		System.out.println(">> Compression du fichier " + inputFile + " vers "
				+ compressedFile);

		Stats.lanceChrono();
		Compresseur c = new Compresseur(new File(inputFile), new File(
				compressedFile));
		c.compression();

		Stats.stopChrono();
		Stats.printChrono("compression");
		// §DISStats.printDebug("Fin Compression");
		// §DISStats.printCompressionWriteStats();
		// §DISStats.printStats();

		float tauxCompression = Files
				.compareFileSize(inputFile, compressedFile);
		System.out.println("Taux de compression: "
				+ (100 - (tauxCompression * 100)) + "%");

		// Dot Regenation
		// BONUX: option!!
		Dot.generateArbreGraph(c.getArbreEncodage());
	}

	private static void compressChaineMode(final String chaine,
			final String compressedFile, boolean testMode) throws IOException {

		Stats.lanceChrono();
		Compresseur c = new Compresseur(chaine, new File(compressedFile));
		if (testMode)
			c.compressionTest();
		else
			c.compression();

		Stats.stopChrono();
		Stats.printChrono("compression");
		if (testMode)
			System.out.println(c.getEncodageTable());
		
		// Dot Regenation
		Dot.generateArbreGraph(c.getArbreEncodage());

	}

	private static void decompressMode(String compressedFile, String outPutFile)
			throws IOException {

		Files.checkFileExists(compressedFile);
		System.out.println(">> DeCompression du fichier " + compressedFile
				+ " vers " + outPutFile);

		// §DISStats.printDebug("Début Decompression");
		Stats.lanceChrono();
		Decompresseur d = new Decompresseur(compressedFile, outPutFile);
		d.decompression();

		Stats.stopChrono();
		Stats.printChrono("decompression");
		// §DISStats.printStats();

		// Dot Regenation
		Dot.generateArbreGraph(d.getArbreDecodage());

	}

	private static void testMode(String inputFile, String compressedFile,
			String outPutFile) throws IOException {
		Files.checkFileExists(inputFile);
		compressMode(inputFile, compressedFile);
		decompressMode(compressedFile, outPutFile);
	}

	private static void testMode(String inputFile, String outPutFile)
			throws IOException {
		testMode(inputFile, "/tmp/compress", outPutFile);
		// marchera que sur unix.
	}

	private static String egmp = "troll",
			eegg = "Attention, coeur application conçu par un Clown, bozo";

}

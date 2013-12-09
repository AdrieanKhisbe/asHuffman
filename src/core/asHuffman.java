package core;

import com.beust.jcommander.JCommander;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class asHuffman {

	public static void main(String[] args) throws IOException {
		Options jct = new Options();
		JCommander jCommander = null;
		String[] argv = { "-arg", "1", "test", "test" };

		try {
			jCommander = new JCommander(jct, argv);
		} catch (com.beust.jcommander.ParameterException e) {
			System.out.println(e);
			String[] ex = { "-arg", "1", "test" };
			JCommander exe = new JCommander(jct, ex);
			exe.usage();
		}

		Compresseur c = new Compresseur("fichier_binaire.txt",
				"fichier_binaire.dat");
		c.compression();
		// BitSet bits2 = BitSet.valueOf(new long[] { Long.parseLong("10101001",
		// 2) });
		// System.out.println(Long.toString(bits2.toLongArray()[0], 2)); //
		// prints 1000001
		System.out.println("fin Compression");
		// try {
		// Thread.sleep(4000);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		System.out.println("Début Decompression");

		Decompresseur d = new Decompresseur("fichier_binaire.dat",
				"ficier_decompresser.txt");
		d.decompression();

		// TODO: vite changer cette ....
		switch (jct.getOpt()) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		default:
			System.out.println("Mauvais numéro utilisé en argument \"arg\"");
			jCommander.usage();
			break;
		}

	}

	// TODO : amélioration On remontre jusqua la racine obligatoirement ?
	// SWAP 2 FEUILLE PAS DE MAJ code ?

	/*
	 * BUG: -bit suplémenetaire a la fin (octet obligatoir) - pb de flush
	 * decompression en ecriture - caractere accepté : a-z A-Z seulement
	 */
}

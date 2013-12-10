package core;

import com.beust.jcommander.JCommander;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import tools.Stats;

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
          
          
		Stats.lanceChrono();

		Compresseur c = new Compresseur("fichier_binaire.txt",
				"fichier_binaire.dat");
		c.compression();

                    Stats.stopChrono();
                    Stats.printChrono("compression"); 
		Stats.printDebug("fin Compression");
                    Stats.printStats();
		Stats.printDebug("Début Decompression");

          
                    Stats.lanceChrono();
		Decompresseur d = new Decompresseur("fichier_binaire.dat",
				"fichier_decompresser.txt");
		d.decompression();
                    Stats.stopChrono();
                    Stats.printChrono("decompression"); 
                    Stats.printStats();
		
		// TODO: vite changer cette ....Belle chose :)
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


}

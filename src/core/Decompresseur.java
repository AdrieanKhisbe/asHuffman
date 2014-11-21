package core;

import huffmanTree.AHA;
import huffmanTree.AHAD;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;

/**
 * Classe capturant la logique de decompression d'un fichier
 * 
 * @author Adriean
 *
 */
public class Decompresseur {
	private PrintWriter outS; // BufferedOutputStream outS;
	private BitInputStream inS;
	private AHAD arbreDecodage = null;

	/**
	 * Crée un nouveau decompresseur à partir des noms de fichier
	 * @param nomI nom du fichier d'entrée
	 * @param nomO nom du fichier de sortie
	 * 
	 * @throws FileNotFoundException
	 * TODO: reactor with Method factory.
	 */
	public Decompresseur(String nomI, String nomO) throws FileNotFoundException {
		this(new File(nomI), new File(nomO));
	}
	
	/**
	 *  Crée un nouveau decompresseur à partir des fichier à utiliser comme entrée et sortie
	 * @param fileI
	 * @param fileO
	 * @throws FileNotFoundException
	 */
	public Decompresseur(File fileI, File fileO) throws FileNotFoundException {
		// ouverture du flux de lecture du fichier a decompresser
		this.inS = new BitInputStream(new BufferedInputStream(
				new FileInputStream(fileI)));

		// ouverture du flux d'écriture du ficher decompresser
		this.outS = new PrintWriter(new OutputStreamWriter(
				new FileOutputStream(fileO), Charset
						.forName("UTF-8").newEncoder()));
		this.arbreDecodage = new AHAD();
	}

	
	/**
	 * Réalise la décompression dans son intégralité.
	 * (va donc créer nouveau fichier dans lequel va encoder le résultat)
	 * 
	 * @throws IOException
	 */
	public void decompression() throws IOException {

		// On parcourt tous les characteres du text a comrpesser
		int bit = this.inS.readBit();
		while (bit != -1) {

			// §10Stats.printCharIOD("Lecteur du bit  : "+bit);

			// On decode les bits et on ecrit le caractere decodé
			Character a = arbreDecodage.decode(bit);

			if (a != null) {
				outS.append(a);
				// §10Stats.printCharIOD("Ecriture du caractere  : "+a);
			}

			// Lecture nouveau
			bit = this.inS.readBit();

		}
		outS.flush();

		this.outS.close(); // fermeture du flux
		this.inS.close(); // fermeture du flux
	}

	public AHA getArbreDecodage() {
		return arbreDecodage;
	}
	
	public String getEncodageTable(){
		return arbreDecodage.hashToCsv();
	}
}
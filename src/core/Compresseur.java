package core;

import huffmanTree.AHAC;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class Compresseur {
	private String inputFilename;
	private String outPutFilename;
	private BufferedOutputStream outS;
	private BufferedReader inS;
	private AHAC arbreEncodage = null;

	public Compresseur(String nomI, String nomO) {
		this.inputFilename = nomI;
		this.outPutFilename = nomO;
		this.arbreEncodage = new AHAC();
	}

	public Compresseur(String nomO) {
		this("", nomO);
		// WHY??
	}

	public void compression() throws IOException {
		// ouverture du flux d'écriture du ficher compresser
		this.outS = new BufferedOutputStream(new FileOutputStream(
				this.outPutFilename));
		BitOutputStream ecriture = new BitOutputStream(this.outS);

		// ouverture du flux de lecture du fichier a compresser

		this.inS = new BufferedReader(new InputStreamReader(
				new FileInputStream(this.inputFilename), Charset.forName(
						"UTF-8").newDecoder()));

		// On parcourt tous les characteres du text a compresser
		String ligne = this.inS.readLine();
		while (ligne != null) {
			// Pour chaue caractere on fait le traitement adéquoite
			for (int i = 0; i < ligne.length(); i++) {
				char c = ligne.charAt(i);
				System.out.println(">> Lecture caractère : '" + c + "'");
				arbreEncodage.encode(c, ecriture);
				// TODO: écrit ici!!
				System.out.println("\n");

			}
			ligne = this.inS.readLine();
		}

		// encode caractère de fin. HACK
		arbreEncodage.encode('\0', ecriture);

		outS.flush();
		this.outS.close(); // fermeture du flux
		this.inS.close(); // fermeture du flux
	}

}

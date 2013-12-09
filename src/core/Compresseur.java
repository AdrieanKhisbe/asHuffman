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

		// Lecture caractère par caractère
		int cha;
		while ( ( cha= this.inS.read()) != -1) {
			// Pour chaue caractere on fait le traitement adéquoite
			
				System.out.println(">> Lecture caractère : '" + cha + "'");
				arbreEncodage.encode((char) cha, ecriture);
				// TODO: écrit ici!!
							
		}

		// encode caractère de fin. HACK
		arbreEncodage.encode('\0', ecriture);

		outS.flush();
		this.outS.close(); // fermeture du flux
		this.inS.close(); // fermeture du flux
	}

}

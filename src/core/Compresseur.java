package core;

import huffmanTree.AHAC;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class Compresseur {
	private BufferedOutputStream outS;
	private BufferedReader inS;
	private AHAC arbreEncodage = null;

	/**
	 * 
	 * @param fileI
	 * @param fileO
	 * @throws IOException
	 */
	public Compresseur(File fileI, File fileO) throws IOException {

		// ouverture du flux de lecture du fichier a compresser
		this.inS = new BufferedReader(new InputStreamReader(
				new FileInputStream(fileI), Charset.forName("UTF-8")
						.newDecoder()));
		
		// ouverture du flux d'écriture du ficher compresser
		this.outS = new BufferedOutputStream(new FileOutputStream(fileO));
		this.arbreEncodage = new AHAC();
	}

	public Compresseur(String chaine, File fileO) throws IOException {
		// Création d'un flux à partir chaine caractère
		this.inS = new BufferedReader(new InputStreamReader(
				new ByteArrayInputStream(chaine.getBytes("UTF-8"))));

		// ouverture du flux d'écriture du ficher compresser
		this.outS = new BufferedOutputStream(new FileOutputStream(fileO));
		this.arbreEncodage = new AHAC();
	}
	
	public Compresseur(String chaine) throws IOException {
		this.inS = new BufferedReader(new InputStreamReader(
				new ByteArrayInputStream(chaine.getBytes("UTF-8"))));

		// ouverture du flux d'écriture du ficher compresser
		this.outS = new BufferedOutputStream(System.out);
		this.arbreEncodage = new AHAC();
		
	}
	

	public void compression() throws IOException {

		BitOutputStream ecriture = new BitOutputStream(this.outS);

		// Lecture caractère par caractère
		int cha;
		while ((cha = this.inS.read()) != -1) {
			// Pour chaque caractere on fait le traitement adéquoite

			//§DISStats.printCharIOC(">> Lecture caractère : '" + (char) cha +
			// "'")
			arbreEncodage.encode((char) cha, ecriture);
			// TODO: écrit ici!!

		}

		// encode caractère de fin. HACK
	//	arbreEncodage.encode('\0', ecriture);

		outS.flush();
		this.outS.close(); // fermeture du flux
		this.inS.close(); // fermeture du flux

	}

	public String getArbreDot() {
		return arbreEncodage.toDot();
	}

}

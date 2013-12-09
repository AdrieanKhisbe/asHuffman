package core;

import huffmanTree.AHAD;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;

public class Decompresseur {
	private String nomFichierI = "";
	private String nomFichierO = "";
	private PrintWriter outS; //BufferedOutputStream outS;
	private BitInputStream inS;
	private AHAD struct = null;

	public Decompresseur(String nomI, String nomO) {
		this.nomFichierI = nomI;
		this.nomFichierO = nomO;
		this.struct = new AHAD();
	}

	public void decompression() throws IOException {
		// ouverture du flux d'écriture du ficher decompresser
		this.outS = 
				new PrintWriter(new OutputStreamWriter(
						new FileOutputStream(
								this.nomFichierO), Charset.forName("UTF-8")
								.newEncoder()));
//				new BufferedOutputStream(new FileOutputStream(
//				this.nomFichierO), Charset.forName("UTF-8")
//				.newEncoder());

		// ouverture du flux de lecture du fichier a decompresser
		this.inS = new BitInputStream(new BufferedInputStream(
				new FileInputStream(this.nomFichierI)));

		// On parcourt tous les characteres du text a comrpesser
		int bit = this.inS.readBit();
		while (bit != -1) {

			// System.out.println(bit);
			Character a = struct.decode(bit);
			
			if(a!=null)
				outS.append(a);
			
			// lecture nouvea
			bit = this.inS.readBit();

		}
		outS.flush();

		this.outS.close(); // fermeture du flux
		this.inS.close(); // fermeture du flux
	}

}
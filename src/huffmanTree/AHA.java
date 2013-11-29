package huffmanTree;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Classe gestionnaire de l'arbre de Humman
 * 
 */
public class AHA {

	Arbre aha;
	Hashtable<Character, Feuille> index;
	ArrayList<Arbre> orderNoeudPoids; // RENAME

	
	
	
	// TODO signatures à revoir
	private void Modification(char symbole) {
		// TODO
	}

	private void Traitement(Arbre Q) {

	}

	// Méthodes pour lire et encoder char.
	public bit encoder(char lettre) {

		
	}
	
	// decoder, va etre spécial... doit avoir le flux
	public void decoder(InputStream in, OutputStream out);
	
	

	public String toString() {
		StringBuffer sb = new StringBuffer();

		sb.append("Arbre:\n").append(aha);
		sb.append("Index:\n").append(index);
		sb.append("orderNoeudPoids").append("toAdapt");
		
		
		return sb.toString();
	}

}

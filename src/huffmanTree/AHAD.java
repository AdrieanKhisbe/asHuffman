/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package huffmanTree;

import java.io.BufferedOutputStream;
import java.io.IOException;

/**
 * 
 * @author Steph
 */
public class AHAD extends AHA {
	Arbre currentP;
	int recupChar;
	String buffChar;

	public AHAD() {
		super();
		currentP = racineAha;
		recupChar = 8; // On le met a 7 par défaut car au début c'est forcément
		buffChar = ""; // WTF: utilise vrai buff non?
	}

	/**
	 * Est ce que l'on doit encore lire des caractère
	 */

	// NO COMPPRENDO
	public Character decode(int bit)//, BufferedOutputStream ecriture)
			throws IOException {
		// TODO: retourne le code, l'éciture doit se faire pas le code appelant

		if (recupChar == 0) {
			Feuille c = this.naviguerAHA(bit);
			if (c == null) {
				// doit lire charactère de plus
				return null;
			} else if (this.isSpecial(c)) {
				recupChar = 8;
			} else {
				// écrit lettre

			//	ecriture.write(c.lettre); // CHECK encodage...
				// incrémente feuille
				this.modificationAHA(c.lettre);
				
				return c.lettre;
			}

		} else {

			recupChar--;
			buffChar += bit;
			if (recupChar == 0) {
				char l = (char) Integer.parseInt(buffChar, 2);
				System.out.println("J'écris 2: " + l);
				// T ecriture.write(l);
				this.modificationAHA(l); // ajoute feuille
				this.resetPosition(); // Hack. (ne sert que premiere fois)
				buffChar = "";
				return l;
			}
		}
		return null;
	}

	private void resetPosition() {
		this.currentP = this.racineAha;
	}

	/**
	 * Renvoi le char si feuille Atteinte
	 * 
	 * @param bit
	 * @return
	 */
	private Feuille naviguerAHA(int bit) {
		// Poisition courante jamais dans une feuille
		System.out.println(currentP);


		if (bit == 0) {

			currentP = ((NoeudInterne) currentP).filsGauche;
		} else {
			currentP = ((NoeudInterne) currentP).filsDroit;
		}

		if (currentP instanceof Feuille) {
			Feuille tmp = (Feuille) currentP;
			currentP = racineAha; // revient au début arbre
			return tmp;

		} else {
			return null;
		}

	}

	private boolean isSpecial(Feuille f) {
		return f == this.feuilleSpeciale;
	}
}

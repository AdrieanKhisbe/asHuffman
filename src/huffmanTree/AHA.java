package huffmanTree;

import java.util.BitSet;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Classe gestionnaire de l'arbre de Humman
 * 
 */
public class AHA {

	Arbre aha;
	boolean first = true;
	Map<Character, Feuille> index = new HashMap<>();
	Arbre special = new Feuille('#', "", 0); // PK initialise feuille avec
												// code!?
	LinkedList<Arbre> list = new LinkedList<>();

	// ArrayList<Arbre> orderNoeudPoids; // RENAME

	public AHA() {
		aha = special;
		aha.pere = aha;
		list.addLast(special);
	}

	// Test si le char est présent dans l'arbre
	public boolean charIsPresent(char c) {
		return index.containsKey(c);
	}

	// Retourn le code(arbre) du caractere
	public String getCodeChar(char charAt) {
		return index.get(charAt).code;
	}

	public String indextoString() {

		StringBuffer sb = new StringBuffer();
		sb.append(">> Index:\n");
		for (int i = list.size() - 1; i >= 0; i--) {
			sb.append("--> ").append(list.get(i)).append("\n");

		}
		sb.append("Fin index");
		return sb.toString();
	}

	// TODO : REFAIRE L'ininatialisation des varibles !!!! et l'ajout des nous
	// interne dans la list
	public void modificationAHA(char c) {
		Arbre q = null;
		Arbre p = null;
		Feuille s = null;
		// Si s n'est pas dans H
		if (!this.charIsPresent(c)) {
			System.out.println("Nouveau caractère : " + c);
			q = special;
			p = special.pere;
			Arbre buff = special;

			s = new Feuille(c, ((Feuille) q).getCode() + "1", 1);
			index.put(c, s);
			s.posList = list.size() - 1;

			q = new NoeudInterne(buff, s, 0, buff.code);

			buff.code += 0;
			s.pere = q;

			buff.pere = q;

			list.addLast(q);
			list.addLast(s);

			if (first) {
				first = false;
				aha = q;
			} else {
				q.pere = p;
				((NoeudInterne) p).filsGauche = q;
			}
		}
		// Sinon
		else {
			System.out.println("Caractere déja présent !");
			// Soit q le feuille correspondant a s dans H
			q = index.get(c);
			// q.poids++;
			// aurait du appeler procédure pour mettre à jour tous les poids!
		}
		this.majList();
		this.traitement(q);
	}

	private void traitement(Arbre q) {
		Arbre p = q;
		Arbre viole = null;
		boolean swap = false;
		boolean viol = false;
		// System.out.println(">>> Traitement 1 \n" + this.indextoString());

		while (p.pere != null) {
			p.poids++;
			for (int i = p.posList - 1; i > 0; i--) {
				// System.out.println("p est " +
				// p.code+" et de poids : "+p.poids);

				Arbre tmp = ((Arbre) list.get(i));
				if (p.poids > tmp.poids ) {

					viole = tmp;
					// System.out.println("!> condition Violeeeee");
					viol = true;
				}

			}
			if (viol) {
				// System.out.println(">>> Traitement 2 \n" +
				// this.indextoString());
				if(!p.pere.code.contentEquals(viole.code)){
					swap(p, viole);
					System.out.println("JE VIENS DE SWAP");
					this.majList();
					viol = false;
				}
				// System.out.println(">>> Traitement 1 \n" +
				// this.indextoString());
			}

			p = p.pere;
		}
		p.poids++;

		// System.out.println(">>> Traitement 2 \n" + this.indextoString());

	}

	public String getCodeSpecialChar() {
		System.out.println("Récupération caractère spécial");
		return special.code;
	}

	public Arbre finBloc(Arbre q) {
		Arbre rep = q;
		// On parcourt la liste de q a q +1
		for (int i = list.size() - 1; i >= 0; i--) {
			// Si q < q+1 q := q+1
			if (rep.poids == ((Arbre) list.get(i)).poids) {
				rep = (Arbre) list.get(i);
			}
		}
		return rep;
	}

	public Arbre swap(Arbre n1, Arbre n2) {
		/*
		 * Echanger les n. pere et echanger les n.pere.Fils
		 */

		System.out.println("swapp entre " + n1 + " et " + n2);

		/*
		 * NoeudInterne p1 = (NoeudInterne) n1.pere; NoeudInterne p2 =
		 * (NoeudInterne) n2.pere;
		 * 
		 * Boolean n1agauche = p1.filsGauche == n1; Boolean n2agauche =
		 * p2.filsGauche == n2;
		 * 
		 * 
		 * if(n1agauche){ p1.filsGauche = n2; }else { p1.filsDroit = n2; }
		 * n2.pere = p1;
		 * 
		 * if(n2agauche){ p2.filsGauche = n1; }else { p2.filsDroit = n1; }
		 * n2.pere = p1;
		 */

		String s1 = n1.code;
		String s2 = n2.code;
		Arbre buff1 = new Arbre();
		buff1.code = n1.code;
		buff1.pere = n1.pere;
		Arbre buff2 = n2;
		buff2.code = n2.code;
		buff2.pere = n2.pere;

		Arbre buff3 = n1.pere;
		Arbre buff4 = n2.pere;

		// Je pense que le bug vien d'ici, j'ai vraiemnt fait nimp mdr
		if (((NoeudInterne) n2.pere).filsDroit.code.contentEquals(n2.code)) {
			if (((NoeudInterne) buff1.pere).filsDroit.code
					.contentEquals(n1.code)) {
				((NoeudInterne) n1.pere).filsDroit = n2;
			} else {
				((NoeudInterne) n1.pere).filsGauche = n2;
			}

			((NoeudInterne) n2.pere).filsDroit = n1;

		} else {
			if (((NoeudInterne) buff1.pere).filsDroit.code
					.contentEquals(n1.code)) {
				((NoeudInterne) n1.pere).filsDroit = n2;
			} else {
				((NoeudInterne) n1.pere).filsGauche = n2;
			}
			((NoeudInterne) n2.pere).filsGauche = n1;
		}

		n2.code = s1;
		n1.code = s2;
		n2.pere = buff3;
		n1.pere = buff4;

		// On met a jour les codes
		n1.miseAJourCode();
		n2.miseAJourCode();

		// v2: p..

		// On retourne q
		return n1;
	}

	private void majList() {
		System.out.println(">>> Traitement avant mise à jour \n"
				+ this.indextoString());
		list.clear();
		LinkedList<Arbre> buffList = new LinkedList<Arbre>();
		buffList.addLast(aha);

		while (buffList.size() != 0) {
			Arbre n = (Arbre) buffList.pop();

			list.addLast(n);
			n.posList = list.size() - 1;
			if (!(n instanceof Feuille)) {
				buffList.addLast(((NoeudInterne) n).filsDroit);
				buffList.addLast(((NoeudInterne) n).filsGauche);
			}
		}
		System.out.println(">>> Traitement après \n" + this.indextoString());
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();

		sb.append("Arbre:\n").append(aha);
		sb.append("Index:\n").append(index);
		sb.append("orderNoeudPoids").append("toAdapt");

		return sb.toString();
	}

}

/*
 * SWAP :
 * 
 * On ajoute une nouvelle feuille ou on incremente : boucle de notre "arbre"
 * courant jusqu'a la racine on incrémente pere , si en remontant (de un ? ou
 * jusqu'a la racine) on a violé personne on fait rien ON cherche le denrier mec
 * qu'on a violé , on échange notre position avec lui
 */
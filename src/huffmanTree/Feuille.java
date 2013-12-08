package huffmanTree;

public class Feuille extends Arbre {
	public char lettre;

	public Feuille(char c, String code, int poids) {
		this.code = code;
		this.lettre = c;
		this.feuille = true;
		this.poids = poids;
	}

	public String getCode() {
		return code;
	}

	public String toString() {
		return "Feuille '" + lettre + "', poids = " + poids + ", code = " + code;
	}
}

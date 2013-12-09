package huffmanTree;

public class Feuille extends Arbre {
	public char lettre;

	public Feuille(char c, String code, int poids) {
		this.code = code;
		this.lettre = c;
		this.poids = poids;
	}

	public String getCode() {
		return code;
	}

	public String toString() {
		// pas performant mais bon.....
		if(lettre== '\n') return "Feuille '\\n', poids = " + poids + ", code = " + code;
		return "Feuille '" + lettre + "', poids = " + poids + ", code = " + code;
	}
}

package huffmanTree;


public class Feuille extends Arbre {
	public char lettre;

	public Feuille(char c, String code, int poids) {
		this.code = code;
		this.lettre = c;
		this.poids = poids;
		
		
		this.idName = (c == '"')? "\\\"" : String.valueOf(c); 
		// ou Character.toString(char).  (mieux que hack ""+c)
		// Id dot: n'importe quoi entre quotes, (avec quote échapée)
		//TODO backslash n?
	}

	public String getCode() {
		return code;
	}

	public String toString() {
		// pas performant mais bon.....
		if (lettre == '\n')
			return "Feuille '\\n', poids = " + poids + ", code = " + code;
		return "Feuille '" + lettre + "', poids = " + poids + ", code = "
				+ code;
	}

	private static final String dotTemplate = "     \"%1$s\" [shape=record, label = \"<f0> %1$s | <f1>  %2$s  |<f2> %3$d\" ] ;";

	// lettre, code, poids
	// TODO: color

	public String toDot() {
		return String.format(dotTemplate, lettre, code, poids);
	}
	// TODO fix ketter format
	// TODO: échapper cars!

}

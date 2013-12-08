package huffmanTree;

public class NoeudInterne extends Arbre {
    public Arbre filsGauche = null;
    public Arbre filsDroit = null;
    
    
    public NoeudInterne(Arbre ag, Arbre ad,int poids,String code){
        this.filsGauche = ag;
        this.filsDroit = ad;
        this.code = code;
        this.poids = poids;
    }
    
	public String toString() {
		return "Noued interne:  poids =" + poids + ", code=" + code;
	}
}

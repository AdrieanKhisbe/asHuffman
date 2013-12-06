package huffmanTree;

import java.util.BitSet;
import java.util.HashMap;

/**
 * Classe gestionnaire de l'arbre de Humman
 *
 */
public class AHA {
    
    Arbre aha;
    HashMap<Character, Feuille> index;
    //ArrayList<Arbre> orderNoeudPoids; // RENAME
    
    
    
    //Test si le char est présent dans l'arbre
    public boolean charIsPresent(char c) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    //Retourn le code(arbre) du caractere
    public BitSet getCodeChar(char charAt) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    //Ennoncé
    public void modificationAHA(char c){
        Feuille f = null;
        aha = this.traitement(f);
    }
    //Ennoncé
    private Arbre traitement(Feuille f) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    public BitSet getCodeSpecialChar(char c) {
        throw new UnsupportedOperationException("Not yet implemented");
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

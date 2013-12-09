package huffmanTree;


public class Arbre {
    
    Arbre pere;
    public int poids;
    public String code;
    public int posList ;
 // Mes a jour les code a partir du noeud
    public void miseAJourCode() {
   	  	//mise à jour des noueds fils si existants
    	if(!(this instanceof Feuille)){
    		NoeudInterne ni = (NoeudInterne) this;
    		ni.filsGauche.code = ni.code + "0";
    		ni.filsDroit.code = ni.code + "1";

    		//System.out.println(this);
    		ni.filsDroit.miseAJourCode(); 		
    		ni.filsGauche.miseAJourCode(); 	
    		
    	} else return;
    	// améliorer.
    	
       
    }
    
}
//10001111100



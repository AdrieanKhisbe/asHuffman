package huffmanTree;

import java.util.LinkedList;

public class Arbre {
    
    Arbre pere;
    public int poids;
    public String code;
    public int posList ;
    public boolean feuille = false;
    
    public void parcour(Arbre a){
        LinkedList<Arbre> list = new LinkedList<>();
        list.addLast(a);
        while(list.size() != 0){
            Arbre n = (Arbre) list.pop();
            System.out.println(n.poids);
            if(!n.feuille){
                
                list.addLast(((NoeudInterne) n).filsDroit);
                list.addLast(((NoeudInterne) n).filsGauche);
                
            }
        }
    }
            /*
    ParcoursLargeur(Arbre A) {
   f = FileVide
   enfiler(Racine(A), f)
   Tant que (f != FileVide) {
       nœud = defiler(f)
       Visiter(nœud)                        //On choisit de faire une opération
       Si (gauche(nœud) != null) Alors
           enfiler(gauche(nœud), f)
       Si (droite(nœud) != null) Alors
           enfiler(droite(nœud), f)
   }
   */
}



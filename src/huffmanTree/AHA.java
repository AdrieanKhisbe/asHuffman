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
    Arbre special = new Feuille('#', "", 0); // PK initialise feuille avec code!?
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
        // Si s n'est pas dans H
        if (!this.charIsPresent(c)) {
            System.out.println("Nouveau caractère : " + c);
            q = special;
            p = special.pere;
            Arbre buff = special;
            
            
            Feuille s = new Feuille(c, ((Feuille) q).getCode() + "1", 1);
            index.put(c, s);
            s.posList = list.size() - 1;
            
            
            
            q = new NoeudInterne(buff, s, 1, buff.code);
            
            
            buff.code += 0;
            s.pere = q;
            buff.pere = q;
            
            list.addLast(q);
            list.addLast(s);
            
            
            if(first){
                first = false;
                aha = q;
            }else{
                q.pere = p;
                System.out.println(p.code);
                ((NoeudInterne)p).filsGauche = q;
            }
        }
        // Sinon
        else {
            System.out.println("Caractere déja présent !");
            // Soit q le feuille correspondant a s dans H
            q = index.get(c);
            q.poids++;
            // aurait du appeler procédure pour mettre à jour tous les poids!
        }
        this.majList();
        this.traitement(q);
    }
    
    // Ennoncé
    // On ne peux que remonter dans la liste donc il faut seulement la remettre
    // a jour a la fin
    private void traitement(Arbre q) {
        Arbre viole = null;
        boolean swap = false;
        
        for (int i = q.posList - 1; i > 0; i--) {
            if (q.poids > ((Arbre) list.get(i)).poids) {
                
                // On cherche le dernier qui ces fait violé
                for (int j = i; j >= 0; j--) {
                    if (q.poids > ((Arbre) list.get(i)).poids) {
                        viole = ((Arbre) list.get(i));
                        System.out.println("!> condition Violeeeee");
                    }
                }
                // On a le dernier violé
                q = swap(q, viole);
                System.out.println("On swap" + q.code + "et" + viole.code);
                swap = true;
            }
            // Si le pere de q n'est pas la racine
            if (i <= 1) {
                // On incremente son poids et on re vérifis qu'il ne viole
                // personne
                q.pere.poids++;
            }
        }
        // On met a jour la nouvelle liste si il y a eu un swap
        if (swap) {
            System.out.println("On maj la liste comme il y a eu un swap !");
            this.majList();
        }
        
        System.out.println(">>> Traitement \n" + this.indextoString());
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
        Arbre buff1 = n1;
        Arbre buff2 = n2;
        
        buff1.code = n2.code;
        buff1.pere = n2.pere;
        buff2.code = n1.code;
        buff2.pere = n1.pere;
        
        n2 = buff1;
        n1 = buff2;
        
        // On met a jour les codes
        this.mAJ(n2, "first");
        this.mAJ(n1, "first");
        
        // On retourne q
        return n2;
    }
    
    // Mes a jour les code a partir du noeud
    public void mAJ(Arbre n, String s) {
        // Lors du premier apelle le code de l'arbre courant est déja mis a jour
        if (s.contentEquals("first")) {
            if (!n.feuille) {
                // Si ej ne suis pas une feuille je met a jout mes 2 fils
                this.mAJ(((NoeudInterne) n).filsGauche, "0");
                this.mAJ(((NoeudInterne) n).filsDroit, "1");
            }
        } else {
            // Je me met a jour grace au code de mon pere qui est a jour et au
            // code que mon pere me donne
            n.code = n.pere.code + s;
            if (!n.feuille) {
                // Si je suis un noeud je met a jours mes 2
                this.mAJ(((NoeudInterne) n).filsGauche, "0");
                this.mAJ(((NoeudInterne) n).filsDroit, "1");
            }
        }
    }
    
    private void majList() {
        list.clear();
        LinkedList<Arbre> buffList = new LinkedList<Arbre>();
        buffList.addLast(aha);
        
        while (buffList.size() != 0) {
            Arbre n = (Arbre) buffList.pop();
            
                list.addLast(n);
                n.posList = list.size() - 1;
            if (!n.feuille) {
                buffList.addLast(((NoeudInterne) n).filsDroit);
                buffList.addLast(((NoeudInterne) n).filsGauche);
            }
        }
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
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
public class AHAD extends AHA{
    Arbre currentN = aha;
    Feuille currentF = null; // PASSER à arbre!!!!
    // fonction à revoir!!
    
    int recupChar = 7;//On le met a 7 par défaut car au début c'est forcément 
    String buffChar = ""; //WTF: utilise vrai buff non?
    
    // NO COMPPRENDO
    public void decode(int bit, BufferedOutputStream ecriture) throws IOException {
    	//TODO: retourne le code, l'éciture doit se faire pas le code appelant
        if(recupChar == 0){
            if(this.naviguerAHA(bit) == null){
                //Rien on a déja naviguer dans l'arbre et mis a jour la position courante du curseur dans l'arbre
            }else{
                char c = currentF.lettre;
                if(this.isSpecial(currentF)){
                    //On recupere les 8 prochaint bit
                    recupChar = 8; //HERE
                }else{
                    System.out.println("J'écris 1: "+currentF.lettre);
                    ecriture.write(currentF.lettre);
                    this.modificationAHA(currentF.lettre);
                    currentN=aha;
                    
                }
                
            }
        }else{
            recupChar --;
            buffChar += bit;
            if(recupChar == 0){
                System.out.println("J'écris 2: " + (char)Integer.parseInt(buffChar, 2));
                ecriture.write((char)Integer.parseInt(buffChar, 2));
                this.modificationAHA((char)Integer.parseInt(buffChar, 2));
                currentN=aha;
                buffChar = "";
            }
        }
    }
    
    private Object naviguerAHA(int bit) {
        if(bit == 0){
            if(((NoeudInterne)currentN).filsGauche instanceof Feuille){
                this.currentF = (Feuille) ((NoeudInterne)currentN).filsGauche;
                return this.currentF;
            }else{
                this.currentN = ((NoeudInterne)currentN).filsGauche;
            }
        }else{
            if(((NoeudInterne)currentN).filsDroit instanceof Feuille){
                this.currentF = (Feuille) ((NoeudInterne)currentN).filsDroit;
                return this.currentF;
            }else{
                this.currentN = ((NoeudInterne)currentN).filsDroit;
            }
            
        }
        return null;
        
    }
    
    private boolean isSpecial(Feuille f) {
        return f == special;
    }
}

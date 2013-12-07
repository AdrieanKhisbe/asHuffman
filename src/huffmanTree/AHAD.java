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
    NoeudInterne currentN = null;
    Feuille currentF = null;
    int recupChar = 0;
    String buffChar = "";
    
    public void decode(int bit, BufferedOutputStream ecriture) throws IOException {
        if(recupChar == 0){
            if(this.naviguerAHA(bit) == null){
                //Rien on a déja naviguer dans l'arbre et mis a jour la position courante du curseur dans l'arbre
            }else{
                char c = currentF.lettre;
                if(this.isSpecial(c)){
                    //On recupere les 8 prochaint bit
                    recupChar = 8;
                }else{
                    ecriture.write(currentF.lettre);
                    this.modificationAHA(currentF.lettre);
                }
                
            }
        }else{
            recupChar --;
            buffChar += bit;
            if(recupChar == 0){
                ecriture.write((char)Integer.parseInt(buffChar, 2));
                buffChar = "";
            }
        }
    }
    
    private Object naviguerAHA(int bit) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private boolean isSpecial(char c) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}

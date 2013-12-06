/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package huffmanTree;

import core.BitOutputStream;
import java.io.IOException;
import java.util.BitSet;

/**
 *
 * @author Steph
 */
public class AHAC extends AHA{
    
    public AHAC(){
        
    }
    
    public void encode(char c,BitOutputStream ecriture) throws IOException{
        
        if(this.charIsPresent(c)){
            BitSet buff = this.getCodeChar(c);
            this.ecrirBitSetFlux(buff, ecriture);
        }else{
            BitSet buff = this.getCodeSpecialChar(c);
            this.ecrirBitSetFlux(buff, ecriture);
            this.ecrirCharFlux(c, ecriture);
            
        }
        this.modificationAHA(c);
        
    }
    
    public void ecrirBitSetFlux(BitSet b,BitOutputStream flux) throws IOException{
        for(int i = 0 ; i< b.length();i++){
            if(b.get(i)){
                flux.writeBit(1);
            }else{
                flux.writeBit(0);
            }
        }
    }
    
    public void ecrirCharFlux(char c,BitOutputStream flux) throws IOException{
        String buff = Integer.toBinaryString((int)c);
        for(int i = 0 ; i< buff.length();i++){
            flux.writeBit(buff.charAt(Character.getNumericValue(i)));
        }
    }
}

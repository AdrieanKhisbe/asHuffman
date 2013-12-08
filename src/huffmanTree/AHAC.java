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
            String buff = this.getCodeChar(c);
            this.ecrirBitSetFlux(buff, ecriture);
        }else{
            String buff = this.getCodeSpecialChar();
            this.ecrirBitSetFlux(buff, ecriture);
            this.ecrirCharFlux(c, ecriture);
            
        }
        this.modificationAHA(c);
    }
    
    public void ecrirBitSetFlux(String s,BitOutputStream flux) throws IOException{
        System.out.println("J'ecirs les bits : "+s);
        for(int i = 0 ; i< s.length();i++){
            flux.writeBit(Character.getNumericValue(s.charAt(i)));
        }
    }
    
    public void ecrirCharFlux(char c,BitOutputStream flux) throws IOException{
        String buff = Integer.toBinaryString((int)c);
        System.out.println("J'ecris en assci le char : "+c);
        for(int i = 0 ; i< buff.length();i++){
            flux.writeBit(Character.getNumericValue(buff.charAt(i)));
        }
    }
}

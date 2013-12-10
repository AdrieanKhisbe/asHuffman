/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package huffmanTree;

import core.BitOutputStream;
import java.io.IOException;
import java.util.BitSet;
import tools.Stats;

/**
 * 
 * @author Steph
 */
public class AHAC extends AHA {

	public AHAC() {

	}

	public void encode(char c, BitOutputStream ecriture) throws IOException {

		if (this.charIsPresent(c)) {
			String buff = this.getCodeChar(c);
			this.ecrireBitSetFlux(buff, ecriture);
		} else {
			String buff = this.getCodeSpecialChar();
			this.ecrireBitSetFlux(buff, ecriture);
			this.ecrireCharFlux(c, ecriture);

		}
		this.modificationAHA(c);
	}

	public void ecrireBitSetFlux(String s, BitOutputStream flux)
			throws IOException {
		Stats.printCharIOC("Ecriture des bits : '" + s + "'");
		for (int i = 0; i < s.length(); i++) {
			flux.writeBit(Character.getNumericValue(s.charAt(i)));
		}
	}

	public void ecrireCharFlux(char c, BitOutputStream flux) throws IOException {
	
		String buff = Integer.toBinaryString((int) c);
		Stats.printCharIOC("Ecriture du caractère ascii : '" + c + "'");
		int tmp = 0;
		if(buff.length()>8){
			tmp = 8;
		}else{
			tmp = buff.length();
		}
		
		for(int j = tmp ; j< 8; j++){ //HERE
			flux.writeBit(0);
		}
		
		//int j =  (buff.length()> 8) ? buff.length() :8;
				
				
		for (int i = 0; i<tmp; i++) { 
			flux.writeBit(Character.getNumericValue(buff.charAt(i)));
		}
	}
}

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
		System.out.println("Ecriture des bits : '" + s + "'");
		for (int i = 0; i < s.length(); i++) {
			flux.writeBit(Character.getNumericValue(s.charAt(i)));
		}
	}

	public void ecrireCharFlux(char c, BitOutputStream flux) throws IOException {
	
		String buff = Integer.toBinaryString((int) c);
		System.out.println("Ecriture du caractère ascii : '" + c + "'");
		
		for(int j = buff.length(); j< 8; j++){
			flux.writeBit(0);
		}
		
		
		for (int i = 0; i < buff.length(); i++) { // HERE
			flux.writeBit(Character.getNumericValue(buff.charAt(i)));
		}
		//Ecrire avant lecriture du char ascii
//		while (i < 8) {
//			flux.writeBit(0);
//			i++;
//		}
		// BUG
		// SEE writeChar aurait il pas suffit?
	}
}

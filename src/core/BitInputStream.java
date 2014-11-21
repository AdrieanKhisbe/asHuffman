package core;

import java.io.*;

/**
 * Classe permettant la lecture dans un flot bit à bit
 * 
 * récupérée depuis  http://www.developpez.net/forums/d25403/java/general-java/apis/io/ecriture-d-seul-bit-fichier/
 * 
 * @author Forax the best of us
 * @version 1.0
 */
public class BitInputStream extends FilterInputStream {
	int bits;
	int mask;

	public BitInputStream(InputStream in) {
		super(in);
	}

	/**
	 * Reads the next bit from this input stream. The value is returned as an
	 * int in the range 0 to 1. If no bit is available because the end of the
	 * stream has been reached, the value -1 is returned. This method blocks
	 * until input data is available, the end of the stream is detected, or an
	 * exception is thrown.
	 */
	public int readBit() throws IOException {
		int bits;
		int mask = this.mask;

		if (mask == 0) {
			bits = read();
			if (bits == -1)
				return -1;

			this.bits = bits;
			mask = 0x80;
		} else {
			bits = this.bits;
		}

		if ((bits & mask) == 0) {
			this.mask = mask >> 1;
			return 0;
		} else {
			this.mask = mask >> 1;
			return 1;
		}
	}

}
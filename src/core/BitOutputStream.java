package core;
import java.io.*;

/**
 * 
 * 
 * Classe permettant l'écriture dans un flot bit à bit
 * 
 * récupérée depuis  http://www.developpez.net/forums/d25403/java/general-java/apis/io/ecriture-d-seul-bit-fichier/
 * 
 * 
 * @author Forax the best of us
 * @version 1.0
 */
public class BitOutputStream extends FilterOutputStream {
    int bits;
    int offset;
    
    public BitOutputStream(OutputStream out) {
        super(out);
    }
    /**
     * Writes the specified bit to this output stream.
     * @param bit - the bit
     */
    public void writeBit(int bit) throws IOException {
        if (bit==0) {
            bits<<=1;
        }
        else {
            bits=bits<<1|1;
        }
        offset++;
        if (offset==8) {
            write(bits);
            bits=0;
            offset=0;
        }
    }
    
    /** flush the output stream.
     */
    public void flush() throws IOException {
        if (offset!=0) {
            write(bits<<(8-offset));
            offset=0;
        }
        super.flush();
    }
    /** close  the output stream.
     */
    public void close() throws IOException {
        flush();
        super.close();
    }
}
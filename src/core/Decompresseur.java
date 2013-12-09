package core;


import huffmanTree.AHAD;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Decompresseur {
    private String nomFichierI = "";
    private String nomFichierO = "";
    private BufferedOutputStream outS;
    private BitInputStream inS;
    private AHAD struct  = null;
    
    public Decompresseur(String nomI,String nomO){
        this.nomFichierI = nomI;
        this.nomFichierO = nomO;
        this.struct = new AHAD();
    }
    
    
    public void decompression() throws IOException{
        // ouverture du flux d'écriture du ficher decompresser
        this.outS = new BufferedOutputStream(new FileOutputStream (this.nomFichierO));
        
        
        // ouverture du flux de lecture du fichier a decompresser
        this.inS = new BitInputStream(new BufferedInputStream( new FileInputStream(this.nomFichierI)));
        
        //On parcourt tous les characteres du text a comrpesser
        int bit = this.inS.readBit();
        while ( bit != -1)
        {
            
            struct.decode(bit, this.outS);
            System.out.println(bit);
            bit = this.inS.readBit();
        }
        
        this.outS.close(); // fermeture du flux
        this.inS.close(); // fermeture du flux
    }

}
package core;


import huffmanTree.AHAC;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class Compresseur {
    private String nomFichierI = "";
    private String nomFichierO = "";
    private BufferedOutputStream outS;
    private BufferedInputStream inS;
    private AHAC struct  = null;
    private char specialChar = '#';
    
    public Compresseur(String nomI,String nomO){
        this.nomFichierI = nomI;
        this.nomFichierO = nomO;
        this.struct = new AHAC();
    }
    
    public Compresseur(String nomO){
        this("",nomO);
    }
    
    
    public void compression() throws IOException{
        // ouverture du flux d'écriture du ficher compresser
        this.outS = new BufferedOutputStream(new FileOutputStream (this.nomFichierO));
        BitOutputStream ecriture = new BitOutputStream(this.outS);
        
        
        // ouverture du flux de lecture du fichier a compresser
        BufferedReader reader = null;
        reader = new BufferedReader( new FileReader(this.nomFichierI));
        
        //On parcourt tous les characteres du text a comrpesser
        String ligne = reader.readLine();
        while (ligne!=null)
        {
            //POur chaue caractere on fait le traitement adéquoite
            for(int i = 0; i<ligne.length() ;i++){
                char c = ligne.charAt(i);
                struct.encode(c, ecriture);
                
            }
            ligne = reader.readLine();
        }
        
        this.outS.close(); // fermeture du flux
        this.inS.close(); // fermeture du flux
    }

}


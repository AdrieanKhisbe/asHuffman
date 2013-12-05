package core;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Compresseur {
    private String nomFichierI = "";
    private String nomFichierO = "";
    private DataOutputStream outS;
    private DataInputStream inS;
    
    public Compresseur(String nomI,String nomO){
        this.nomFichierI = nomI;
        this.nomFichierO = nomO;
    }
    
    public Compresseur(String nomO){
        this("",nomO);
    }
    
    
    public String encodage(char c){
        return Integer.toBinaryString((int)c);
    }
    
    
    
    /*
     * Fonction de compression principal
     * 
     * 
     * public void compression(){
     * J'ouvre un flux de fichié pour ecrire le texte compressé
     * J'ouvre un flux de fichier lire le text a compressé
     * 
     * tant que je suis pas a la fin de mon fichier de lecteur
     * 
     * si le char est dans ma structur
     * je cherche le code de mon char dans ma structure
     * jecrit le code de ma structuure dans le fichier
     * jincrimente ma structure de 1
     * je met a jour la structure
     * 
     * sinon
     * jecris le caracterespécial #
     * jecris mon charctere en ascii
     * je rajoute mon caractere dan ma structure
     * 
     * je ferme le flux de fichier 
     * 
     * j'envoie un ptit message comme quoi j'ai fini avec le chemin du fichier :)
     * 
     * }
     */
    
    
    
    /*
     * Exemple d'utilisation de lecture et d'écriture d'un bit
     */
    public void creerFichierBinaire() throws IOException
    {
        // ouverture du flux
        this.outS = new DataOutputStream( new FileOutputStream( this.nomFichierO) );
        BitOutputStream test = new BitOutputStream(this.outS);  
        test.writeBit(1);
        test.flush();
        test.close();
        
        this.outS.close(); // fermeture du flux
    }
    
     public void lireFichierBinaire() throws IOException
    {
        // ouverture du flux
        this.inS = new DataInputStream( new FileInputStream("fichier_binaire.dat") );
        BitInputStream test = new BitInputStream(this.inS);  
        int bit = test.readBit();
        test.close();
        
        this.inS.close(); // fermeture du flux
    }
    
}


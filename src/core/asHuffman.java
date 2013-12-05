package core;

import com.beust.jcommander.JCommander;
import java.io.IOException;
import java.util.List;

public class asHuffman {
    
    
    public static void main(String[] args) throws IOException {
        JCommanderTest jct = new JCommanderTest();
        JCommander jCommander = null;
        String[] argv = { "-arg", "1", "test" ,"test" };
        
        try{
            jCommander = new JCommander(jct, argv);
        }catch(com.beust.jcommander.ParameterException e){
            System.out.println(e);
            String[] ex = { "-arg", "1", "test"};
            JCommander exe =new JCommander(jct, ex);
            exe.usage();
        }
        
        /*
        Compresseur c = new Compresseur("fichier_binaire.dat","fichier_binaire.dat");
        c.creerFichierBinaire();
        c.lireFichierBinaire();
        * */
        
        
        
        switch(jct.getOpt()){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            default :
                System.out.println("Mauvais numéro utilisé en argument \"arg\"");
                jCommander.usage();
                break;
        }
        
        
    }
    
    //TODO: faire aussi deux main sans options.
    // appeleront juste de manière statique le bon truc

}

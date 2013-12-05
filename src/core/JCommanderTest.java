package core;

import com.beust.jcommander.Parameter;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Steph
 */
public class JCommanderTest {
    
    @Parameter(description = "Files_name", arity = 2)
    private List<String> files_name = new ArrayList<String>();

   @Parameter(names = "-arg", description = "1 Compression du fichier1 vers le fichier2. ex "
           + " : -arg 1 fichier1 fichier2 \n 2 Décompression du fichier1 vers le fichier2."
           + " ex : -arg 2 fichier1 fichier2 \n 3 Compresse le text tapez à l'aide du "
           + "clavier est directement compressé dans le fichier. ex  : -arg 3 fichier", required = true)
    private Integer arg;

   public List<String> getFileN(){
        return files_name;
       
   }
       
   public Integer getOpt(){
       return arg;
   }
}

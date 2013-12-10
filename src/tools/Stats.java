/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

/**
 *
 * @author Steph
 */
public class Stats {
    public static int nbCharDiff = 0;
    public static int nbTotalChar = 0;
    public static int nbSwap = 0;
    public static int nbMajList = 0; //-> O(n*n);
    public static long tempsAvant = 0;
    public static long tempsApres = 0;
    
    public static boolean printIOD = false;
    public static boolean printIOC = false;
    public static boolean printStats = false;
    public static boolean printTemps = true;
    public static boolean printDebug = false;
    
    public static void switchTprintStats(){
        printStats = true;
    }
    public static void switchFprintStats(){
        printStats = false;
    }
    public static void switchTprintTempsD(){
        printTemps = true;
    }
    public static void switchFprintTempsD(){
        printTemps = false;
    }

    public static void switchTprintIOC(){
        printIOC = true;
    }
    public static void switchFprintIOC(){
        printIOC = false;
    }
    public static void switchTprintIOD(){
        printIOD = true;
    }
    public static void switchFprintIOD(){
        printIOD = false;
    }
    public static void switchTprintDebug(){
        printDebug = true;
    }
    public static void switchFprintDebug(){
        printDebug = false;
    }
    
    
    
    public static void printStats(){
        if(printStats){
            System.out.println("Nombre de caractere different : "+Stats.nbCharDiff);
            System.out.println("Nombre de caractere Total : "+Stats.nbTotalChar);
            System.out.println("Nombre de Swap: "+Stats.nbSwap);
            System.out.println("Nombre de Maj ordre de la liste : "+Stats.nbMajList);
            resetStats();
        }
    }
    
    public static void resetStats(){
        nbCharDiff = 0;
        nbTotalChar = 0;
        nbSwap = 0;
        nbMajList = 0; //-> O(n*n);
    }
    
    public static void lanceChrono(){
        tempsAvant = System.currentTimeMillis();
    }
    
    public static void stopChrono(){
        tempsApres = System.currentTimeMillis();
    }
    
    public static void printChrono(String s){
        if(printTemps){
            System.out.println("Temps de "+s+" : "+((float) (tempsApres - tempsAvant)) / 1000f+" sec");
        }
    }
    
    public static void printCharIOC(String s){
        if(printIOC){
            System.out.println(s);
        }
    }
    
    public static void printCharIOD(String s){
        if(printIOD){
            System.out.println(s);
        }
    }
    
    public static void printDebug(String s){
        if(printDebug){
            System.out.println(s);
        }
    }
}

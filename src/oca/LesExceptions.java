package oca;

import java.io.File;

public class LesExceptions {

    public static void main(String[] args) {
        System.out.println("Debut");
        Integer r = calcul(10, 0);
        System.out.println(r==null ? "calcul pas possible": r);
        Long l= Parser("kjj");
         System.out.println(l==null ? "Parser pas possible": l);
         try{
            l= ParserBeurk("kjj");
             System.out.println(l);
         }
          catch(NumberFormatException nfe){
              System.out.println("ParserBeurk pas possible");
         }
         
         
        System.out.println("Fin");
        
       
    }

    
    static Integer calcul(int i, int j) {   
        if(j!=0)
            return i/j;
        return null;
    }
//    static void CreerFichier() {   
//         File.createTempFile("tempo", "titi");
//    }
     static Long Parser(String texte){
         try{
            Long id = Long.parseLong(texte);//"-1_0L"
            return id; 
         }
         catch(NumberFormatException nfe){
             return null;
         }
     }
     static Long ParserBeurk(String texte){
        Long id = Long.parseLong(texte);//"-1_0L"
        return id; 
         
     }
}

package oca;


public class Constructeurs {
    
    public static void main(String[] args) {
        
       //Gateau g1 =  new Gateau();
       //Gateau g2 = new Gateau("cake");
       MilleFeuilles mf = new MilleFeuilles();
       System.out.println(mf.nom);
       System.out.println(mf.nbFeuilles);
       MilleFeuilles mf2 = new MilleFeuilles("500-feuilles", 500);
       System.out.println(mf2.nom);
       System.out.println(mf2.nbFeuilles);
       
       ForetNoire fno = ForetNoire.Create();
       
       new K();
    }
}


abstract class Gateau{
    String nom;
    
     Gateau(String nom){
         this.nom=nom;
     }
}

class MilleFeuilles extends Gateau{
    int nbFeuilles;
    
    MilleFeuilles(){
//      super("Mille-Feuilles");
//      nbFeuilles=1000;
        this("Mille-Feuilles", 1000);
        System.out.println("Mille-Feuilles construit");
    }
    MilleFeuilles(String nom, int nbFeuilles){
        super(nom);
        this.nbFeuilles=nbFeuilles;
     }
}

class Baba extends Gateau{
    String alcool;
    
    Baba(){
        this("baba","rhum");
    }
    Baba(String nom, String alcool){
        super(nom);
        this.alcool=alcool;
    }
}

class ForetNoire extends Gateau{
    String[] ingredients;
    
    private ForetNoire(String nom, String[] ingredients){
        super(nom);
        this.ingredients=ingredients;
    }
    
    private static ForetNoire fnoire;
    
    static ForetNoire Create(){
        if(fnoire == null)
            fnoire= new ForetNoire("ForetNoire", new String[]{"chocoloat", "creme","beurre"});
        return fnoire;
    }
    
}


class J{
    int ij;
    static int sij;
    J(){
        ij+=10;
        System.out.println("J construit");
    }
    
    {
        ij=5;
        System.out.println("J initialisé");
    }

}

class K extends J{
     {
         int z=6;
        System.out.println("K initialisé en 1er");
    }
    
    K(){
         System.out.println("K construit");
    }
    {
        int z = 8;
        System.out.println("K initialisé en 2eme");
    }
}




class L extends K{
    
    
    
    
}
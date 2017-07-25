
package oca;

 enum Day{
    Lundi, Mardi, Mercredi, Jeudi
}

interface Translatable{
    String getEnglish();
}

enum Jour implements Translatable{
    Lundi(1,"Monday"), Mardi(2,"Tuesday"), Mercredi(3,"Wednesday"), Jeudi(4, "Thursday");
    private final int valeur; private final String english;
    private Jour(final int valeur,final String english) {
        this.valeur = valeur; this.english = english;
    }

    public int getValeur() {
        return valeur;
    }

    public String getEnglish() {
        return english;
    }
}

public class Enumerations {
    public static void main(String[] args) {
        
        Jour j;
        j = Jour.Lundi;
        System.out.println(j.ordinal()); 
        for (Jour d : Jour.values()) {
            System.out.println(d.name());
        }
        j = Jour.valueOf("Jeudi");
        System.out.println(j.getValeur());
        switch(j){
            case Lundi:
                System.out.println("dur " + Jour.Lundi.getEnglish());
                break;
            case Mardi:
                System.out.println("moins dur "+ Jour.Mardi.getEnglish());
                break;
            case Mercredi:  case Jeudi:
                System.out.println("on est habitué");
                break;
        }
        System.out.println(j==Jour.Mardi);
        Test(Jour.Mercredi);
        
        T t = new T(25);
        //Translatable tr = (Translatable)t;//illegal car T final
        //t.CI=10;//illegal car CI final
        final int zu;
        zu=12;
        final Ours leo = new Ours(zu, 10, "nounours");
        leo.nom="grizzou";
         
    }
    
    static void Test(Jour j){
        System.out.println(j.getEnglish());
    }
    static void Test(Translatable j){
        System.out.println(j.getEnglish());
    }
    
    static void Test(final int io){
        //io=10;
    }
}


final class T{
    final int CI;
    final int DI=20;
    {
        CI=20;
    }
    final int EI;
    T(int z){
            EI=z;
    }
    T(){
        this(20);
    }
    final static int SCI;
    
    static {
        SCI = 36;
    }
    final static int SDI=36+(int)Math.PI;
    
   
    byte b = SDI;
    
    
}

class U {
   final Number Affiche(int i){
        return i;
    }
   final void z(Number n){
       
   }
   final static void DoIt(){
        
    }
   
}

class UV extends U{
//    Float Affiche(int i){illegal cannot override
//        
//    }
//    final static void DoIt(){ illegal cannot hide
//        
//    }
    Integer Affiche(int... i){
        return i[0];
    }
    void z(Integer n){
       
   }
    
    
}


//class U extends T{
//    
//}

//final interface R{
//    
//}






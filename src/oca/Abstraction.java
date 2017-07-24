

package oca;


public class Abstraction {
    
    public static void main(String[] args) {
        
        Carnivore  leo = new Lion();
        System.out.println( leo.getNom()  );
        Dangereux lea = new Lion();
        System.out.println( ((Lion)lea).getNom()  );
        System.out.println( ((Carnivore)lea).getNom()  );
        System.out.println( ((Animal)lea).getNom()  );
        Animal lei = new Lion();   
        //leo = lea
        //leo = lei;   illegal
        leo = (Carnivore)lei;
        lei = leo; 
        //lea = lei illegal
        //lei = lea illegal
        lei = (Animal)lea;
        lea = (Dangereux)lei;
        
        //Solitaire h =(Solitaire)lei;//Legal!! mais crashe
        
        Dangereux[] dxt = { new Lion(), new Rhinoceros(), null, new Plante()};//, (Dangereux)new Gazelle()}; //legal mais plante
        for (Dangereux dx : dxt) {
            
            System.out.print(dx+ " - danger=");
            System.out.print (dx!=null ? dx.getNiveauDanger(): 0);
            if(!(dx instanceof Animal))
                System.out.println(" nullissime");
            else
                System.out.println(" "+((Animal)dx).getNom());
        }
        //float[] tf= new int[]{} illegal
        //Integer[] tf= new int[]{} illegal
        Object tf= new int[]{};
        Number[] tn = new Integer[]{};
        Integer[] tni = new Integer[]{5,4};
        Number[] tnn = tni;
        Animal aa = (Animal)dxt[0];
     // Animal[] tdx = (Animal[]) dxt;//legal mais crashe!
        for (int i = 0; i < dxt.length; i++) {
            if(dxt[i] !=null){
                System.out.print("Danger = "+dxt[i].getNiveauDanger());
            }
            if(dxt[i] instanceof Animal){
                Animal aia = (Animal)dxt[i];
                System.out.println(" "+aia.getNom());
            }
            else{
                System.out.println(" pas un animal");
            }
        }
        Nommable n = new Nommable() {
            @Override
            public String getNom() {
                return "anonyme";
            }
        };
    }
    
    
}

interface Nommable{
    public abstract String getNom();
}

abstract class Animal implements Nommable{
    
}

class MangeurDeViande extends Animal{
    @Override
    public String getNom() {
        return "Viandard";
    }   
} 

abstract class Carnivore extends MangeurDeViande{
    abstract int getKgViandeParJour();
}

interface Dangereux{
    int MAXDANGER = 10;
    int MINDANGER = 0;
    int getNiveauDanger();
}

interface Solitaire{
    default int NombreDAmis(){
      return 0;
  }
}

interface DangereuxSolitaire extends Dangereux, Solitaire{
     @Override
     default int getNiveauDanger(){
        return MAXDANGER;
    }
     @Override
     abstract int NombreDAmis();
}
class Plante implements Dangereux{

    @Override
    public int getNiveauDanger() {
        return 1;
    }

}
class Lion extends Carnivore implements Dangereux{   
    @Override
    public int getNiveauDanger() {
        return 6;
    }

    @Override
    public String getNom() {
        return "Lion";
    }

    @Override
    int getKgViandeParJour() {
        return 6;
    }
}

class Buffle extends Herbivore implements Dangereux{

    @Override
    public String getNom() {
        return "Buffle";
     }

    @Override
    public int getNiveauDanger() {
        return 5;
    }
    
}
abstract class Herbivore  extends Animal{
    
}
class Gazelle extends Herbivore{ 

    @Override
    public String getNom() {
        return "Gazelle";
    }
}

class Rhinoceros extends Herbivore implements DangereuxSolitaire{
    @Override
    public int getNiveauDanger() {
        return 8;
    }

    @Override
    public String getNom() {
        return "Rhino";
    }

    @Override
    public int NombreDAmis() {
        return 1;
    }
}


interface A{
    void M();
}
interface B{
     void M();
}
interface A1{
    default void M(){   
     }
}
interface B1{
    default void M(){         
     }
}

class C implements A, B{
    @Override
    public void M() {        
    }
}
class D implements A1, B{
    @Override
    public void M() {
    }
}

//class E implements A1, B1{ illegal
//
//}

class F implements A1, B1{ 
    @Override
    public void M() { //obligatoire
        }
}
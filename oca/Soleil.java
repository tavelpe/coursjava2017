
package oca;


public class Soleil {
    
    public static void main(String[] args) {
        Valeur val = new Valeur();
                
        Compteur c1 = new Compteur(val);
        Compteur c2 = new Compteur(val);
        Compteur c3 = new Compteur(val);
        Compteur c4 = new Compteur(val);
        System.out.println(val.v);
        new Incrementeur();new Incrementeur();new Incrementeur();new Incrementeur();
        System.out.println(Incrementeur.valeur);
        
        
    }
    
}

class Valeur{
    int v;
}

class Compteur{
    Compteur( Valeur valeur){
        System.out.println("Construction de Compteur");
        valeur.v++;
    }
}

class Incrementeur{
    static int valeur;
    Incrementeur(){
        valeur++;
    }
    
}
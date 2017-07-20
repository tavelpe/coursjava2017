
package oca;


public class Soleil {
    static X x = new X();
    
    public static void main(String[] args) {
        Valeur val = new Valeur();
                
        Compteur c1 = new Compteur(val);
        Compteur c2 = new Compteur(val);
        Compteur c3 = new Compteur(val);
        Compteur c4 = new Compteur(val);
        System.out.println(val.v);
        new Incrementeur();new Incrementeur();new Incrementeur();
        Incrementeur ic = new Incrementeur();
        System.out.println(Incrementeur.getValeur());
        System.out.println(ic.getValeur());
        System.out.println(ic.valeur);
        //System.out.println(Incrementeur.valeurInitiale);//illegal
        System.out.println(ic.getValeurInitiale());
        System.out.println("---------------------------------------");
        W.iw = 10;
        X.iw = 11;
        System.out.println(new W().getIw()); //10
        System.out.println(new X().getIw()); //11
        
        W wx = new X();
        W ww = null;
        System.out.println(wx.getIw());//10
        System.out.println(ww.getIw());//10 
        System.out.println(((X)ww).getIw());//11
        //System.out.println(((V)wx).getIw()); illegal
        System.out.println(V.getIw());//19
        System.out.println(wx.getInsw());//10
        Soleil[] ts = {new Soleil(), new Soleil()};
        ts=null;
        System.out.println( Soleil.x==null);
        
    }
}
interface V{
   int v=9;
   public static int getIw(){  return W.iw +v;   }
}

class W {
    static int iw;
    public static int getIw() { return iw;  }
    public int getInsw() { return iw; }
}

class X extends W{
    static int iw;
     public static int getIw() {   return iw;  }
}


class Incrementeur{
     static int valeur;
     int valeurInitiale;

    public int getValeurInitiale() {
        if(valeur==valeurInitiale)
            System.out.println("dernier");
        return valeurInitiale;
    }

    static int getValeur() {
//        if(valeur!=this.valeurInitiale)
//            System.out.println("....");
        return valeur;
    }
    Incrementeur(){
        valeur++;
        valeurInitiale=valeur;
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

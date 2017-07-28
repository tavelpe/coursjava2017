package oca;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class LesGeneriques {
    
    public static void main(String[] args) {
        Famille<Lion> fl = new Famille<>();
        Famille lions = fl; //dangereux!
        Famille<Object> lions2 = lions; //dangereux!
        // lions.enfants[0]="portenawak"; //consequence de dangereux!
       // Famille<Object> lions2 = fl;//illegal
       //fl.get1erParent().getNom();
       
        ATrier<String> as = new ATrier<>();
        as.tableaudeT= new String[]{"b", "a"};
        as.trier();
        System.out.println(Arrays.toString(as.tableaudeT));
        //ATrier<Lion> ao = new ATrier<>(); //illegal car Lion n'est pas Comparable
        List<Integer> li = new ArrayList<>();
        li.add(10);li.add(20);li.add(30);
        Affiche2(li);
        System.out.println(Somme(li));
        //System.out.println(Somme2(li));? super Number 
        List<Number> ln = new ArrayList<>();
         ln.add(10);ln.add(20);ln.add(30);
         System.out.println(Somme2(ln));
         
    }
    
    static <TT> void Affiche(List<TT> laliste){
        TT t2 = null;
        laliste.add(t2);
        for (TT t : laliste) {
            System.out.println(t);
        }
        laliste.remove(null);
        laliste.remove("portenawak");
    }
    
    static void Affiche2(List<?> laliste){
      //laliste.add(new Object());//illegal
      //laliste.add("portenawak");//illegal
      for (Object t : laliste) {
          System.out.println(t);
      }
      laliste.remove((Integer)10);
      laliste.remove("portenawak");
  }
    static double Somme(List<? extends Number> laliste){
      //laliste.add(new Double(15D));//illegal
      //laliste.add("portenawak");//illegal
      double d =0;
      for (Number t : laliste) {
          d+=t.doubleValue();
      }
      return d;
  }
  static double Somme2(List<? super Number> laliste){
      laliste.add(new Double(15D));
      laliste.add(new Integer(15));
      //laliste.add(new Object());//illegal
      //laliste.add("portenawak");//illegal
      double d =0;
      for (Object t : laliste) {
          if(t instanceof Number)
            d+=((Number)t).doubleValue();
      }
      return d;
  }  
    
    
//    static void Test(Famille<Integer> f){
//        
//    }
//    static void Test(Famille<String> f){
//        
//    }
}

interface Groupe<T>{
    T getPremier();
}

class NG implements Groupe<String>{
    @Override
    public String getPremier() {
        return "Premier";
    }
}
class Famille<TT> implements Groupe<TT>{
    TT[] parents;
    TT[] enfants;
    TT get1erParent(){
        return parents[0];
    }
    void set1erParent(TT t) {
        parents[0] = t;
    }

    public Famille(TT[] parents, TT[] enfants) {
        this.parents = parents;
        this.enfants = enfants;
    }
    
    Famille(){   
    }

    @Override
    public TT getPremier() {
        return get1erParent(); 
    }
}

class ATrier<TT extends Comparable<TT> & Serializable>{
    TT[] tableaudeT;
    Class<TT> ct;
    void trier(){
        try {
            //tableaudeT[0]= new T();//illegal
            if(tableaudeT[0]==null)
                tableaudeT[0]= ct.newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            System.out.println(ex);
        }
        System.out.println(tableaudeT[0].compareTo(tableaudeT[1])); 
        Arrays.sort(tableaudeT);
    }
    
    
} 

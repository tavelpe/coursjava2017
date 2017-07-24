package oca;

import java.util.Objects;


public class LesObjets {
    public static void main(String[] args) {
               
        new ClientParticulier().Affiche();
        ClientParticulier cp = new ClientParticulier();
        //cp.nom = "Dupont";
        cp.setNom("Dupont");
        cp.setAge(45);
        cp.Affiche();
        
        ClientTresParticulier bob = new ClientTresParticulier();
        bob.setNom("bob"); bob.setAge(20);
        ClientParticulier tim = new ClientTresParticulier();
        tim.setNom("tim"); tim.setAge(21);
        System.out.println(bob.isActionnaire());
        if(tim instanceof ClientTresParticulier)
            System.out.println( ((ClientTresParticulier)tim).isActionnaire());
        System.out.println(bob.getAge());System.out.println(bob.isAdult());
        System.out.println(tim.getAge());System.out.println(tim.isAdult());//polymorphisme
        bob.nom="bobby";//ClientTresParticulier
        tim.nom="timmy";//ClientParticulier
        System.out.println(bob.getNom());//bob
        System.out.println(tim.getNom());//timmy
        System.out.println(bob.nom);//bobby
        System.out.println(((ClientTresParticulier)tim).nom);//null!!!
        
        Class c = tim.getClass();
        System.out.println(c == ClientTresParticulier.class);
        System.out.println(c.getName());
        
        System.out.println(bob.toString());//je suis bob et j'ai 20 ans
        
         ClientParticulier alice = new ClientParticulier();
         ClientParticulier Alice = new ClientParticulier();
         alice.nom="alice";alice.age=10;
         Alice.nom="alice";Alice.age=10;
         System.out.println(alice==Alice);
         System.out.println(alice.equals(Alice));//ClientParticulier même nom et même âge 
         ClientTresParticulier bernard = new ClientTresParticulier();
         ClientParticulier Bernard = new ClientTresParticulier();
         bernard.setNom("bernard");bernard.age=20;
         Bernard.setNom("bernard");Bernard.age=20;
         System.out.println(bernard==Bernard);
         System.out.println(bernard.equals(Bernard));//ClientTresParticulier même nom et même âge 
        
         
        
        
    }

    private static void debut() {
       
        Object cpo = new ClientParticulier();
        //Integer oc = (Integer)cp;
        if(cpo instanceof Integer){
            Integer o = (Integer)cpo;
        }
        else
        {
            System.out.println("cpo n'est pas un Integer!!%");
        }
        
        Number n = new Integer(10);
        Object no = new Integer(8);
        Object noi = 12;
        if(n instanceof Float){
            Float f = (Float)n;
        }
        Integer io = (Integer)n;
        System.out.println( io.compareTo(io));
        if(no instanceof Integer){
            System.out.println(  ((Integer) no).compareTo(io));
        }
        if(noi instanceof Integer)
            System.out.println(   ((Integer) noi).compareTo(io));
    }
    
}

class ClientParticulier{
    String nom;
    int age;

    int getAge() {
        return age;
    }
    void setAge(int age) {
        if(age>0 && age<150)
            this.age = age;
    }

    void Affiche(){
        System.out.print(this.toString());
    }
    
    String getNom(){
        return nom;
    }
    void setNom(String nom){
        this.nom = nom;
    }
    
    boolean isAdult(){
        return age>=18;
    }

    @Override
    public String toString() {
        return String.format("je suis %s et j'ai %d an(s) \n",nom, age);
    }

    
    
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof ClientParticulier && obj.getClass() == this.getClass()){
            ClientParticulier cp = (ClientParticulier)obj;
            return cp.getAge()==getAge() && Objects.equals(getNom(), cp.getNom());
        }
        return false;
    }


  
    
    
}

class ClientTresParticulier extends ClientParticulier{
    
    boolean actionnaire;
    String nom;

    boolean isActionnaire() {
        return actionnaire;
    }

    void setActionnaire(boolean actionnaire) {
        this.actionnaire = actionnaire;
    }
    
    @Override
    boolean isAdult(){
        return age>25;
    }
}



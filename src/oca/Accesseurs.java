package oca;

import autre.Acces;


public class Accesseurs {
    
    public static void main(String[] args) {
        new Pack().MPack();
        new Pack().MProt();
    }
    
   
    
}

class Pack{
    
    public void MPack(){
        MPriv();
    }
    
    private void MPriv(){
        
    }
    
    protected void MProt(){
        
    }
    
}

class SousPack extends Pack{
    
    protected void MProt(){
        
    }
    
     public void MPack(){

    }
}

class SousAcces extends Acces{
    //@Override //illegal
    void AcPack(){
        
    }

    @Override
     protected void AcProt(){
        super.AcProt();
    }
    
     void Toto(){
         super.AcProt();
       //  new Acces().AcProt(); //illegal
     }
    
}
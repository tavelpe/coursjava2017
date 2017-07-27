package oca;

import java.util.*;


public class LesCollections {
    
    public static void main(String[] args) {
        
        ArrayList al = new ArrayList();
        al.add("A"); al.add(10);
        
        ArrayList<String> als = new ArrayList<>();
        als.add("A"); als.add("B");als.add(null);
        
        ArrayList al2 = als;
        al2.add(12);
        
        ArrayList<Object> alo = new ArrayList<>();
        //alo = als;
        
        System.out.println(als);
        //als.remove(2);
        als.remove(null);
        als.remove((Integer)12);
        System.out.println(als);
        
        System.out.println(als.size());
        als.ensureCapacity(20);
        
        System.out.println(als.get(0));
        //String[] ts = (String[])  als.toArray(); java.lang.ClassCastException
        String[] ts = als.toArray(new String[als.size()]);
        als.add(2, "C");
        System.out.println(als.contains("A")); 
        System.out.println(als.indexOf("A")); 
        String c=als.set(2, "D");
        System.out.println(als);
        
        List<String> ls2 = Arrays.asList("B", "A", "E", "F");
        //ls2.add(c); readonly
        //ls2.remove("F");readonly
        ArrayList<String> als2 = new ArrayList<>(ls2);
        als.addAll(als2);
        System.out.println(als);
        System.out.println(als2);
        //als.removeAll(als2); reste "D"
        //System.out.println(als);
        als.retainAll(als2); //supprime "D"
        System.out.println(als);
        
        List<String> asbl= als.subList(2, 5);
        System.out.println(asbl);
        asbl.remove("A");
        System.out.println(als);
        asbl.add("G"); 
        System.out.println(als);
        als.add("Z"); als.remove("A");
        asbl= als.subList(2, 5);
        System.out.println(als.remove("T"));
        System.out.println(asbl);//java.util.ConcurrentModificationException si non
        // re-init de sublist als.subList(...)
        
         Iterator<String> is= als.iterator();
         while(is.hasNext()){
             String s = is.next();
             System.out.println(s);
             if(s.equals("G"))
                 is.remove();
//             else
//                 als.add("W");java.util.ConcurrentModificationException
         }
          ListIterator<String> isl= als.listIterator();
           while(isl.hasNext()){
               System.out.println(isl.nextIndex()+" " + isl.next());
               if(isl.nextIndex()==3){
                   isl.add("W");
               }
               if(isl.nextIndex()==5){
                   isl.set("V");
               }
           }
        System.out.println("---retour---");
        while (isl.hasPrevious()) {
            System.out.println(isl.previousIndex()+" " + isl.previous());
        }
         
        
    }
    
}


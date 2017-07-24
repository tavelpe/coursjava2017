package oca;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class LesDates {
    
    public static void main(String[] args) {
        Date d = new Date();
        System.out.println(d);
        System.out.println(d.getTime());
        System.out.println(d.after(d));
        
        Calendar c = Calendar.getInstance();
        Calendar c2 = new GregorianCalendar();
        
        System.out.println( c2.get(Calendar.MONTH));
        
        
        
    }
    
}

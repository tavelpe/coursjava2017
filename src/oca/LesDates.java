package oca;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalQuery;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class LesDates {

    public static void main(String[] args) {

        Instant now = Instant.now(); //UTC
        System.out.println(now.getEpochSecond());
        System.out.println(now.getNano());
        System.out.println(now);
        now = now.plusSeconds(120);
        now = now.plus(4, ChronoUnit.DAYS);
        System.out.println(now);
        System.out.println(now.getLong(ChronoField.INSTANT_SECONDS));
        System.out.println(now.getLong(ChronoField.NANO_OF_SECOND));
        now = Instant.parse("2017-07-25T09:25:24.556Z");

        Instant now2 = Instant.ofEpochMilli(new Date().getTime());
        //now2= Instant.from( );

        Duration du = Duration.between(now2, now);
        du = du.plusDays(3);
        System.out.println(du);
        System.out.println(du.toDays());
        Instant plustard = (Instant) du.addTo(Instant.now());
        System.out.println(plustard);
        Instant maintenant = plustard.minus(du);
        System.out.println(maintenant.compareTo(Instant.now()));

        LocalDateTime today = LocalDateTime.now();
        System.out.println(today);
        System.out.println(today.getMonth());//Month : TemporalAccessor, TemporalAdjuster
        System.out.println(today.getMonth().getValue());
        today = today.plusMonths(2);
        System.out.println(today);
        System.out.println(today.withMonth(7).withYear(2018).withDayOfMonth(15));
        System.out.println(LocalDateTime.of(2017, Month.NOVEMBER, 11, 20, 20, 20));
        today = LocalDateTime.parse("2017-07-25T11:20:20");
        System.out.println(today);
        Instant i1 = today.toInstant(ZoneOffset.UTC);
        System.out.println(i1);
        LocalDateTime ldt = LocalDateTime.ofInstant(i1, ZoneOffset.UTC);
        System.out.println(ldt);
        Date dd = new Date(today.toEpochSecond(ZoneOffset.ofHours(2)) * 1000);
        System.out.println(dd);
        dd = new Date(i1.toEpochMilli() - 2 * 60 * 60 * 1000);
        System.out.println(dd);

        LocalDate auj = LocalDate.now();
        LocalDate auj2 = ldt.toLocalDate();
        auj2 = LocalDate.of(2018, Month.MARCH, 12);
        auj = LocalDate.parse("2018-05-09");
        System.out.println(auj.lengthOfMonth());
        LocalDateTime ldtt = auj.atStartOfDay();
        System.out.println(auj.withDayOfYear(365));

        LocalTime heure = LocalTime.now();
        System.out.println(heure);
        LocalTime heure2 = ldt.toLocalTime();
        heure2 = LocalTime.of(12, 02, 20);
        heure = LocalTime.parse("11:55:49");
        System.out.println(ChronoUnit.MINUTES.between(heure, heure2));
        System.out.println(heure.until(heure2, ChronoUnit.MINUTES));

        LocalDateTime ldtt2 = heure.atDate(LocalDate.now());
        System.out.println(ldtt2);

        Period p = Period.of(0, 2, 0);
        auj = LocalDate.now();
        auj = (LocalDate) p.addTo(auj);
        System.out.println(auj);
        System.out.println(LocalDate.now().compareTo(auj.minus(p)));
        System.out.println(p.get(ChronoUnit.DAYS)); // 0 jours
        System.out.println(LocalDate.now().until(auj, ChronoUnit.DAYS)); //62 jours

        System.out.println(LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.MONDAY)));
        System.out.println(LocalDate.now().with(TemporalAdjusters.nextOrSame(DayOfWeek.TUESDAY)));
        System.out.println(LocalDate.now().with(TemporalAdjusters.ofDateAdjuster(d -> d.plusDays(5))));

        System.out.println("Next Friday 13th="+LocalDate.now().with(new NextFriday13thAdjuster()));
        
        
        System.out.println(LocalDate.now().minusDays(1).query(new FerieQuery()));;
        
        System.out.println(LocalDate.now().query(new TemporalQuery<LocalDate>() {
            @Override
            public LocalDate queryFrom(TemporalAccessor temporal) {
                LocalDate date = LocalDate.from(temporal);
                while (date.getDayOfWeek() != DayOfWeek.FRIDAY) {
                    date = date.plusMonths(1).withDayOfMonth(13);
                }
                return date;
            }
        }));
        
        ZoneId geneve = ZoneId.of("Europe/Paris");
        System.out.println(geneve.getDisplayName(TextStyle.FULL, Locale.FRENCH));
        ZoneId la = ZoneId.of("America/Los_Angeles");
        LocalDateTime depart = LocalDateTime.of(2017, Month.JULY, 30, 20, 0);
        
        ZonedDateTime departGE = ZonedDateTime.of(depart,geneve);
        System.out.println(departGE);
        ZonedDateTime departHdeLA = departGE.withZoneSameInstant(la);
        System.out.println(departHdeLA);
        ZonedDateTime arriveeLA = departHdeLA.plusHours(11);
        System.out.println(arriveeLA);
        ZonedDateTime arriveeHdeGE = arriveeLA.withZoneSameInstant(geneve);;
        System.out.println(arriveeHdeGE);
        
        DateTimeFormatter formatterA = DateTimeFormatter.ofPattern("dd MMM yyy hh:mm");
        System.out.println(formatterA.format(depart)); 
        DateTimeFormatter formatterP=DateTimeFormatter.ofPattern("dd/MM/yyy");
        System.out.println(formatterP.parse("12/05/2017"));
        LocalDate ld= LocalDate.parse("12/05/2017", formatterP);
        System.out.println(ld);
        
        formatterA =DateTimeFormatter.ofPattern("EEEE dd MMMM yyy HH:mm", Locale.GERMAN);
        System.out.println(formatterA.format(depart));
        Locale l = new Locale("ES", "GT");
        formatterA =DateTimeFormatter.ofPattern("EEEE dd MMMM yyy HH:mm", l);
        System.out.println(formatterA.format(depart));      
        System.out.println(l.getDisplayLanguage()+" "+l.getDisplayCountry());

    }

    private static void OldDates() {
        Date d = new Date();
        System.out.println(d);
        System.out.println(d.getTime());//long
        System.out.println(d.after(d));

        Calendar c = Calendar.getInstance();
        Calendar c2 = new GregorianCalendar();

        System.out.println(c2.get(Calendar.MONTH));
        System.out.println(c2.get(Calendar.DAY_OF_MONTH));

        c2.set(Calendar.MONTH, 8);
        c2.add(Calendar.DAY_OF_MONTH, -3);

        System.out.println(c2.getTime());//java.util.date

        TimeZone tz = c2.getTimeZone();
        System.out.println(tz.getOffset(d.getTime()) / 1000 / 60 / 60);
        TimeZone tz2 = TimeZone.getTimeZone("America/Los_Angeles");
        System.out.println(tz2.getOffset(d.getTime()) / 1000 / 60 / 60);

        System.out.println(TimeZone.getDefault());
    }

}

class FerieQuery implements TemporalQuery<Boolean> {

    @Override
    public Boolean queryFrom(TemporalAccessor temporal) {
        DayOfWeek dow = LocalDate.from(temporal).getDayOfWeek();
        return dow == DayOfWeek.MONDAY || dow == DayOfWeek.SUNDAY;
    }

}
class NextFriday13thAdjuster implements TemporalAdjuster {
        @Override
	public Temporal adjustInto(Temporal temporalInput) {
		LocalDate date = LocalDate.from(temporalInput);
		while (date.getDayOfWeek() != DayOfWeek.FRIDAY) {
                    date = date.plusMonths(1).withDayOfMonth(13);
                }
		return temporalInput.with(date);
	}
}
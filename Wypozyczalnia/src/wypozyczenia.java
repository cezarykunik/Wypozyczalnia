import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class wypozyczenia {
    //private int ID;
    private ksiazka wypozyczonaKsiazka;
    private uzytkownik uzytkownikBiblioteki;
    private LocalDate dataWypozyczenia;
    private LocalDate  dataZwrotu;
    private static List<wypozyczenia> wypozyczeniali=new ArrayList<wypozyczenia>();

    public wypozyczenia( ksiazka wypozyczonaKsiazka, uzytkownik uzytkownikBiblioteki) {
         this.uzytkownikBiblioteki = uzytkownikBiblioteki;
        // this.ID = ID;
        this.wypozyczonaKsiazka = wypozyczonaKsiazka;
        this.dataWypozyczenia=LocalDate.now();
        this.dataZwrotu=LocalDate.now().plusDays(14);
        wypozyczeniali.add(this);


    }
/*    public static void dodajWypozeczenieDoListy(ksiazka ksiega, uzytkownik user) {
        wypozyczenia rekord=new wypozyczenia(ksiega,user);
        if(!wypozyczeniali.contains(rekord)) {
        wypozyczeniali.add(rekord);
    }}*/


    public static List<wypozyczenia> getWypozyczeniali() {
        for(wypozyczenia x: wypozyczeniali) {
            System.out.println(x.toString());
        }

        return wypozyczeniali;
    }
    public String toString()
    {
        return wypozyczonaKsiazka.getTytul()+"  "+ uzytkownikBiblioteki.getImie()+" "+uzytkownikBiblioteki.getNazwisko()+
                " wypozyczona: "+this.dataWypozyczenia   +" do zwrotu: "+this.dataZwrotu;
    }
}




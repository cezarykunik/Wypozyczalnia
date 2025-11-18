import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static void main(String[] args) {
        Biblioteka BibliotekaPodkowa = new Biblioteka("Podkowa", "Cztery Podkowy");
        ksiazka k1 = new ksiazka("hobbit 1", 2123123, "Tolkien", 1962);
        ksiazka k2 = new ksiazka("hobbit 2", 3231324, "Tolkien", 1945);
        ksiazka k3 = new ksiazka("hobbit 3", 423243, "Tolkien", 1935);
        uzytkownik cezary = new uzytkownik(231, "Cezary", "Kunik");
        uzytkownik adam = new uzytkownik(23311, "adam", "malysz");
        uzytkownik mariusz = new uzytkownik(23221, "mariusz", "pudzian");
        k3.setCzyDostepna(false);
        BibliotekaPodkowa.dodajKsiazke(k1);
        BibliotekaPodkowa.dodajKsiazke(k2);
        BibliotekaPodkowa.dodajKsiazke(k3);
        BibliotekaPodkowa.dodajUzytkownika(cezary);
        BibliotekaPodkowa.dodajUzytkownika(adam);
        BibliotekaPodkowa.dodajUzytkownika(mariusz);
        //BibliotekaPodkowa.wybierzUzytkownika();
        BibliotekaPodkowa.wypozyczKsiazke();
        BibliotekaPodkowa.zwrocKsiazke();


//        ksiazka k=new ksiazka("wladca piersceini",1,"Tolkien",1965);
//        ksiazka k1=new ksiazka("hobbit 1",2,"Tolkien",1962);
//        ksiazka k2=new ksiazka("hobbit 2",3,"Tolkien",1945);
//        ksiazka k3=new ksiazka("hobbit 3",4,"Tolkien",1935);


//       uzytkownik cezary=new uzytkownik("Cezary","Kunikowski");
//
//        uzytkownik adam=new uzytkownik("Adam","Małysz");
//       cezary.wypozyczKsiazke(k1);
//        adam.wypozyczKsiazke(k);
//        adam.wypozyczKsiazke(k2);
//        cezary.wypozyczKsiazke(k3);
//        wypozyczenia.getWypozyczeniali();


    }
}
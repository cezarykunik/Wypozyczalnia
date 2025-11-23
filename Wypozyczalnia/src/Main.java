public class Main {
    static void main(String[] args) {
        Biblioteka BibliotekaPodkowa = new Biblioteka("Podkowa", "Cztery Podkowy");
        Ksiazka k1 = new Ksiazka("hobbit 1", 2123123, "Tolkien", 1962);
        Ksiazka k2 = new Ksiazka("hobbit 2", 3231324, "Tolkien", 1945);
        Ksiazka k3 = new Ksiazka("hobbit 3", 423243, "Tolkien", 1935);
        Uzytkownik cezary = new Uzytkownik("Cezary", "Kunik", 231);
        User adam = new Uzytkownik("Adam", "Małysz", 11232);
        User mariusz = new Uzytkownik("Mariusz", "Pudzianowski", 23221);
        User panBibliotekarz = new Bibliotekarz("Pan", "Bibliotekarz", 123);
        k3.setCzyDostepna(false);

        BibliotekaPodkowa.Start();

        //mamy wielka liste ksiazek i uzytkownik z podzialem na użytkownik i bibliotekarz- jutro logowanie i wielkie menu
        //korzystamyu z instanceof aby sie zalogowac itp, fajne menu, ogolnie spinajace calty systemik, sama przyjemna robota
        //  BibliotekaPodkowa.dodajUzytkownika(cezary);
        //  BibliotekaPodkowa.dodajUzytkownika(adam);
        // BibliotekaPodkowa.dodajUzytkownika(mariusz);
        //BibliotekaPodkowa.wybierzUzytkownika();
        //  BibliotekaPodkowa.wypozyczKsiazke();
        //  BibliotekaPodkowa.zwrocKsiazke();
        //  BibliotekaPodkowa.odczytPliku();
        //  BibliotekaPodkowa.wyswietlListeKsiazek();
//BibliotekaPodkowa.wyświetlListeUzytkownikow();
//        ksiazka k=new ksiazka("wladca piersceini",1,"Tolkien",1965);
//        ksiazka k1=new ksiazka("hobbit 1",2,"Tolkien",1962);
//        ksiazka k2=new ksiazka("hobbit 2",3,"Tolkien",1945);
//        ksiazka k3=new ksiazka("hobbit 3",4,"Tolkien",1935);


//

    }
}
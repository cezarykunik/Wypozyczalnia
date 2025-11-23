import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;

//stworz metody do logowania, jakos ogarnij nadanie dostepow do userow, pomysl nad struktura dziedziczenia?
// tak zeby cos nowego sie nauczyc, potem po userze dodajmy jakies rodzaje ksiazek- gatunek? ale to chyba dopiero po
//dodaniu z bazy danych książek

public class Biblioteka {
    private String nazwa;
    private String adres;
    private Map<Integer, Ksiazka> ksiazkiWrazZID;
    public Map<Integer, User> userWrazZID;
    public List<Wypozyczenia> listaWypozyczen;
    public List<Wypozyczenia> listaWypozyczenZakonczonych;

    public Biblioteka(String nazwa, String adres) {
        this.nazwa = nazwa;
        this.adres = adres;

        this.ksiazkiWrazZID = new HashMap<>();
        this.userWrazZID = new HashMap<>();
        this.listaWypozyczen = new ArrayList<>();
        this.listaWypozyczenZakonczonych = new ArrayList<>();
    }
    public void Start()
    {
        odczytPlikuUzytkownicy();
        odczytPlikuKsiazki();

        while (true) {

            System.out.println("1->Wybierz Uzytkownika z Listy dostępnych uzytkownikow");
            System.out.println("2->Dodaj Uzytkownika do listy  uzytkownikow");
            System.out.println("3->Wyjdz z programu ");
            int x=wybierzNumerWmenu();
            User zalogowany=null;
            switch (x)
            {
            case 1:
                wyświetlListeUzytkownikow();
                zalogowany= Zaloguj();
                if(zalogowany instanceof Bibliotekarz)
                {
                    ((Bibliotekarz)zalogowany).WyswietlMenu();
                }
                else
                {
                    ((Uzytkownik)zalogowany).WyswietlMenu();
                }
                break;
            case 2:
                dodajUzytkownika();
                break;
            case 3:
                System.out.println("koniec programu");
            return;
            default: return;

        }}
       // User zalogowany=Zaloguj();


    }

public User Zaloguj()
{
    System.out.println("wybierz uzytkownika z poniższej listy!");
     int i=1;
    for(User u:userWrazZID.values()) {
        System.out.println(i+" "+u);
        i++;
    }
    Scanner scanner=new Scanner(System.in);
    int x=scanner.nextInt();
    User zalogowany=userWrazZID.get(x);
    return zalogowany;


}
    public void dodajUzytkownika() {

        Scanner scanner = new Scanner(System.in);


        String imie = wczytajImieUzytkownika();
        String Nazwisko = wczytajNazwiskoUzytkownika();
        int ID = wczytajID();
        roola r=wybierzRole();
        int IDUser = userWrazZID.size() + 1;
        if(r==roola.Uzytkownik)
        {
            Uzytkownik nowy = new Uzytkownik(imie, Nazwisko, ID) ;
            userWrazZID.put(IDUser, nowy);
        }
        else{        Bibliotekarz nowy = new Bibliotekarz(imie, Nazwisko, ID);
            userWrazZID.put(IDUser, nowy);}




    }

    public void dodajUzytkownika(User u) {
        int IDUser = userWrazZID.size() + 1;
        userWrazZID.put(IDUser, u);

    }

    public void dodajKsiazke() {
        int noweID = ksiazkiWrazZID.size() + 1;  // automatyczne ID

        Scanner scanner = new Scanner(System.in);

        String Tytul = wczytajTytul();
        int ID = wczytajID();
        String Autor = wczytajAutora();
        int rokWydania = wczytajRokwydania();

        Ksiazka nowa = new Ksiazka(Tytul, ID, Autor, rokWydania);
        ksiazkiWrazZID.put(noweID, nowa);
    }

    public void dodajKsiazke(Ksiazka k) {
        int noweID = ksiazkiWrazZID.size() + 1;  // automatyczne ID
        ksiazkiWrazZID.put(noweID, k);
    }

    public void wypozyczKsiazke() {
        User u = wybierzUzytkownika();
        System.out.println("Wyswietlę teraz liste ksiązek :\n");
        wyswietlListeKsiazek();
        System.out.println("Którą ksiazke chcesz wypożyczyc? Wybierz numer: ");
        int ID;
        ID = wybierzNumerWmenu();
        Ksiazka wybrana = ksiazkiWrazZID.get(ID);

        if (wybrana.SprawdzDostepnoscIwypozycz()) {
            ( (Uzytkownik)u).wypozyczKsiazke(wybrana);
            Wypozyczenia x = new Wypozyczenia(wybrana, (Uzytkownik) u);
            listaWypozyczen.add(x);
            x.setID(listaWypozyczen.size());

            System.out.println("Wyświetlę teraz wszystkie zarejestrowane rekordy wypożyczeń w naszej bibliotece");
            System.out.println(listaWypozyczen.toString());

        } else {
            System.out.println("Spróbujemy jeszcze raz!");
            wypozyczKsiazke();
        }

    }

    public User wybierzUzytkownika() {
        Uzytkownik wybrany = null;
        while (true) {
            System.out.println("Wybierz co chcesz zrobic: \n 1-> Wybierz istniejącego użytkownika \n " + "2-> Stwórz użytkownika \n 3-> Wyjdź z menu");
            int x = wybierzNumerWmenu();

            switch (x) {
                case 1:
                    System.out.println("Lista użytkownikow w bazie: \n");
                    wyświetlListeUzytkownikow();
                    System.out.println("Wybierz nuemr o 1 wiekszy niż maksymalny wyświetlony, aby powrócic do menu");
                    int c = wybierzNumerWmenu();

                    if (c == userWrazZID.size() + 1) {
                        continue;
                    } else {
                        System.out.println("Wybrales: " + userWrazZID.get(c));
                        wybrany = (Uzytkownik) userWrazZID.get(c);
                        break;
                    }
                case 2:
                    dodajUzytkownika();
                    System.out.println("Wyświetlę teraz listę uzytkowników!");
                    wyświetlListeUzytkownikow();
                    System.out.println("Wybierz teraz użytkownika do dalszej pracy \n" + "Jeśli chcesz wrócic do poprzedniego Menu, kliknij numer o 1 większy niż" + " wyświetlany maksymalny numer");
                    int q = wybierzNumerWmenu();

                    if (q == userWrazZID.size() + 1) {
                        continue;
                    }
                    System.out.println("Wybrales: " + userWrazZID.get(q));
                    wybrany = (Uzytkownik) userWrazZID.get(q);
                    break;
                default:
                    break;
            }
            //zrobmy tu dwie opcje: wybieremy istniejacego albo dodamy nowego.
            //na samym poczatku zaloze ze mamy goscia istniejacego i to on bedzie wypozyczal
            //jutro wyswietlimy liste uzytkownikow
            //jutro zrob menu w innej metodzie, dodawania, wybrania istenijace, w przyszłosci logowanie
            // plan dzialania wybór co robimy: wyswietl liste ksiazek, wyswietl liste uzytkownikow,
            //wyswietl liste aktualnych wypozyczen
            //chronologia: wyswietlanie rzeczy / dzialania uzytkownikow ( zwrot wypozyczenia dodanie do ksiegozbioru
            //wypozyczenia: uzytkownik->lista dostepnych->wybor z mapy->sprawdz czy dostepna->wypozyczenie->dodanie do lsity wypozcyzen
            return wybrany;
        }
    }


    public void wyswietlListeKsiazek() {

        for (Map.Entry<Integer, Ksiazka> e : ksiazkiWrazZID.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue().toString());
        }


    }

    public void wyswietlListeWypozyczen(Uzytkownik user) {

        for (Wypozyczenia w : listaWypozyczen) {
            if (w.getUzytkownikBiblioteki().equals(user)) {
                System.out.println(w.toString());
            }
        }


    }

    public void wyswietlListeWypozyczen() {

        for (Wypozyczenia w : listaWypozyczen) {

            System.out.println(w.toString());

        }
    }

    public void wyswietlListeWypozyczenZakonczonych() {

        for (Wypozyczenia w : listaWypozyczenZakonczonych) {

            System.out.println(w.toString());
            System.out.println("----------\n");
        }
    }


    public void wyświetlListeUzytkownikow() {
        for (Map.Entry<Integer, User> e : userWrazZID.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue().toString());
        }

    }

    private int wczytajID() {
        Scanner scanner = new Scanner(System.in);
        int ID;

        while (true) {
            System.out.println("Wpisz ID książki:");

            if (scanner.hasNextInt()) {  // sprawdza, czy następne wejście jest liczbą całkowitą
                ID = scanner.nextInt();
                break; // wychodzi z pętli, jeśli poprawne ID
            } else {
                System.out.println("Błąd! Wpisz liczbę całkowitą.");
                scanner.next(); // odrzuca niepoprawne wejście
            }
        }

        return ID;
    }

    private int wybierzNumerWmenu() {
        Scanner scanner = new Scanner(System.in);
        int ID;

        while (true) {
            System.out.println("Wybierz numer polecenia:");

            if (scanner.hasNextInt()) {  // sprawdza, czy następne wejście jest liczbą całkowitą
                ID = scanner.nextInt();
                break; // wychodzi z pętli, jeśli poprawne ID
            } else {
                System.out.println("Błąd! Wpisz liczbę całkowitą.");
                scanner.next(); // odrzuca niepoprawne wejście
            }
        }

        return ID;
    }// ID user to jedno, ID ksiazki to durgie, ID wypozyczenia to co innego

    private int wczytajRokwydania() {
        Scanner scanner = new Scanner(System.in);
        int rokWydania;

        while (true) {
            System.out.println("Wpisz rok wydania książki:");

            if (scanner.hasNextInt()) {  // sprawdza, czy następne wejście jest liczbą całkowitą
                rokWydania = scanner.nextInt();
                break; // wychodzi z pętli, jeśli poprawne rokWydania
            } else {
                System.out.println("Błąd! Wpisz liczbę całkowitą.");
                scanner.next(); // odrzuca niepoprawne wejście
            }
        }

        return rokWydania;
    }

    private String wczytajTytul() {

        Scanner scanner = new Scanner(System.in);
        String tytul;

        while (true) {
            System.out.println("Wpisz tytuł książki:");

            tytul = scanner.nextLine().trim();

            // Sprawdzenie: nie może być pusty
            if (tytul.isEmpty()) {
                System.out.println("Tytuł nie może być pusty!");
                continue;
            }

            // Sprawdzenie: nie może zawierać cyfr
            if (!tytul.matches("[a-zA-ZąćęłńóśźżĄĆĘŁŃÓŚŹŻ ]+")) {
                System.out.println("Tytuł może zawierać tylko litery i spacje!");
                continue;
            }

            // Jeśli tu dotarliśmy -> tytuł jest poprawny
            return tytul;
        }
    }

    private String wczytajAutora() {

        Scanner scanner = new Scanner(System.in);
        String autor;

        while (true) {
            System.out.println("Wpisz autora książki:");

            autor = scanner.nextLine().trim();

            // Sprawdzenie: nie może być pusty
            if (autor.isEmpty()) {
                System.out.println("Tytuł nie może być pusty!");
                continue;
            }

            // Sprawdzenie: nie może zawierać cyfr
            if (!autor.matches("[a-zA-ZąćęłńóśźżĄĆĘŁŃÓŚŹŻ ]+")) {
                System.out.println("Autor może zawierać tylko litery i spacje!");
                continue;
            }

            // Jeśli tu dotarliśmy -> autor jest poprawny
            return autor;
        }
    }

    private String wczytajImieUzytkownika() {

        Scanner scanner = new Scanner(System.in);
        String autor;

        while (true) {
            System.out.println("Wpisz imie uzytkownika:");

            autor = scanner.nextLine().trim();

            // Sprawdzenie: nie może być pusty
            if (autor.isEmpty()) {
                System.out.println("wpis nie może być pusty!");
                continue;
            }

            // Sprawdzenie: nie może zawierać cyfr
            if (!autor.matches("[a-zA-ZąćęłńóśźżĄĆĘŁŃÓŚŹŻ ]+")) {
                System.out.println("wpis może zawierać tylko litery i spacje!");
                continue;
            }

            // Jeśli tu dotarliśmy -> autor jest poprawny
            return autor;
        }
    }
    private roola wybierzRole()
    {
        Scanner scanner = new Scanner(System.in);
        int ID;

        while (true) {
            System.out.println("Wybierz 1- Uzytkownik lub 2- Bibliotekarz");

            if (scanner.hasNextInt()) {  // sprawdza, czy następne wejście jest liczbą całkowitą
                ID = scanner.nextInt();
                break; // wychodzi z pętli, jeśli poprawne ID
            } else {
                System.out.println("Błąd! Wpisz liczbę całkowitą.");
                scanner.next(); // odrzuca niepoprawne wejście
            }
        }
        if(ID==1){
            return roola.Uzytkownik;
        }
        else if(ID==2){
            return roola.Bibliotekarz;
        }
        return null;
    }

    private String wczytajNazwiskoUzytkownika() {

        Scanner scanner = new Scanner(System.in);
        String autor;

        while (true) {
            System.out.println("Wpisz nazwisko uzytkownika:");

            autor = scanner.nextLine().trim();

            // Sprawdzenie: nie może być pusty
            if (autor.isEmpty()) {
                System.out.println("wpis nie może być pusty!");
                continue;
            }

            // Sprawdzenie: nie może zawierać cyfr
            if (!autor.matches("[a-zA-ZąćęłńóśźżĄĆĘŁŃÓŚŹŻ ]+")) {
                System.out.println("wpis może zawierać tylko litery i spacje!");
                continue;
            }

            // Jeśli tu dotarliśmy -> autor jest poprawny
            return autor;
        }
    }

    public void zwrocKsiazke() {
        Uzytkownik u = (Uzytkownik) wybierzUzytkownika();

        System.out.println("Którą ksiazke chcesz zwrócic? Wybierz numer: \n");
        wyswietlListeWypozyczen(u);
        int ID;
        ID = wybierzNumerWmenu() - 1;
        Ksiazka ksiazka = listaWypozyczen.get(ID).getWypozyczonaKsiazka();


        Wypozyczenia doUsuniecia = null;
        for (Wypozyczenia wyp : listaWypozyczen) {
            if (wyp.getUzytkownikBiblioteki().equals(u) && wyp.getWypozyczonaKsiazka().equals(ksiazka)) {

                u.zwrocKsiazke(wyp.getWypozyczonaKsiazka());
                wyp.getWypozyczonaKsiazka().zwroc();
                wyp.zakonczWypozyczenie();
                doUsuniecia = wyp;
            }
        }
        listaWypozyczenZakonczonych.add(doUsuniecia);
        listaWypozyczen.remove(doUsuniecia);


        System.out.println("lista wypozyczen wszystkich aktualnych:\n");
        wyswietlListeWypozyczen();
        System.out.println("lista wypozyczen usera:\n");
        u.wyswietlListeWypozyczonychKsiazek();
        System.out.println("czy ksiazka z reokrdu wyp jest dostepna:\n");
        System.out.println(ksiazka.isCzyDostepna());
        System.out.println("lista zakończonych wypożyczen!");
        wyswietlListeWypozyczenZakonczonych();
    }

    public void odczytPlikuKsiazki() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("ksiazki.txt"));

            String linia;
            while ((linia = br.readLine()) != null) {
                // System.out.println(linia);
                String[] liniaSplit = linia.split(",");
                Ksiazka ksiazka = new Ksiazka(liniaSplit[0],
                        Integer.parseInt(liniaSplit[1]),
                        liniaSplit[2], Integer.parseInt(liniaSplit[3]));// odczyt linii
                // z pliku, podzial stringa na slowa,
                //inicjalizacja konstruktora ksiazka odczytanymi danymi
                dodajKsiazke(ksiazka);
            }

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void odczytPlikuUzytkownicy() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("uzytkownicy.txt"));

            String linia;
            while ((linia = br.readLine()) != null) {
                // System.out.println(linia);
                String[] liniaSplit = linia.split(",");
                String imie = liniaSplit[0];
                String nazwisko = liniaSplit[1];
                int ID = Integer.parseInt(liniaSplit[2]);
                String Role = liniaSplit[3];
                if (Role.equals("Bibliotekarz")) {
                    User u = new Bibliotekarz(imie, nazwisko, ID);
                    dodajUzytkownika(u);
                } else {
                    User u = new Uzytkownik(imie, nazwisko, ID);
                    dodajUzytkownika(u);
                }


            }

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
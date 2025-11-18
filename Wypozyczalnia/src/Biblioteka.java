import java.util.*;

//stworz metody do logowania, jakos ogarnij nadanie dostepow do userow, pomysl nad struktura dziedziczenia?
// tak zeby cos nowego sie nauczyc, potem po userze dodajmy jakies rodzaje ksiazek- gatunek? ale to chyba dopiero po
//dodaniu z bazy danych książek
//potem wyswietlanie rekordow dla konkretnego usera,ok
// metoda zwroc ksiazke - i to dzisiaj przyjacielu
public class Biblioteka {
    private String nazwa;
    private String adres;
    private Map<Integer, ksiazka> ksiazkiWrazZID;
    public Map<Integer, uzytkownik> userWrazZID;
    public List<wypozyczenia> listaWypozyczen;
    public List<wypozyczenia> listaWypozyczenZakonczonych;
    public Biblioteka(String nazwa, String adres) {
        this.nazwa = nazwa;
        this.adres = adres;

        this.ksiazkiWrazZID = new HashMap<>();
        this.userWrazZID = new HashMap<>();
        this.listaWypozyczen = new ArrayList<>();
        this.listaWypozyczenZakonczonych = new ArrayList<>();
    }


    public void dodajUzytkownika() {

        Scanner scanner = new Scanner(System.in);


        String imie = wczytajImieUzytkownika();
        String Nazwisko = wczytajNazwiskoUzytkownika();
        int ID = wczytajID();

        int IDUser = userWrazZID.size() + 1;
        uzytkownik nowy = new uzytkownik(ID, imie, Nazwisko);

        userWrazZID.put(IDUser, nowy);
    }

    public void dodajUzytkownika(uzytkownik u) {
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

        ksiazka nowa = new ksiazka(Tytul, ID, Autor, rokWydania);
        ksiazkiWrazZID.put(noweID, nowa);
    }

    public void dodajKsiazke(ksiazka k) {
        int noweID = ksiazkiWrazZID.size() + 1;  // automatyczne ID
        ksiazkiWrazZID.put(noweID, k);
    }

    public void wypozyczKsiazke() {
        uzytkownik u = wybierzUzytkownika();
        System.out.println("Wyswietlę teraz liste ksiązek :\n");
        wyswietlListeKsiazek();
        System.out.println("Którą ksiazke chcesz wypożyczyc? Wybierz numer: ");
        int ID;
        ID = wybierzNumerWmenu();
        ksiazka wybrana = ksiazkiWrazZID.get(ID);

        if (wybrana.SprawdzDostepnoscIwypozycz()) {
            u.wypozyczKsiazke(wybrana);
            wypozyczenia x = new wypozyczenia(wybrana, u);
            listaWypozyczen.add(x);
            x.setID(listaWypozyczen.size());

            System.out.println("Wyświetlę teraz wszystkie zarejestrowane rekordy wypożyczeń w naszej bibliotece");
            System.out.println(listaWypozyczen.toString());

        } else {
            System.out.println("Spróbujemy jeszcze raz!");
            wypozyczKsiazke();
        }

    }

    public uzytkownik wybierzUzytkownika() {
        uzytkownik wybrany = new uzytkownik();
        while (true) {
            System.out.println("Wybierz co chcesz zrobic: \n 1-> Wybierz istniejącego użytkownika \n " +
                    "2-> Stwórz użytkownika \n 3-> Wyjdź z menu");
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
                        wybrany = userWrazZID.get(c);
                        break;
                    }
                case 2:
                    dodajUzytkownika();
                    System.out.println("Wyświetlę teraz listę uzytkowników!");
                    wyświetlListeUzytkownikow();
                    System.out.println("Wybierz teraz użytkownika do dalszej pracy \n" +
                            "Jeśli chcesz wrócic do poprzedniego Menu, kliknij numer o 1 większy niż" +
                            " wyświetlany maksymalny numer");
                    int q = wybierzNumerWmenu();

                    if (q == userWrazZID.size() + 1) {
                        continue;
                    }
                    System.out.println("Wybrales: " + userWrazZID.get(q));
                    wybrany = userWrazZID.get(q);
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

    //metody do oblsugi skanera
    public void wyswietlListeKsiazek() {

        for (Map.Entry<Integer, ksiazka> e : ksiazkiWrazZID.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue().getTytul());
        }


    }

    public void wyswietlListeWypozyczen(uzytkownik user) {

        for (wypozyczenia w : listaWypozyczen) {
            if (w.getUzytkownikBiblioteki().equals(user)) {
                System.out.println(w.toString());
            }
        }


    }

    public void wyswietlListeWypozyczen() {

        for (wypozyczenia w : listaWypozyczen) {

            System.out.println(w.toString());
            System.out.println("\n");
        }
    }
    public void wyswietlListeWypozyczenZakonczonych() {

        for (wypozyczenia w : listaWypozyczenZakonczonych) {

            System.out.println(w.toString());
            System.out.println("----------\n");
        }
    }


    public void wyświetlListeUzytkownikow() {
        for (Map.Entry<Integer, uzytkownik> e : userWrazZID.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue().getImie() + e.getValue().getNazwisko());
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
    }// jakie ID do uzytkwonika? czyje ? przemysl

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
        uzytkownik u = wybierzUzytkownika();

        System.out.println("Którą ksiazke chcesz zwrócic? Wybierz numer: \n");
        wyswietlListeWypozyczen(u);
        int ID;
        ID = wybierzNumerWmenu() - 1;
        ksiazka ksiazka = listaWypozyczen.get(ID).getWypozyczonaKsiazka();


        wypozyczenia doUsuniecia = null;
        for (wypozyczenia wyp : listaWypozyczen) {
            if (wyp.getUzytkownikBiblioteki().equals(u) && wyp.getWypozyczonaKsiazka().equals(ksiazka)) {

                u.zwrocKsiazke(wyp.getWypozyczonaKsiazka());
                wyp.getWypozyczonaKsiazka().zwroc();
                wyp.zakonczWypozyczenie();
                doUsuniecia=wyp;
            }
        }
        listaWypozyczenZakonczonych.add(doUsuniecia);
        listaWypozyczen.remove(doUsuniecia);


        System.out.println("lista wypozyczen wszystkich aktualnych:\n");
        wyswietlListeWypozyczen();
        System.out.println("lista wypozyczen usera:\n");
        u.pokazWypozyczenia();
        System.out.println("czy ksiazka z reokrdu wyp jest dostepna:\n");
        System.out.println(ksiazka.isCzyDostepna());
        System.out.println("lista zakończonych wypożyczen!");
        wyswietlListeWypozyczenZakonczonych();
    }

}
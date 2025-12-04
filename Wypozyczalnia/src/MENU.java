import java.util.Scanner;

public  class MENU {
    private MENU() {
    }
/// Bibliotekarz
    public static int MenuBibliotekarzUsunPozycje() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("1-> Wyświetl kolejny rekord");
        System.out.println("2-> Wyświetl poprzedni rekord");
        System.out.println("3-> Usun rekord");
        System.out.println("4-> Wroc do Menu");
        while (true) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("To nie jest liczba! Spróbuj ponownie:");
                scanner.next(); // usuwa błędne dane
            }
        }
    }
    public static int MenuBibliotekarzglowne(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("1-> Wyswietl wszystkei ksiazki!");
        System.out.println("2-> wyświetlListeUzytkownikow");
        System.out.println("3->wyswietlListeWypozyczenZakonczonych");
        System.out.println("4->WyswietlListeKsiazek konkretnego uzytkownika");
        System.out.println("5-> dodajKsiazke");
        System.out.println("6-> Wyswietl liste aktualnych Wypozyczen!");
        System.out.println("7-> Usun ksiazke z Listy");
        System.out.println("8-> wroc do MENU");

        while (true) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("To nie jest liczba! Spróbuj ponownie:");
                scanner.next(); // usuwa błędne dane
            }
        }
    }
 ///uzytkownik
    public static int menuUzytkownika()    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1-> Wyswietl wszystkie ksiazki!");
        System.out.println("2-> Wypozycz ksiązke");
        System.out.println("3-> Zwróc książke");
        System.out.println("4->wyswietlListe Wypozyczen Zakonczonych- do oprogramowania");
        System.out.println("5->Wyswietl Liste Ksiazek uzytkownika");
        System.out.println("6-> Wyswietl liste aktualnych Wypozyczen!");
        System.out.println("7-> wroc do MENU");
        while (true) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("To nie jest liczba! Spróbuj ponownie:");
                scanner.next(); // usuwa błędne dane
            }
        }
    }
///Biblioteka
    public static int StartMenu()   {
        Scanner scanner=new Scanner(System.in);
        System.out.println("1->Wybierz Uzytkownika z Listy dostępnych uzytkownikow");
        System.out.println("2->Dodaj Uzytkownika do listy  uzytkownikow");
        System.out.println("3->Wyjdz z programu ");
        while (true) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("To nie jest liczba! Spróbuj ponownie:");
                scanner.next(); // usuwa błędne dane
            }
        }

    }
    public static String wczytajImieUzytkownika() {

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
    public static String wczytajNazwiskoUzytkownika() {

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
    public static int wczytajID() {
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
    public static roola wybierzRole() {
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
        if (ID == 1) {
            return roola.Uzytkownik;
        } else if (ID == 2) {
            return roola.Bibliotekarz;
        }
        return null;
    }
    public static String wczytajTytul() {

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
    public static String wczytajAutora() {

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
    public static int wczytajRokwydania() {
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
    public static int wybierzNumerWmenu() {
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
    }


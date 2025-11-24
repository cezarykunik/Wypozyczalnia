import java.util.ArrayList;
import java.util.List;

public class Uzytkownik extends User implements wypozyczającyKsiazki {

    private List<Ksiazka> listaWypozyczen;
    private Biblioteka b;

    public void setBiblioteka(Biblioteka b) {
        this.b = b;
    }

    public void WyswietlMenu() {
        System.out.println("Jestem Uzytkownikiem, o to co potrafie: ");
        while (true) {

            System.out.println("1-> Wyswietl wszystkie ksiazki!");
            System.out.println("2-> Wypozycz ksiązke");
            System.out.println("3-> Zwróc książke");
            System.out.println("4->wyswietlListe Wypozyczen Zakonczonych- do oprogramowania");
            System.out.println("5->Wyswietl Liste Ksiazek uzytkownika");
            System.out.println("6-> Wyswietl liste aktualnych Wypozyczen!");

            System.out.println("7-> wroc do MENU");
            int x = this.b.wybierzNumerWmenu();
            switch (x) {
                case 1:
                    wyswietlWszystkieKsiazki(this.b);
                    break;
                case 2:
                    wypozyczKsiazke();
                    break;
                case 3:
                    zwrocKsiazke();
                    break;
                case 4:
                    System.out.println("do oprogramowania, czyto ma sens?");
                    break;

                case 5:
                    for(Ksiazka k: listaWypozyczen) {
                        System.out.println(k);
                    }
                    break;
                case 6:
                    wyswietlListeSwoichWypozyczen(b);
                    break;

                case 7:
                    System.out.println("koniec programu");
                    return;
            }
        }
    }

    public String getImie() {
        return super.Imie;
    }

    public String getNazwisko() {
        return super.Nazwisko;
    }

    public Uzytkownik(String imie, String nazwisko, int ID) {
        super(imie, nazwisko, ID, roola.Uzytkownik);
        this.listaWypozyczen = new ArrayList<Ksiazka>();
    }

    public void wyswietlWszystkieKsiazki(Biblioteka b) {
        b.wyswietlListeKsiazek();
    }

    public Uzytkownik() {
        super("", "", 0, roola.Uzytkownik);
        this.listaWypozyczen = new ArrayList<Ksiazka>();
    }

    /*    public void wypozyczKsiazke(ArrayList<ksiazka> lista) {

            Scanner scanner = new Scanner(System.in);
            int wybor;

            do {

                System.out.println("\n--- MENU ---");
                System.out.println("1. Pokaż listę książek");
                System.out.println("2. Wypożycz książkę");
                System.out.println("3-Pokaz wszystkie bieżące wypożyczenia uzytkownika!");
                System.out.println("0. Wyjście");
                System.out.print("Wybierz opcję: ");
                wybor = scanner.nextInt();

                switch (wybor) {
                    case 1:
                        System.out.println("\nLista książek:");
                        for (int i = 0; i < lista.size(); i++) {
                            ksiazka k = lista.get(i);
                            System.out.println((i + 1) + ". " + k.getTytul() + " | Dostępna: " + k.isCzyDostepna());
                        }
                        break;

                    case 2:
                        System.out.println("\nWybierz numer książki do wypożyczenia:");
                        for (int i = 0; i < lista.size(); i++) {
                            ksiazka k = lista.get(i);
                            System.out.println((i + 1) + ". " + k.getTytul() + " | Dostępna: " + k.isCzyDostepna());
                        }
                        int numer = scanner.nextInt();
                        if (numer >= 1 && numer <= lista.size()) {
                            ksiazka wybrana = lista.get(numer - 1);
                            wybrana.wypozycz();
                            listaWypozyczen.add(wybrana);

                        } else {
                            System.out.println("Niepoprawny numer książki!");
                        }
                        break;
                    case 3:

                        if(listaWypozyczen.size()>0)
                        {
                            pokazWypozyczenia();
                        }else {
                            System.out.println("aktualnie, brak wypozyczen!");
                        }break;
                    case 0:
                        System.out.println("Koniec programu.");
                        break;

                    default:
                        System.out.println("Niepoprawna opcja!");
                }


            } while (wybor != 0);

            scanner.close();
        }*/
    public void wypozyczKsiazke() {
        this.b.wypozyczKsiazke(this);

        //listaWypozyczen.add(x);

    }

    public void addToListWypozyczen(Ksiazka k) {
        this.listaWypozyczen.add(k);
    }

    public void removeFromListWypozyczen(Ksiazka k) {
        this.listaWypozyczen.remove(k);
    }

    public void zwrocKsiazke() {
        this.b.zwrocKsiazke(this);
        // listaWypozyczen.remove(k);

    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void wyswietlListeWypozyczonychKsiazek() {
        for (Ksiazka x : listaWypozyczen) {
            System.out.println("Uzytkownik: " + super.Imie + super.Nazwisko + " wypozyczyl: " + x.getTytul().toString());
        }
    }

    public void wyswietlListeSwoichWypozyczen() {

    }

    public void wyswietlListeSwoichWypozyczen(Biblioteka biblioteka) {
        biblioteka.wyswietlListeWypozyczen(this);
    }

    public String getRole() {
        return "Uzytkownik";
    }
}



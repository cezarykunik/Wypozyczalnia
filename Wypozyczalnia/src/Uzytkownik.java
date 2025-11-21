import java.util.ArrayList;
import java.util.List;

public class Uzytkownik extends User implements wypozyczającyKsiazki {

    private List<Ksiazka> listaWypozyczen;


    public String getImie() {
        return super.Imie;
    }

    public String getNazwisko() {
        return super.Nazwisko;
    }

    public Uzytkownik(String imie, String nazwisko, int ID) {
        super(imie, nazwisko, ID);
        this.listaWypozyczen = new ArrayList<Ksiazka>();
    }

    public Uzytkownik() {
        super("", "", 0);
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
    public void wypozyczKsiazke(Ksiazka k) {
        listaWypozyczen.add(k);

    }

    public void zwrocKsiazke(Ksiazka k) {
        listaWypozyczen.remove(k);

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



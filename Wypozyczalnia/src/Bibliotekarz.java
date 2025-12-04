import java.util.*;

public class Bibliotekarz extends User implements wladajacyBiblioteka {

    private Biblioteka b;

    public void setBiblioteka(Biblioteka b) {
        this.b = b;
    }

    public Bibliotekarz(String imie, String nazwisko, int ID) {
        super(imie, nazwisko, ID, roola.Bibliotekarz);


    }

    public void zaloguj(User u) {

    }

    public void WyswietlMenu() {
        System.out.println("Jestem Bibliotekarzem, o to co potrafie: ");
        while (true) {

            int x = MENU.MenuBibliotekarzglowne();
            switch (x) {
                case 1:
                    wyswietlWszystkieKsiazki(this.b);
                    break;
                case 2:
                    wyświetlListeUzytkownikow(this.b);
                    break;
                case 3:
                    wyswietlListeWypozyczenZakonczonych(this.b);
                    break;
                case 4:
                    User u = b.wybierzUzytkownika();
                    if(u instanceof Uzytkownik) {
                    wyswietlListeWypozyczen(this.b, (Uzytkownik) u);}
                    else{
                        System.out.println("jestem bibliotekarzem, nie oszukuj!");
                    }
                    break;
                case 5:
                    dodajKsiazke(this.b);
                    break;
                case 6:
                    wyswietlListeWypozyczen(this.b);
                    break;
                case 7:
                    usunZBiblioteki(this.b);
                    break;
                case 8:
                    System.out.println("koniec programu");
                    return;
            }
        }
    }

    @Override
    public void SetHaslo(String haslo) {
        super.SetHaslo(haslo);
    }

    @Override
    public void wyswietlWszystkieKsiazki(Biblioteka biblioteka) {
        biblioteka.wyswietlListeKsiazek();
    }

    @Override
    public void wyświetlListeUzytkownikow(Biblioteka biblioteka) {
        biblioteka.wyświetlListeUzytkownikow();
    }

    @Override
    public void wyswietlListeWypozyczenZakonczonych(Biblioteka biblioteka) {
        biblioteka.wyswietlListeWypozyczenZakonczonych();
    }

    @Override
    public void wyswietlListeKsiazek(Biblioteka biblioteka) {
        biblioteka.wyswietlListeKsiazek();
    }

    @Override
    public void dodajKsiazke(Biblioteka biblio) {
        biblio.dodajKsiazke();
    }


    @Override
    public void wyswietlListeWypozyczen(Biblioteka biblioteka) {
        biblioteka.wyswietlListeWypozyczen();
    }

    public void wyswietlListeWypozyczen(Biblioteka biblioteka, Uzytkownik uzytkownik) {
        biblioteka.wyswietlListeWypozyczen(uzytkownik);
    }


    public String getRole() {
        return "Bibliotekarz";
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void usunZBiblioteki(Biblioteka b) {

        Map<Integer, Ksiazka> mapa = new HashMap<>();
        mapa = b.getKsiazkiWrazZID();
        List<Map.Entry<Integer, Ksiazka>> lista = new ArrayList<>(mapa.entrySet());
        ListIterator<Map.Entry<Integer, Ksiazka>> it = lista.listIterator();

        if (!it.hasNext()) {
            System.out.println("Mapa jest pusta!");
            return;
        }

        Map.Entry<Integer, Ksiazka> current = it.next();
        boolean bolin = true;
        System.out.println(current.getValue());

        while (bolin) {

            int numer = MENU.MenuBibliotekarzUsunPozycje();

            switch (numer) {
                case 1:
                    if (it.hasNext()) {
                        current = it.next();
                        System.out.println(current.getValue());
                    } else {
                        System.out.println("To już ostatni rekord.");
                    }
                    break;
                case 2:
                    if (it.hasPrevious()) {
                        current = it.previous();
                        System.out.println(current.getValue());
                    } else {
                        System.out.println("To już pierwszy rekord.");
                    }
                    break;

                case 3:

                    Ksiazka usuwana = current.getValue();
                    Integer klucz = current.getKey();
                    if (usuwana.isCzyDostepna() == true) {
                        System.out.println("Usunięto: " + usuwana);

                        it.remove();      // usuwa z listy
                        mapa.remove(klucz); // usuwa z mapy
                    } else {
                        System.out.println("nie usune, jest wypozyczona");
                    }
                    // automatycznie przesuwa iterator poprawnie
                    if (it.hasNext()) {
                        current = it.next();
                    } else if (it.hasPrevious()) {
                        current = it.previous();
                    } else {
                        System.out.println("Lista jest teraz pusta.");
                        return;
                    }

                    System.out.println("Teraz wskazuje: " + current.getValue());
                    break;

                case 4:
                    bolin = false;

            }
        }
        b.setKsiazkiWrazZID(mapa);
    }


}





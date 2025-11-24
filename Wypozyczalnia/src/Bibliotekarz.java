public class Bibliotekarz extends User implements wladajacyBiblioteka {

    private Biblioteka b;

    public void setBiblioteka(Biblioteka b) {
        this.b = b;
    }

    public Bibliotekarz(String imie, String nazwisko, int ID) {
        super(imie, nazwisko, ID,roola.Bibliotekarz);


    }
    public void zaloguj(User u) {

    }
    public void WyswietlMenu()
    {
        System.out.println("Jestem Bibliotekarzem, o to co potrafie: ");
        while(true) {

            System.out.println("1-> Wyswietl wszystkei ksiazki!");
            System.out.println("2-> wyświetlListeUzytkownikow");
            System.out.println("3->wyswietlListeWypozyczenZakonczonych");
            System.out.println("4->WyswietlListeKsiazek konkretnego uzytkownika");
            System.out.println("5-> dodajKsiazke");
            System.out.println("6-> Wyswietl liste aktualnych Wypozyczen!");
            System.out.println("7-> wroc do MENU");
            int x = this.b.wybierzNumerWmenu();
            switch (x)
            {
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
                    User u=b.wybierzUzytkownika();
                    wyswietlListeWypozyczen(this.b,(Uzytkownik)u);
                    break;
                case 5:
                    dodajKsiazke(this.b);
                    break;
                case 6:
                    wyswietlListeWypozyczen(this.b);
                    break;
                case 7:
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
}

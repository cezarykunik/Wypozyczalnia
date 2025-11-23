public class Bibliotekarz extends User implements wladajacyBiblioteka {
    public Bibliotekarz(String imie, String nazwisko, int ID) {
        super(imie, nazwisko, ID,roola.Bibliotekarz);
    }
    public void zaloguj(User u) {

    }
    public void WyswietlMenu()
    {
        System.out.println("Jestem Bibliotekarzem, o to co potrafie: ");
        System.out.println("bla bla bla , na te chwile nie potrzebuje konczyc, chodzi o szkic");
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

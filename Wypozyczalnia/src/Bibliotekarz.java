public class Bibliotekarz extends User implements wladajacyBiblioteka {
    public Bibliotekarz(String imie, String nazwisko, int ID) {
        super(imie, nazwisko, ID);
    }

    public void zaloguj(User u) {

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

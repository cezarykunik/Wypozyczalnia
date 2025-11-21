import java.time.LocalDate;

public class Wypozyczenia {
    private int ID;
    private Ksiazka wypozyczonaKsiazka;
    private Uzytkownik uzytkownikBiblioteki;
    private LocalDate dataWypozyczenia;
    private LocalDate dataZwrotu;

    public Ksiazka getWypozyczonaKsiazka() {
        return wypozyczonaKsiazka;
    }

    public Wypozyczenia(Ksiazka wypozyczonaKsiazka, Uzytkownik uzytkownikBiblioteki) {
        this.uzytkownikBiblioteki = uzytkownikBiblioteki;
        this.wypozyczonaKsiazka = wypozyczonaKsiazka;
        this.dataWypozyczenia = LocalDate.now();
        this.dataZwrotu = LocalDate.now().plusDays(14);

    }

    public Uzytkownik getUzytkownikBiblioteki() {
        return uzytkownikBiblioteki;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    public void zakonczWypozyczenie()
    {   LocalDate data=LocalDate.now();
        this.dataZwrotu=data;
        wypozyczonaKsiazka.setCzyDostepna(true);
    }

    public Boolean czyPoTerminie() {
        if (LocalDate.now().compareTo(dataWypozyczenia) <= 15) {
            System.out.println("Po terminie! kara!");
            return true;
        } else {
            System.out.println("Jescze jest troche czasu na oddanie");
            return false;
        }
    }


    public String toString() {
        return wypozyczonaKsiazka.getTytul() + "\n" + uzytkownikBiblioteki.getImie() + " " + uzytkownikBiblioteki.getNazwisko() +
                "\nwypozyczona: "+ this.dataWypozyczenia + "\n zwrotu: " + this.dataZwrotu + "\nID wypozyczenia: " + this.ID;
    }
}




import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class wypozyczenia {
    private int ID;
    private ksiazka wypozyczonaKsiazka;
    private uzytkownik uzytkownikBiblioteki;
    private LocalDate dataWypozyczenia;
    private LocalDate dataZwrotu;

    public ksiazka getWypozyczonaKsiazka() {
        return wypozyczonaKsiazka;
    }

    public wypozyczenia(ksiazka wypozyczonaKsiazka, uzytkownik uzytkownikBiblioteki) {
        this.uzytkownikBiblioteki = uzytkownikBiblioteki;
        this.wypozyczonaKsiazka = wypozyczonaKsiazka;
        this.dataWypozyczenia = LocalDate.now();
        this.dataZwrotu = LocalDate.now().plusDays(14);

    }

    public uzytkownik getUzytkownikBiblioteki() {
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
                "\nwypozyczona:   "+ this.dataWypozyczenia + "\ndo zwrotu: " + this.dataZwrotu + "\nID wypozyczenia: " + this.ID;
    }
}




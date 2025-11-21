import java.util.Objects;

public class Ksiazka {

    private String tytul;
    private int ID;
    private String autor;
    private int rokWydania;
    private boolean czyDostepna;

    public Ksiazka(String tytul, int ID, String autor, int rokWydania) {
        this.tytul = tytul;
        this.ID = ID;
        this.czyDostepna = true;
        this.autor = autor;
        this.rokWydania = rokWydania;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Ksiazka ksiazka = (Ksiazka) o;
        return ID == ksiazka.ID && rokWydania == ksiazka.rokWydania && Objects.equals(tytul, ksiazka.tytul) && Objects.equals(autor, ksiazka.autor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tytul, ID, autor, rokWydania);
    }
//jesli nie nadpisze metody equals to nie bede porownywal obiektow tylko jakeis referencje  pamieci

    public Boolean SprawdzDostepnoscIwypozycz() {
        if (isCzyDostepna()) {
            System.out.println("książka: " + tytul + " jest dostepna, miłego czytania!");
            setCzyDostepna(false);
            return true;
        } else {
            System.out.println("Książka: " + this.tytul + " nie jest dostepna :( ");
            return false;
        }

    }

    public String getTytul() {
        return tytul;
    }

    public int getID() {
        return ID;
    }

    public void zwroc() {
        setCzyDostepna(true);

    }


    public void setCzyDostepna(boolean x) {
        this.czyDostepna = x;
    }

    public boolean isCzyDostepna() {
        return czyDostepna;
    }

    public String toString() {
        return "Tytul: " + this.tytul + "\n" + "ID ksiązki: " + this.ID + "\n" + "autorem jest: " + this.autor +
                "\n" + "rokWydania: " + this.rokWydania + "\n" + "dostępnosc: " + this.czyDostepna;
    }

    public String getAutor() {
        return this.autor;
    }

}



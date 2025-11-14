public class ksiazka {

    private final String tytul;
    private  final int ID;
    private final String autor;
    private  final int rokWydania;
    private boolean czyDostepna;


    public ksiazka(String tytul,int ID,String autor, int rokWydania) {
        this.tytul=tytul;
        this.ID = ID;
        this.czyDostepna = true;
        this.autor = autor;
        this.rokWydania = rokWydania;
    }

    public void wypozycz(){
        if(isCzyDostepna()){
            System.out.println("książka: "+tytul+" jest dostepna, miłego czytania!");
            setCzyDostepna(false);
        }
    else System.out.println("Książka: "+this.tytul+" nie jest dostepna :( ");
    }

    public void zwroc(){
        setCzyDostepna(true);

    }


    public void setCzyDostepna(boolean x) {
        this.czyDostepna = x;
    }

    public boolean isCzyDostepna() {
        return czyDostepna;
    }

    public String toString(){
        return "Tytul: "+this.tytul+"\n"+"ID ksiązki: "+ this.ID+"\n"+ "autorem jest: " +this.autor+
                "\n"+"rokWydania: "+this.rokWydania+"\n"+"dostępnosc: "+this.czyDostepna;
    }
    public int getID() {
        return this.ID;
    }
    public String getAutor() {
        return this.autor;
    }


}

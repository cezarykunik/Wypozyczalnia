import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static void main(String[] args) {
        ArrayList<ksiazka> lista=new ArrayList<ksiazka>();
        ksiazka k=new ksiazka("wladca piersceini",1,"Tolkien",1965);
        ksiazka k1=new ksiazka("hobbit 1",2,"Tolkien",1962);
        ksiazka k2=new ksiazka("hobbit 2",3,"Tolkien",1945);
        ksiazka k3=new ksiazka("hobbit 3",4,"Tolkien",1935);


       uzytkownik cezary=new uzytkownik("Cezary","Kunikowski");

        uzytkownik adam=new uzytkownik("Adam","Małysz");
       cezary.wypozyczKsiazke(k1);
        adam.wypozyczKsiazke(k);
        adam.wypozyczKsiazke(k2);
        cezary.wypozyczKsiazke(k3);
        wypozyczenia.getWypozyczeniali();

    }
}
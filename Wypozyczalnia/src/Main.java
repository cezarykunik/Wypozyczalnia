import java.util.ArrayList;

public class Main {
    static void main(String[] args) {
        ArrayList<ksiazka> lista=new ArrayList<ksiazka>();
        ksiazka k=new ksiazka("wladca piersceini",1,"Tolkien",1965);


        lista.add(k);
        k.wypozycz();
        System.out.println(lista);


        System.out.println("---------");
       k.zwroc();
        System.out.println(k.toString());

    }
}
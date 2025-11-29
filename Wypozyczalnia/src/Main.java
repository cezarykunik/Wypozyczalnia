import java.util.*;

public class Main {
    static void main(String[] args) {
        Biblioteka BibliotekaPodkowa = new Biblioteka("Podkowa", "Cztery Podkowy");
        Ksiazka k1 = new Ksiazka("hobbit 1", 2123123, "Tolkien", 1962);
        Ksiazka k2 = new Ksiazka("hobbit 2", 3231324, "Tolkien", 1945);
        Ksiazka k3 = new Ksiazka("hobbit 3", 423243, "Tolkien", 1935);
        Uzytkownik cezary = new Uzytkownik("Cezary", "Kunik", 231);
        User adam = new Uzytkownik("Adam", "Małysz", 11232);
        User mariusz = new Uzytkownik("Mariusz", "Pudzianowski", 23221);
        User panBibliotekarz = new Bibliotekarz("Pan", "Bibliotekarz", 123);
        k3.setCzyDostepna(false);
        Map<Integer,String>mapa =new HashMap<Integer,String>();
        ArrayList<String> lista=new ArrayList<String>();
        mapa.put(0,"Cezary");
        mapa.put(1,"Adam");
        mapa.put(2,"Adrian");
        mapa.put(3,"Karol");
        mapa.put(4,"Łukasz");
        mapa.put(5,"Rafał");
        mapa.put(6,"Hubert");
        mapa.put(7,"Cezar");
        BibliotekaPodkowa.Start();
        //System.out.println(mapa.entrySet());
//    for(Map.Entry<Integer,String> x :mapa.entrySet())
//        {
//        lista.add(x.getValue());
//        }
//        System.out.println(lista.toString());
//        Iterator<String> it = lista.iterator();
//        lista.sort(Comparator.reverseOrder());
////        while (it.hasNext()) {
////            String element = it.next(); // pobierasz aktualny element
////
////            System.out.println(lista);
////
////
////        }
//        System.out.println(lista.toString());

        //ArrayList<String> Lista=new ArrayList<String>(mapa.values());


    }
}
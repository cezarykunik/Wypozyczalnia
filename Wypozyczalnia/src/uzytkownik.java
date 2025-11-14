import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class uzytkownik {
    private int ID;
    private String imie;
    private String nazwisko;
    private List<ksiazka> listaWypozyczen;


    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public uzytkownik(String imie, String nazwisko) {
        this.ID = 0;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.listaWypozyczen = new ArrayList<ksiazka>();
    }

/*    public void wypozyczKsiazke(ArrayList<ksiazka> lista) {

        Scanner scanner = new Scanner(System.in);
        int wybor;

        do {

            System.out.println("\n--- MENU ---");
            System.out.println("1. Pokaż listę książek");
            System.out.println("2. Wypożycz książkę");
            System.out.println("3-Pokaz wszystkie bieżące wypożyczenia uzytkownika!");
            System.out.println("0. Wyjście");
            System.out.print("Wybierz opcję: ");
            wybor = scanner.nextInt();

            switch (wybor) {
                case 1:
                    System.out.println("\nLista książek:");
                    for (int i = 0; i < lista.size(); i++) {
                        ksiazka k = lista.get(i);
                        System.out.println((i + 1) + ". " + k.getTytul() + " | Dostępna: " + k.isCzyDostepna());
                    }
                    break;

                case 2:
                    System.out.println("\nWybierz numer książki do wypożyczenia:");
                    for (int i = 0; i < lista.size(); i++) {
                        ksiazka k = lista.get(i);
                        System.out.println((i + 1) + ". " + k.getTytul() + " | Dostępna: " + k.isCzyDostepna());
                    }
                    int numer = scanner.nextInt();
                    if (numer >= 1 && numer <= lista.size()) {
                        ksiazka wybrana = lista.get(numer - 1);
                        wybrana.wypozycz();
                        listaWypozyczen.add(wybrana);

                    } else {
                        System.out.println("Niepoprawny numer książki!");
                    }
                    break;
                case 3:

                    if(listaWypozyczen.size()>0)
                    {
                        pokazWypozyczenia();
                    }else {
                        System.out.println("aktualnie, brak wypozyczen!");
                    }break;
                case 0:
                    System.out.println("Koniec programu.");
                    break;

                default:
                    System.out.println("Niepoprawna opcja!");
            }


        } while (wybor != 0);

        scanner.close();
    }*/
    public void wypozyczKsiazke(ksiazka wybrana)
    {
        wybrana.wypozycz();
        wypozyczenia x=new wypozyczenia(wybrana,this);

    }



    public void pokazWypozyczenia() {
        for (ksiazka x : listaWypozyczen) {
            System.out.println("Uzytkownik: "+this.imie+this.nazwisko+" wypozyczyl: " +x.getTytul().toString());
        }
    }

}



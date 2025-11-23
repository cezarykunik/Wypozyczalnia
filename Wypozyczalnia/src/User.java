public abstract class User {
    protected String Imie;
    protected String Nazwisko;
    protected int ID;
    protected String Login;
    protected roola r;
    public String getImie() {
        return Imie;
    }

    public String getNazwisko() {
        return Nazwisko;
    }

    public int getID() {
        return ID;
    }

    protected String haslo;

    public User(String imie, String nazwisko, int ID, roola r) {
        Imie = imie;
        Nazwisko = nazwisko;
        this.ID = ID;
        this.Login = Imie;
        this.r=r;
    }

    public void SetHaslo(String haslo) {
        this.haslo = haslo;
    }

    public void WyswietlMenu()
    {
        System.out.println("jestem gołym abstrakcyjnym Userem, nie mam menu");
    }
    @Override
    public String toString() {
        {
            return this.Imie + " " + this.Nazwisko + " Login: " +this.Login+"\n";

        }
    }

    public String getRole() {
        return "User";
    }

}

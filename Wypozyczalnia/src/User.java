public abstract class User {
    protected String Imie;
    protected String Nazwisko;
    protected int ID;
    protected String Login;

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

    public User(String imie, String nazwisko, int ID) {
        Imie = imie;
        Nazwisko = nazwisko;
        this.ID = ID;
        this.Login = Imie;
    }

    public void SetHaslo(String haslo) {
        this.haslo = haslo;
    }

    @Override
    public String toString() {
        {
            return this.Imie + " " + this.Nazwisko + " " + this.ID + "\n login : " + this.Login + " " + getRole();

        }
    }

    public String getRole() {
        return "User";
    }

}

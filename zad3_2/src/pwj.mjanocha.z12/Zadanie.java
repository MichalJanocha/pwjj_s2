package pwj.mjanocha.z12;

abstract class Wierzcholek {
    Wierzcholek lewy, prawy;
    public abstract int wartosc() throws DzieleniePrzezZero;
}
class Stala extends Wierzcholek {
    private int wart;
    public Stala(int x) {
        wart = x;
    }
    public int wartosc() {
        return wart;
    }
}
class Dzialanie extends Wierzcholek {
    private char op; // operator +, -, / lub *
    public Dzialanie(char znak) {
        op = znak;
    }
    public void dodajLewyArg(Wierzcholek arg) {
        lewy = arg;
    }
    public void dodajPrawyArg(Wierzcholek arg) {
        prawy = arg;
    }
    public int wartosc() throws DzieleniePrzezZero {
        switch (op) {
            case '+': return lewy.wartosc() + prawy.wartosc();
            case '-': return lewy.wartosc() - prawy.wartosc();
            case '/': if(prawy.wartosc() != 0) {
                return lewy.wartosc() / prawy.wartosc();
            } else {
                throw new DzieleniePrzezZero("Nie wolno dzielic przez zero");
            }
            case '*': return lewy.wartosc() * prawy.wartosc();

        }
        return 0;
    }
}
class Wyrazenie {
    private Wierzcholek korzen;
    private Wierzcholek utworzDrzewo(String w, int p, int q) throws ZleSkonstruowane {

        if (p == q)
            return new Stala(Character.digit(w.charAt(p), 10));
        else {
            int i = p+1, nawiasy = 0;
            while ( (nawiasy != 0) || (w.charAt(i) == '(') ||
            (w.charAt(i) == ')') || (Character.isDigit(w.charAt(i))))
            {
                try {
                    if (w.charAt(i) == '(') ++nawiasy;
                    if (w.charAt(i) == ')') --nawiasy;
                    ++i;
                } catch(Exception e) {
                    throw new ZleSkonstruowane("Zle skonstruowane wyrazenie");
                }

            }
            Dzialanie nowy = new Dzialanie(w.charAt(i));
            System.out.println(nawiasy);
            nowy.dodajLewyArg(utworzDrzewo(w, p+1, i-1));
            nowy.dodajPrawyArg(utworzDrzewo(w, i+1, q-1));
            return nowy;
        }
    }
    public Wyrazenie(String w) throws ZleSkonstruowane {
        korzen = utworzDrzewo(w, 0, w.length()-1);
    }
    public int oblicz() throws DzieleniePrzezZero {
        return korzen.wartosc();
    }
}
public class Zadanie {
    public static void main(String[] args) throws DzieleniePrzezZero, ZleSkonstruowane {
        Wyrazenie wyr = new Wyrazenie("(3*((3+1)-1))");
        System.out.println("" + wyr.oblicz());
    }
}



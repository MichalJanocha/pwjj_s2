package pwj.mjanocha.z11;
public class Zadanie {
    public static void main(String[] args) {
        Kolejka k = new Kolejka();
        try {
            k.doKolejki(7);
            k.doKolejki(new String("Ala ma kota"));
            k.doKolejki(3.14d);
            for (int i = 1; i <= 4; ++i)
                System.out.println((k.zKolejki()).toString());
        } catch (Przepelnienie e) {
            System.out.println("Przepełniona kolejka!");
        } catch (Niedomiar e) {
            System.out.println("Pusta kolejka!");
        }
    }
}

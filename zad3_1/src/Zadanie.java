public class Zadanie {
    public static void main(String[] args) {
        Kolejka k = new Kolejka();
        try {
            k.doKolejki(new Integer(7));
            k.doKolejki(new String("Ala ma kota"));
            k.doKolejki(new Double(3.14));
            for (int i = 1; i <= 4; ++i)
                System.out.println((k.zKolejki()).toString());
        } catch (Przepelnienie e) {
            System.out.println("Przepełniona kolejka!");
        } catch (Niedomiar e) {
            System.out.println("Pusta kolejka!");
        }
    }
}

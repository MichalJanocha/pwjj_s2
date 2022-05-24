package Zad62;

import java.util.HashMap;

public class Zad62 {

    public static void main(String args[]) {
        KolejkaKomunikatow k = new KolejkaKomunikatow();
        Watek w1 = new Watek(k, 1);
        Watek w2 = new Watek(k, 2);
        w1.start();
        w2.start();
        try {
            w1.join();
            w2.join();
        } catch (InterruptedException e) {
        }
        Object ob = k.odbierz("5");
        while (k != null && ob != null) {
            System.out.println(((Integer) ob).toString());
            ob = k.odbierz("8");
        }
    }

}



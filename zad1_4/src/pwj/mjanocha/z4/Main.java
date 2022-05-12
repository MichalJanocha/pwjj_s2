package pwj.mjanocha.z4;

import javax.swing.*;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Main {
  public static void main(String[] args) {
    Integer n = null;

    while(n == null){
      String input = JOptionPane.showInputDialog("Wprowadź liczbę którą chcesz przedstawić w formie\nbinarnej, ósemkowej, szesnastkowej");
      try {
        n = Integer.parseInt(input);
        if(n <= 0){
          n = null;
          JOptionPane.showMessageDialog(null, "n nie może być ujemne, wprowadzono: " + input + ". Wprowadź poprawną wartość liczbową.");
        }
      }catch(RuntimeException e){
        JOptionPane.showMessageDialog(null, "Nie można sparsować wartości " + input + ". Wprowadź poprawną wartość liczbową.");
      }
    }
    JOptionPane.showMessageDialog(null, "Liczba "+n+" przedstawiona w formach:\n\nBinarna: "+toBin(n)+"\nÓsemkowa: "+toOct(n)+"\nSzesnastkowa: "+toHex(n));

    System.exit(0);
  }

  private static String toBin(int n){
    StringBuilder result = new StringBuilder();
    do {
      result.append(n & 1);
      n = n >> 1;
    } while (n > 0);

    return result.reverse().toString();
  }

  private static String toOct(int n){
    StringBuilder result = new StringBuilder();

    do {
      result.append(n % 8);
      n = n >>> 3;
    } while (n > 0);

    return result.reverse().toString();
  }

  private static String toHex(int n){
    Map<Integer, Character> hexSymbols = getSymbolsMap();
    StringBuilder result = new StringBuilder();

    do {
      int t = n % 16;
      Character symbol = hexSymbols.get(t);
      result.append(symbol == null ? t : symbol.toString());
      n = n >>> 4;
    } while (n > 0);

    return result.reverse().toString();
  }

  private static Map<Integer, Character> getSymbolsMap(){
    Map<Integer, Character> hexSymbols = new HashMap<>();
    hexSymbols.put(10, 'A');
    hexSymbols.put(11, 'B');
    hexSymbols.put(12, 'C');
    hexSymbols.put(13, 'D');
    hexSymbols.put(14, 'E');
    hexSymbols.put(15, 'F');
    return hexSymbols;
  }
}

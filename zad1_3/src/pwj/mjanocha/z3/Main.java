package pwj.mjanocha.z3;

import javax.swing.*;
import java.math.BigInteger;
import java.util.Optional;

public class Main {
  public static void main(String[] args) {
    BigInteger n = null;

    while(n == null){
      String input = JOptionPane.showInputDialog("Wprowadź n do którego chcesz sumować");
      try {
        n = new BigInteger(input);
        if(n.compareTo(BigInteger.ZERO) < 0){
          n = null;
          JOptionPane.showMessageDialog(null, "n nie może być ujemne, wprowadzono: " + input + ". Wprowadź poprawną wartość liczbową.");
        }
      }catch(RuntimeException e){
        JOptionPane.showMessageDialog(null, "Nie można sparsować wartości " + input + ". Wprowadź poprawną wartość liczbową.");
      }
    }
    JOptionPane.showMessageDialog(null, "Suma liczb od 1 do "+n+" wynosi: "+sumUp(n));

    System.exit(0);
  }

  private static BigInteger sumUp(BigInteger n){
    BigInteger r = BigInteger.ZERO;
    while(n.compareTo(BigInteger.ZERO) > 0){
      if(isOdd(n)){
        r = r.add(n);
      }
      n = n.subtract(BigInteger.ONE);
    }
    return r;
  }

  private static boolean isOdd(BigInteger n){
    return !n.mod(BigInteger.TWO).equals(BigInteger.ZERO);
  }
}

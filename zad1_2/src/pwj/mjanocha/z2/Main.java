package pwj.mjanocha.z2;

import javax.swing.*;
import java.math.BigInteger;
import java.util.Optional;

public class Main {
  public static void main(String[] args) {
    BigInteger n = null;

    while(n == null){
      String input = JOptionPane.showInputDialog("Wprowadź n dla którego chcesz wyliczyć silnię");
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

    BigInteger calculated = calculate(n, null);
    System.out.println("DLA ZACHOWANIA CZYTELNOŚCI, WYNIK W LOGU: ");
    System.out.println(calculated);

    System.exit(0);
  }

  private static BigInteger calculate(BigInteger n, BigInteger result){
    if(n.equals(BigInteger.ZERO)){
      return BigInteger.ONE;
    }
    BigInteger r = Optional.ofNullable(result).orElse(BigInteger.ONE);
    if(n.equals(BigInteger.ONE)){
      return r;
    }
    r = r.multiply(n);
    return calculate(n.subtract(BigInteger.ONE), r);
  }
}

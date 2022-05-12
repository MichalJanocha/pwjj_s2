package pwj.mjanocha.z1;

import javax.swing.*;

public class Main {
  public static void main(String[] args) {
    String userInput = JOptionPane.showInputDialog("Wprowadź łańcuch znaków");
    JOptionPane.showMessageDialog(null, userInput.toUpperCase());
    System.exit(0);
  }
}

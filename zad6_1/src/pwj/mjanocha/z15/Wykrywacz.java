package pwj.mjanocha.z15;

import javax.swing.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Wykrywacz extends Thread {

  JTextArea okno;
  private       JScrollPane  jScrollPane1;
  volatile      boolean      zakonczyc;
  private final List<String> wulgaryzmy = List.of("słowo", "cholera", "brzydkie", "pies");

  public Wykrywacz(JTextArea comp, JScrollPane jScrollPane1) {
    okno = comp;
    this.jScrollPane1 = jScrollPane1;
    zakonczyc = false;
  }

  @Override
  public void run() {
    while (!zakonczyc) {
      try {
        String tekst = okno.getText();
        AtomicInteger i = new AtomicInteger(-1);
        AtomicInteger dlugoscSlowa = new AtomicInteger(-1);

        for (String wulgaryzm : wulgaryzmy) {
          i.set(tekst.indexOf(wulgaryzm));
          if (i.get() > -1) {
            dlugoscSlowa.set(wulgaryzm.length());
            break;
          }
        }

        if (i.get() >= 0) {
          okno.replaceRange("*".repeat(dlugoscSlowa.get()), i.get(), i.get() + dlugoscSlowa.get());
          okno.setCaretPosition(tekst.length());
          SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(jScrollPane1, "Cenzura!"));
        }
        sleep(1000);
      } catch (Exception ignored) {
      }
    }
  }
}

package Zad61;

import javax.swing.*;

public class Wykrywacz extends Thread {

    JTextArea okno;
    private JScrollPane jScrollPane1;
    volatile boolean zakonczyc;

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
                int indeks = tekst.indexOf("cholera");
                if (indeks >= 0) {
                    okno.replaceRange("*******", indeks, indeks + 7);
                    okno.setCaretPosition(tekst.length());
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            JOptionPane.showMessageDialog(jScrollPane1, "Cenzura!");
                        }
                    });
                }
                sleep(1000);
            } catch (Exception e) {
            }
        }
    }
}

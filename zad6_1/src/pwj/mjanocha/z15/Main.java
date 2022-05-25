package pwj.mjanocha.z15;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class Main extends JFrame {

  public Main() {
    initComponents();
    setSize(350, 250);
    watek = new Zamieniacz(jTextArea1);
    wykrywacz = new Wykrywacz(jTextArea1, jScrollPane1);
    watek.start();
    wykrywacz.start();
  }

  private void initComponents() {
    jScrollPane1 = new JScrollPane();
    jTextArea1 = new JTextArea();
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent evt) {
        formWindowClosing(evt);
      }
    });
    jTextArea1.setPreferredSize(new Dimension(300, 200));
    jScrollPane1.setViewportView(jTextArea1);
    getContentPane().add(jScrollPane1, BorderLayout.CENTER);
    pack();
  }

  private void formWindowClosing(WindowEvent evt) {
    watek.zakonczyc = true;
    watek = null;
  }

  public static void main(String args[]) {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        new Main().setVisible(true);
      }
    });
  }

  private JScrollPane jScrollPane1;
  private JTextArea   jTextArea1;
  private Zamieniacz  watek;
  private Wykrywacz   wykrywacz;
}
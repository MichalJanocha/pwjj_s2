package pwj.mjanocha.z8;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class TextEditor extends JFrame implements ActionListener {
  private final String UTF8 = "Zapisz (UTF8)";
  private final String ISO88592 = "Zapisz (ISO8859 2)";
  private final String CP1250 = "Zapisz (Cp1250)";
  private JTextArea textArea;
  TextEditor(){
    JFrame frame = new JFrame("editor");
    textArea = new JTextArea();

    JMenu menu = new JMenu("Plik");

    JMenuBar mb = new JMenuBar();

    mb.add(menu);

    JMenuItem saveUtf8 = new JMenuItem(UTF8);
    JMenuItem saveIso = new JMenuItem(ISO88592);
    JMenuItem saveCp = new JMenuItem(CP1250);

    saveUtf8.addActionListener(this);
    saveIso.addActionListener(this);
    saveCp.addActionListener(this);

    menu.add(saveUtf8);
    menu.add(saveIso);
    menu.add(saveCp);
    frame.setJMenuBar(mb);
    frame.add(textArea);
    frame.setSize(650, 400);
    frame.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String text = textArea.getText();
    JFileChooser j = new JFileChooser("./");

    if(j.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
      try {
        File file = new File(j.getSelectedFile().getAbsolutePath());
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, recognizeEncoding(e.getActionCommand()));
        outputStreamWriter.write(text);
        outputStreamWriter.flush();
        outputStreamWriter.close();
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    }
  }

  private Charset recognizeEncoding(String inputId){
    return switch (inputId) {
      case UTF8 -> StandardCharsets.UTF_8;
      case CP1250 -> Charset.forName("windows-1250");
      case ISO88592 -> Charset.forName("ISO-8859-2");
      default -> throw new IllegalArgumentException("This encoding is not supported");
    };
  }
}

package pwj.mjanocha.z9;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class TextEditor extends JPanel implements ActionListener {
  private final static String ACTION_ZIP   = "ZIP";
  private final static String ACTION_UNZIP = "UNZIP";

  TextEditor() {
    JButton zip = new JButton("Spakuj");
    JButton unzip = new JButton("Rozpakuj");

    zip.setActionCommand(ACTION_ZIP);
    unzip.setActionCommand(ACTION_UNZIP);

    zip.addActionListener(this);
    unzip.addActionListener(this);

    add(zip);
    add(unzip);
  }

  public static void showGui() {
    JFrame frame = new JFrame("Pakowacz");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    TextEditor newContentPane = new TextEditor();
    newContentPane.setOpaque(true);
    frame.setContentPane(newContentPane);
    frame.pack();
    frame.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    JFileChooser j = new JFileChooser("./");
    FileNameExtensionFilter zipFilter = new FileNameExtensionFilter("Spakowane pliki (GZ)", "gz");

    if (ACTION_UNZIP.equals(e.getActionCommand())) {
      j.setFileFilter(zipFilter);
    }

    if (j.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
      try {
//        FileInputStream fileInputStream = ;
        switch (e.getActionCommand()) {
          case ACTION_ZIP ->
            zipFile(Path.of(j.getSelectedFile().getAbsolutePath()), Path.of(j.getSelectedFile().getAbsolutePath()));
          case ACTION_UNZIP ->
            unzipFile(Path.of(j.getSelectedFile().getAbsolutePath()), Path.of(j.getSelectedFile().getAbsolutePath()));
        }
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    }
  }

  private void zipFile(Path sourcePath, Path targetPath) throws IOException {

    FileOutputStream fileOutputStream = new FileOutputStream(renameFile(targetPath, "gz"));
    GZIPOutputStream gzipOutputStream = new GZIPOutputStream(fileOutputStream);

    Files.copy(sourcePath, gzipOutputStream);

    gzipOutputStream.close();
  }

  private void unzipFile(Path sourcePath, Path targetPath) throws IOException {
    FileInputStream fileInputStream = new FileInputStream(sourcePath.toFile());
    GZIPInputStream gzipInputStream = new GZIPInputStream(fileInputStream);

    Path path = targetPath.resolveSibling(renameFile(targetPath, "txt").toPath());
    Files.copy(gzipInputStream, path, StandardCopyOption.REPLACE_EXISTING);
  }

  private File renameFile(Path filePath, String targetExtension){
    int i = filePath.toFile().getName().lastIndexOf('.');
    String name = filePath.toFile().getName().substring(0,i);
    return new File(filePath.getParent().toString(), name + "." + targetExtension);
  }

}

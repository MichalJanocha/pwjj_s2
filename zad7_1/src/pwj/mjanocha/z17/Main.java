package pwj.mjanocha.z17;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Date;

public class Main {

  public static void main(String[] args) {
    String nazwahosta;
    if (args.length > 0) {
      nazwahosta = args[0];
    } else {
      nazwahosta = "time-a.nist.gov";
    }
    try {
      Socket gniazdo = new Socket(nazwahosta, 37);
      InputStream strumien = gniazdo.getInputStream();
      int wynik = 0;
      long wynikL = 0l;
      while (true) {
        wynik = strumien.read();
        if (wynik < 0) {
          break;
        }
        wynikL = wynikL << 8;
        wynikL = wynikL | wynik;
      }
      ;
      Date d = new Date(wynikL);
      System.out.println(d);
    } catch (IOException e) {
      System.err.println(e);
    }
  }

}
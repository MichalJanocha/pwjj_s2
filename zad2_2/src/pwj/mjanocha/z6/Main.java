package pwj.mjanocha.z6;

public class Main {
  public static void main(String[] args) {
    QuadEquation quadEquation = new QuadEquation(2,8,7);
    System.out.println("y dla x=-4 wynosi: " + quadEquation.countY(-4));

    quadEquation.setA(1);
    quadEquation.setB(-8);
    quadEquation.setC(12);
    System.out.println("Liczba pierwiastkow dla "+quadEquation+": " + quadEquation.countSqrts());

    quadEquation.setA(1);
    quadEquation.setB(0);
    quadEquation.setC(0);
    System.out.println("Liczba pierwiastkow dla "+quadEquation+": " + quadEquation.countSqrts());

    quadEquation.setA(1);
    quadEquation.setB(6);
    quadEquation.setC(10);
    System.out.println("Liczba pierwiastkow dla "+quadEquation+": " + quadEquation.countSqrts());

  }
}

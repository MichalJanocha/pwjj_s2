package pwj.mjanocha.z5;

public class Main {
  public static void main(String[] args) {
    Rational a = new Rational(1,2);
    Rational b = new Rational(1,3);

    System.out.println(a.add(b));

    Rational a1 = new Rational(2,5);
    Rational b1 = new Rational(1,10);

    System.out.println(a1.add(b1));

    Rational a2 = new Rational(2,5);
    Rational b2 = new Rational(3,7);

    System.out.println(a2.mul(b2));

    Rational a3 = new Rational(3,4);
    Rational b3 = new Rational(2,5);

    System.out.println(a3.mul(b3));

    Rational a4 = new Rational(1,2);
    Rational b4 = new Rational(1,3);

    System.out.println(a4.sub(b4));

    Rational a5 = new Rational(1,5);
    Rational b5 = new Rational(1,10);

    System.out.println(a5.sub(b5));

    Rational a6 = new Rational(15,21);
    Rational b6 = new Rational(3,7);

    System.out.println(a6.div(b6));

    Rational a7 = new Rational(7,9);
    Rational b7 = new Rational(4,5);

    System.out.println(a7.div(b7));

    Rational a8 = new Rational(1,2);
    Rational b8 = new Rational(12,24);

    System.out.println(a8.equals(b8));

    Rational a9 = new Rational(2,2);
    Rational b9 = new Rational(12,24);

    System.out.println(a9.equals(b9));

    Rational a10 = new Rational(2,2);
    Rational b10 = new Rational(5000,5000);

    System.out.println(a10.equals(b10));

    Rational a11 = new Rational(4,7);
    Rational b11 = new Rational(3,7);

    System.out.println(a11.compareTo(b11));

    Rational a12 = new Rational(7,8);
    Rational b12 = new Rational(7,11);

    System.out.println(a12.compareTo(b12));

    Rational a13 = new Rational(3,8);
    Rational b13 = new Rational(12,16);

    System.out.println(a13.compareTo(b13));

    Rational a14 = new Rational(1,2);
    Rational b14 = new Rational(7,14);

    System.out.println(a14.compareTo(b14));

    Rational a15 = new Rational(3,9);
    Rational b15 = new Rational(12,36);

    System.out.println(a15.compareTo(b15));
  }
}

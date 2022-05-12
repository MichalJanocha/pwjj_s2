package pwj.mjanocha.z5;

public record Rational(int nominator, int denominator) {

  public Rational add(Rational arg) {
    int commonDenominator = this.denominator * arg.denominator();
    int sum = (this.nominator() * arg.denominator()) + (this.denominator() * arg.nominator());
    int gcd = round(sum, commonDenominator);
    return new Rational(sum / gcd, commonDenominator / gcd);
  }

  public Rational mul(Rational arg) {
    int commonDenominator = this.denominator * arg.denominator();
    int mul = this.nominator * arg.nominator();
    int gcd = round(mul, commonDenominator);
    return new Rational(mul / gcd, commonDenominator / gcd);
  }

  public Rational sub(Rational arg) {
    int commonDenominator = this.denominator * arg.denominator();
    int sub = (this.nominator() * arg.denominator()) - (this.denominator() * arg.nominator());
    int gcd = round(sub, commonDenominator);
    return new Rational(sub / gcd, commonDenominator / gcd);
  }

  public Rational div(Rational arg) {
    int commonDenominator = this.denominator * arg.nominator();
    int sub = this.nominator * arg.denominator();
    int gcd = round(sub, commonDenominator);
    return new Rational(sub / gcd, commonDenominator / gcd);
  }

  public boolean equals(Rational arg) {
    int gcd1 = round(this.nominator, this.denominator);
    int gcd2 = round(arg.nominator, arg.denominator);
    return ((nominator / gcd1) == (arg.nominator / gcd2)) && ((denominator / gcd1) == (arg.denominator / gcd2));
  }

  public int compareTo(Rational arg) {
    int thisNominator = (this.nominator() * arg.denominator());
    int argNominator = (this.denominator() * arg.nominator());

    if (this.equals(arg)) {
      return 0;
    }

    if (thisNominator > argNominator) {
      return 1;
    } else {
      return -1;
    }
  }

  public String toString() {
    return this.nominator + "/" + this.denominator;
  }

  private int round(int a, int b) {
    while (b != 0) {
      int c = a % b;
      a = b;
      b = c;
    }
    return a;
  }
}

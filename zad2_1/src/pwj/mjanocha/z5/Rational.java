package pwj.mjanocha.z5;

public class Rational {
  private final int nominator;
  private final int denominator;

  public Rational(int nominator, int denominator){
    this.nominator = nominator;
    this.denominator = denominator;
  }

  public int getDenominator() {
    return denominator;
  }

  public int getNominator() {
    return nominator;
  }

  public Rational add(Rational arg){
    int commonDenominator = this.denominator * arg.getDenominator();
    int sum = (this.getNominator() * arg.getDenominator()) + (this.getDenominator() * arg.getNominator());
    int gcd = round(sum, commonDenominator);
    return new Rational(sum/gcd, commonDenominator/gcd);
  }

  public Rational mul(Rational arg){
    int commonDenominator = this.denominator * arg.getDenominator();
    int mul = this.nominator * arg.getNominator();
    int gcd = round(mul, commonDenominator);
    return new Rational(mul/gcd, commonDenominator/gcd);
  }

  public Rational sub(Rational arg){
    int commonDenominator = this.denominator * arg.getDenominator();
    int sub = (this.getNominator() * arg.getDenominator()) - (this.getDenominator() * arg.getNominator());
    int gcd = round(sub, commonDenominator);
    return new Rational(sub/gcd, commonDenominator/gcd);
  }

  public Rational div(Rational arg){
    int commonDenominator = this.denominator * arg.getNominator();
    int sub = this.nominator * arg.getDenominator();
    int gcd = round(sub, commonDenominator);
    return new Rational(sub/gcd, commonDenominator/gcd);
  }

  public boolean equals(Rational arg){
    int gcd1 = round(this.nominator, this.denominator);
    int gcd2 = round(arg.nominator, arg.denominator);
    return ((nominator/gcd1) == (arg.nominator/gcd2)) && ((denominator/gcd1) == (arg.denominator/gcd2));
  }

  public int compareTo(Rational arg){
//    int commonDenominator = this.denominator * arg.getNominator();
//
//
//    int gcd1 = round(this.nominator, this.denominator);
//    int gcd2 = round(arg.nominator, arg.denominator);
//    boolean equal = ((nominator / gcd1) == (arg.nominator / gcd2)) && ((denominator / gcd1) == (arg.denominator / gcd2));
    int commonDenominator = this.denominator * arg.getDenominator();
    int thisNominator = (this.getNominator() * arg.getDenominator());
    int argNominator = (this.getDenominator() * arg.getNominator());

    if(this.equals(arg)){
      return 0;
    }

    if(thisNominator > argNominator){
      return 1;
    }else{
      return -1;
    }
  }

  public String toString(){
    return this.nominator + "/" + this.denominator;
  }

  private int round(int a, int b){
    while(b != 0){
      int c = a % b;
      a = b;
      b = c;
    }
    return a;
  }
}

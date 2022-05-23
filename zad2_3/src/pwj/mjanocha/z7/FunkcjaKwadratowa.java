package pwj.mjanocha.z7;

public class FunkcjaKwadratowa extends Wielomian{
  public FunkcjaKwadratowa(Integer a, Integer b, Integer c) {
    super(a, b, c);
  }

  @Override
  public void wypiszMiejscaZerowe() {
    double delta = delta();
    if(delta < 0.0){
      System.out.println("brak");
    }

    if(delta == 0.0){
      System.out.println((getB()*-1)/(2*getA()));
    }

    if(delta > 0.0){
      System.out.println(nOne(delta) + " " + nTwo(delta));
    }
  }

  private double nOne(double delta){
    return ((getB() * -1)-Math.sqrt(delta))/(2*getA());
  };

  private double nTwo(double delta){
    return ((getB() * -1)+Math.sqrt(delta))/(2*getA());
  }

  private double delta() {
    return (this.getB() * this.getB()) - (4*this.getA()*this.getC());
  };
}

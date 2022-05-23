package pwj.mjanocha.z7;

public class FunkcjaLiniowa extends Wielomian{
  public FunkcjaLiniowa(Integer a, Integer b) {
    super(a, b);
  }

  @Override
  public void wypiszMiejscaZerowe() {
    System.out.println((double) (this.getB() * -1)/this.getA());
  }
}

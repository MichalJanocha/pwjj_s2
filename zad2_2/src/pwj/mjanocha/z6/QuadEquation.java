package pwj.mjanocha.z6;

import java.math.BigDecimal;

public class QuadEquation {
  private BigDecimal a;
  private BigDecimal b;
  private BigDecimal c;

  public QuadEquation(){}

  public QuadEquation(Integer a, Integer b, Integer c){
    setA(a);
    setB(b);
    setC(c);
  }

  public void setA(Integer a) {
    this.a = BigDecimal.valueOf(a);
  }

  public void setB(Integer b) {
    this.b = BigDecimal.valueOf(b);
  }

  public void setC(Integer c) {
    this.c = BigDecimal.valueOf(c);
  }

  public BigDecimal countY(Integer x){
    BigDecimal bX = BigDecimal.valueOf(x);
    return a.multiply(bX.pow(2)).add(b.multiply(bX)).add(c);
  }

  public int countSqrts(){
    BigDecimal delta = delta();
    int comparison = delta.compareTo(BigDecimal.ZERO);
    return comparison + 1;
  }

  public String toString(){
    return this.getClass().getSimpleName()+"(a="+a+", b="+b+", c="+c+")";
  }

  private BigDecimal delta() {
    return b.pow(2).subtract(BigDecimal.valueOf(4).multiply(a).multiply(c));
  }

}

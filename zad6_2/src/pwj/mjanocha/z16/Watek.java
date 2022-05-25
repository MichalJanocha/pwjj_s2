package pwj.mjanocha.z16;

class Watek extends Thread {

  private KolejkaKomunikatow koko;
  private int                istart;

  public Watek(KolejkaKomunikatow kk, int pocz) {
    koko = kk;
    istart = pocz;
  }

  public void run() {
    try {
      for (int i = istart; i <= 10; i += 2) {
        System.out.println(this.getName());
        koko.wyslij(String.valueOf(i), new Integer(i));
        Thread.sleep(50);
      }
    } catch (InterruptedException e) {
    }
    ;
  }
}

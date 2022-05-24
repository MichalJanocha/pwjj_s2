package pwj.mjanocha.z10;

import java.util.*;
import java.util.stream.Collectors;

public class Graf {
  private int          n; // liczba wierzchołków, V = {0,1,...,n-1}
  private LinkedList[] tab; // tablica wierzchołków połączo-
                            // nych z danym wierzcholkiem

  public Graf(String lan) {
    StringTokenizer st = new StringTokenizer(lan, "() ,");
    n = Integer.parseInt(st.nextToken());
    tab = new LinkedList[n];
    for (int i = 0; i < n; ++i) tab[i] = new LinkedList();
    while (st.hasMoreTokens()) {
      tab[Integer.parseInt(st.nextToken())].add(new Integer(st.nextToken()));
    }
  }

  @Override
  public String toString() {
    StringBuilder stringBuffer = new StringBuilder();

    Object[] objects = Arrays.stream(tab).toArray();
    int i=0;
    for (Object object : objects) {
      stringBuffer.append(i).append(": ").append(object.toString().replaceAll("\\[|\\]|,", "")).append("\n");
      i++;
    }

    return stringBuffer.toString();
  }
}
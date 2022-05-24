public class Wspolrzedna implements Comparable<Wspolrzedna> {

    private final int x, y;

    public Wspolrzedna(int _x, int _y) {
        x = _x;
        y = _y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    @Override
    public int compareTo(Wspolrzedna o) {
        if (this.x == o.x && this.y == o.y) {
            return 0;
        }
        if ((this.x < o.x) || (this.x == o.x && this.y <= o.y)) {
            return -1;
        }
        if ((this.x > o.x) || (this.x == o.x && this.y > o.y)) {
            return 1;
        }
        return 0;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.x;
        hash = 23 * hash + this.y;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Wspolrzedna other = (Wspolrzedna) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        return true;
    }


}

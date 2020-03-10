public class Herd {
    private int bulls;
    private int cows;

    public Herd(int bulls, int cows) {
        this.bulls = bulls;
        this.cows = cows;
    }

    public int getBulls() {
        return bulls;
    }

    public int getCows() {
        return cows;
    }

    @Override
    public String toString() {
        return bulls + " Bull(s) \n" + cows + " Cow(s)";
    }
}

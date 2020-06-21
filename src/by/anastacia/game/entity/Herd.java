package by.anastacia.game.entity;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Herd)) return false;
        Herd herd = (Herd) o;
        return bulls == herd.bulls &&
                cows == herd.cows;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bulls, cows);
    }
}

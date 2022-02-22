package racingcar.domain.car;

public class Position implements Comparable<Position> {
    private int position;

    public Position(int position) {
        this.position = position;
    }

    public void increase() {
        position++;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public int compareTo(Position o) {
        return position - o.position;
    }
}

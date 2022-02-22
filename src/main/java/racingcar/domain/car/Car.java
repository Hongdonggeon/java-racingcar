package racingcar.domain.car;

import racingcar.domain.numbergenerator.NumberGenerator;

import java.util.Objects;

public class Car {
    private static final int MOVE_CRITERIA = 4;
    private static final int POSITION_INITIALIZATION = 0;

    private final Name name;
    private final Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position(POSITION_INITIALIZATION);
    }

    public boolean isPosition(Position position) {
        return this.position.compareTo(position) == 0;
    }

    public void move(NumberGenerator numberGenerator) {
        int number = numberGenerator.generateNumber();

        if (number >= MOVE_CRITERIA) {
            position.increase();
        }
    }

    public String getName() {
        return name.getName();
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Car car = (Car) o;
        return Objects.equals(name.getName(), car.name.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name.getName());
    }
}

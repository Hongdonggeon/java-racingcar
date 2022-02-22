package racingcar.domain.car;

import racingcar.domain.numbergenerator.NumberGenerator;
import racingcar.dto.CarsDto;
import racingcar.dto.WinnerCarsDto;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final String DUPLICATED_NAME_ERROR = "[ERROR] 차 이름은 중복될 수 없습니다.";
    private static final String NOT_EXIST_CAR = "[ERROR] 차가 존재하지 않습니다.";

    private final List<Car> cars;

    public Cars(List<Car> carList) {
        validateDuplicatedCarName(carList);
        cars = carList;
    }

    public int getNumberOfCar() {
        return cars.size();
    }

    private void validateDuplicatedCarName(List<Car> carList) {
        if (carList.size() != carList.stream().distinct().count()) {
            throw new IllegalArgumentException(DUPLICATED_NAME_ERROR);
        }
    }

    public Position getMaxPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .max(Comparator.comparing(position -> position))
                .orElseThrow(() -> new IllegalArgumentException(NOT_EXIST_CAR));
    }

    public List<Car> getSamePositionCar(Position position) {
        return cars.stream()
                .filter(car -> car.isPosition(position))
                .collect(Collectors.toList());

    }

    public CarsDto move(NumberGenerator numberGenerator) {
        for (Car car : cars) {
            car.move(numberGenerator);
        }
        return CarsDto.from(cars);
    }

    public WinnerCarsDto judgeWinner() {
        List<Car> winnerCars = getSamePositionCar(getMaxPosition());
        return WinnerCarsDto.from(winnerCars);
    }
}

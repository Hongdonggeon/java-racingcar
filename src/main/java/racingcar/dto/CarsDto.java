package racingcar.dto;

import racingcar.domain.car.Car;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CarsDto {
    private final Map<String, Integer> carsStatus;

    public CarsDto(Map<String, Integer> carStatus) {
        this.carsStatus = carStatus;
    }

    public static CarsDto from(List<Car> cars) {
        Map<String, Integer> carStatus = new LinkedHashMap<>();
        for (Car car : cars) {
            carStatus.put(car.getName(), car.getPosition());
        }
        return new CarsDto(carStatus);
    }

    public Map<String, Integer> getCarsStatus() {
        return carsStatus;
    }
}

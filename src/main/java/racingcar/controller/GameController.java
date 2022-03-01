package racingcar.controller;

import racingcar.domain.car.CarFactory;
import racingcar.domain.car.Cars;
import racingcar.domain.numbergenerator.RandomNumberGenerator;
import racingcar.dto.CarsDto;
import racingcar.dto.TotalCarsDto;
import racingcar.dto.WinnerCarsDto;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private static final String NEGATIVE_ERROR_MESSAGE = "[ERROR] 음수를 입력할 수 없습니다";
    private static final int ERROR_CRITERIA_VALUE_ZERO = 0;

    private Cars cars;

    public void createCars(String carNames) {
        cars = new Cars(CarFactory.from(carNames));
    }

    public int createGameCount(int gameCount) {
        return validateGameCount(gameCount);
    }

    private int validateGameCount(int gameCount) {
        if (gameCount < ERROR_CRITERIA_VALUE_ZERO) {
            throw new IllegalArgumentException(NEGATIVE_ERROR_MESSAGE);
        }
        return gameCount;
    }

    public TotalCarsDto play(int gameCount) {
        List<CarsDto> carsDtos = new ArrayList<>();
        for (int i = 0; i < gameCount; i++) {
            carsDtos.add(cars.move(new RandomNumberGenerator()));
        }
        WinnerCarsDto winnerCarsDto = cars.judgeWinner();
        return new TotalCarsDto(carsDtos, winnerCarsDto);
    }
}

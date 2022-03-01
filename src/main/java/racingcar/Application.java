package racingcar;

import racingcar.controller.GameController;
import racingcar.dto.TotalCarsDto;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController();

        gameController.createCars(InputView.inputCarNames());
        int gameCount = gameController.createGameCount(InputView.inputGameCount());
        OutputView.printGameResultTitle();
        TotalCarsDto totalCarsDto = gameController.play(gameCount);
        OutputView.printTotalCarStatus(totalCarsDto.getCarsDtos());
        OutputView.printWinner(totalCarsDto.getWinnerCarsDto());
    }
}

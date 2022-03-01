package racingcar.dto;

import java.util.ArrayList;
import java.util.List;

public class TotalCarsDto {
    private List<CarsDto> carsDtos = new ArrayList<>();
    private WinnerCarsDto winnerCarsDto;

    public TotalCarsDto(List<CarsDto> carsDtos, WinnerCarsDto winnerCarsDto) {
        this.carsDtos = carsDtos;
        this.winnerCarsDto = winnerCarsDto;
    }

    public WinnerCarsDto getWinnerCarsDto() {
        return winnerCarsDto;
    }

    public List<CarsDto> getCarsDtos() {
        return carsDtos;
    }
}

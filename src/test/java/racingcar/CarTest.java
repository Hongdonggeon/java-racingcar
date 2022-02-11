package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.Test;

public class CarTest {
	private static final String ERROR_MESSAGE = "[ERROR]";

	@Test
	public void 차_생성() {
		String name = "forky";
		Car car = new Car(name);
		assertThat(car.getName()).isEqualTo(name);
	}

	@Test
	public void 차_여러대_생성() {
		String names = "forky,kun";
		Set<Car> cars = CarFactory.of(names);
		assertThat(cars.size()).isEqualTo(2);
	}

	@Test
	public void 이름_5글자_이상() {
		assertThatThrownBy(() -> new Car("abcdef"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageStartingWith(ERROR_MESSAGE);
	}

	@Test
	public void 공백_이름() {
		assertThatThrownBy(() -> new Car(""))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageStartingWith(ERROR_MESSAGE);
	}

	@Test
	public void 중복된_이름() {
		assertThatThrownBy(() -> CarFactory.of("forky,forky"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageStartingWith(ERROR_MESSAGE);
	}

	@Test
	public void toString_kun() {
		Car car = new Car("kun");
		assertThat(car.toString()).startsWith("kun : ");
	}

	@Test
	public void toString_forky() {
		Car car = new Car("forky");
		assertThat(car.toString()).startsWith("forky : ");
	}

	@Test
	public void toString_position_1() {
		Car car = new Car("kun");
		car.move();
		assertThat(car.toString()).isEqualTo("kun : -");
	}

	@Test
	public void toString_position_3() {
		Car car = new Car("kun");
		for (int i = 0; i < 3 ; i++) {
			car.move();
		}
		assertThat(car.toString()).isEqualTo("kun : ---");
	}
}

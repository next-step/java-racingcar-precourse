package car;

import java.util.Objects;

public class Car {
	private String name;
	private int position;

	public Car(String name, int position) {
		this.name = name;
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Car car = (Car)o;
		return position == car.position && name.equals(car.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, position);
	}

	public void forward() {
		position++;
	}
}

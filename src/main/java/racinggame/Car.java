package racinggame;

public class Car {

	private Name name;
	private Position position;

	public Car(String name) {
		this.name = new Name(name);
		this.position = new Position();
	}

	public void move(Generator generator) {
		position.move(generator);
	}

	public void printCurrentStatus() {
		System.out.println(String.format("%s : %s", getName(), getPosition()));
	}

	private String getName() {
		return name.getName();
	}

	private String getPosition() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < position.getPosition(); i++) {
			sb.append("-");
		}
		return sb.toString();
	}

}

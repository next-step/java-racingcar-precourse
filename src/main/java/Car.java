import utils.ScannerUtils;

public class Car {

	private String name;
	private int position;

	Car(String name) {
		if (!ScannerUtils.isValidCarName(name)) {
			throw new IllegalArgumentException("사용할 수 없는 이름입니다. :" + name);
		}
		this.name = name;
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

	public void move(int randomNumber) {
		if (randomNumber >= 4) {
			this.position++;
		}
	}

	public String getPositionString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < this.position; i++) {
			sb.append("-");
		}
		return sb.toString();
	}
}

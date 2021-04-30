import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Car {
	private String name;
	private int score;
	
	public Car(String name) {
		this.name = name;
		this.score = 0;
	}
	
	public String getCarName() {
		return name;
	}
	
	public int getCarScore() {
		return score;
	}
	
	public void addScore() {
		if(new Random().nextInt(9) >= 4) {
			score++;
		}
	}
}

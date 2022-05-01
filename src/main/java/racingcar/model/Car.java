package racingcar.model;

/**
 * Created by eunbi on 2022/04/23
 */
public class Car {
	private String name;
	private int move;

	public Car(String name) {
		this.name = name;
		this.move = 0;
	}

	public void addMove(int move){
		this.move += move;
	}

	public String getName() {
		return name;
	}

	public int getMove() {
		return move;
	}

	@Override
	public String toString() {
		String resultStr = "";
		resultStr += this.getName()+ " : " ;
		for(int i=0;i<this.move;i++){
			resultStr += "-";
		}
		return resultStr;
	}
}

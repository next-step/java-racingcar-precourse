package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingcarStack {
	public static final String START_RESULT_MSG = "실행결과";
	public static final String POSITION_ICON = "-";
	private List<Cars> racingCarStack;
	
	public RacingcarStack() {
		this.racingCarStack = new ArrayList<Cars>();
	}
	
	public void add(Cars cars) {
		List<Car> cars2 = new ArrayList<Car>();
		for(Car car: cars.getCars()) {
			cars2.add(new Car(car.getName(), car.getPosition()));
		}
		racingCarStack.add(new Cars(cars2));
	}
	
	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer(START_RESULT_MSG);
		stringBuffer.append("\n");
		for(Cars cars: racingCarStack) {
			stringBuffer.append(carsPrint(cars));
		}
		return stringBuffer.toString();
	}
	
	private StringBuffer carsPrint(Cars cars) {
		StringBuffer stringBuffer = new StringBuffer();
		for(Car car: cars.getCars()) {
			stringBuffer.append(carPrint(car));
		}
		stringBuffer.append("\n");
		return stringBuffer;
	}
	
	private StringBuffer carPrint(Car car) {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(car.getName());
		stringBuffer.append(" : ");
		stringBuffer.append(positionPrint(car.getPosition()));
		stringBuffer.append("\n");
		return stringBuffer;
	}
	
	private StringBuffer positionPrint(int position) {
		StringBuffer stringBuffer = new StringBuffer();
		for(int i=0;i<position;i++) {
			stringBuffer.append(POSITION_ICON);
		}
		return stringBuffer;
	}
}

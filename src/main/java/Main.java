import java.util.Scanner;

import controller.Controller;
import model.Cars;
import util.GameUtil;
import view.View;

public class Main {
	static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		View view = new View();
		view.outputInputCarName();
		String carName = GameUtil.removeAllSpaceInCarName(sc.nextLine());
		Cars cars = new Cars(GameUtil.createCars(carName));

		view.outputInputTryCount();
		int tryCount = sc.nextInt();
		Controller controller = new Controller(cars, view);
		controller.proceedEachTurn(tryCount);
	}
}

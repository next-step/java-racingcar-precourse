package racinggame.view;

import nextstep.utils.Console;
import racinggame.controller.GameController;
import racinggame.dto.ResponseDto;

public class GameViewer {
	private final GameController controller;

	public GameViewer() {
		controller = GameController.getInstance();
		showInputCarNamesView();
	}

	private void showInputCarNamesView() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
		ResponseDto response = controller.create(Console.readLine());
		if (response.isOk()) {
			showInputCountView();
		}
		else if (response.isError()) {
			System.out.println(response.getMessage());
			showInputCarNamesView();
		}
	}

	private void showInputCountView() {
		System.out.println("시도할 회수는 몇회인가요?");
		ResponseDto response = controller.run(Console.readLine());
		if (response.isOk()) {
			System.out.println(response.getMessage());
		}
		else if (response.isError()) {
			System.out.println(response.getMessage());
			showInputCountView();
		}
	}
}

package racingcar.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

import racingcar.domain.enumtype.InterfaceMsg;
import racingcar.domain.enumtype.ValidationMsg;
import racingcar.service.StringUtilService;
import racingcar.service.ValidatorService;

public class OperatorController {
	private ValidatorService validatorService = ValidatorService.getInstance();
	private StringUtilService stringUtilService = StringUtilService.getInstance();
	private List<String> carNameList = new ArrayList<>();

	// start: Singleton Holder
	private OperatorController() {
	}

	private static class InnerComputerService {
		private static final OperatorController instance = new OperatorController();
	}

	public static OperatorController getInstance() {
		return InnerComputerService.instance;
	}
	// end: Singleton Holder

	public List<String> getCarNameList() {
		return carNameList;
	}

	public void setCarNameList(List<String> carNameList) {
		this.carNameList = carNameList;
	}

	public void initOperator() {
		this.printMenu();
	}

	private void printMenu() {
		System.out.println(InterfaceMsg.GAME_INFO.getValue()); // 자동차 레이싱 게임 안내
		String inputCarName = RequestInputCarName();
		this.setCarNameList(validateCarNames(inputCarName));

		System.out.println(this.getCarNameList());
	}

	private String RequestInputCarName() {
		System.out.print(InterfaceMsg.REQUEST_INPUT_CAR_NAME.getValue());
		String inputCarName = readLine();
		System.out.println(inputCarName); // Player로부터 자동차 이름들을 입력받음

		return inputCarName;
	}

	// 유효성을 통과할 때까지 사용자로부터 자동차 이름들을 입력받는다. 유효성을 통과할 때 List<String>를 반환
	private List<String> validateCarNames(String inputCarName) {
		List<String> properCarNameList = new ArrayList<>();
		try {
			properCarNameList = this.properCarNameList(inputCarName);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage()); inputCarName = RequestInputCarName();
			return validateCarNames(inputCarName);
		}
		return properCarNameList;
	}

	private List<String> properCarNameList(String inputCarName) throws IllegalArgumentException {
		ValidationMsg validationMsg = validatorService.validateCarName(inputCarName);
		if (validationMsg != ValidationMsg.PROPER_TYPE) {
			throw new IllegalArgumentException(validationMsg.getValue());
		}

		return stringUtilService.splitByComma(inputCarName);
	}

}

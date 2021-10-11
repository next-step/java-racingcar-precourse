package racinggame.common;

public interface ConstValue {
	int MAX_NAME_SIZE = 5;
	int RANDOM_MIN_NUMBER = 0;
	int RANDOM_MAX_NUMBER = 9;
	int MOVE_POSSIBLE_CONDITION = 4;

	String INPUT_CAR_LIST = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)기준으로 구분)";
	String INPUT_ROUND_COUNT = "시도할 회수는 몇회인가요?";
	String OUTPUT_RACING_RESULT = "실행결과";
	String OUTPUT_PROCESS_MOVE = "-";
	String OUTPUT_DELIMITER = " : ";
}

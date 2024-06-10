package view;

import controller.RaceControllerInterface;

// 경기에 대해 사용자의 입력, 사용자에게 보여줄 출력을 담당하는 view
public interface RaceViewInterface {

    // user로부터 차의 이름들을 받는 메서드
    void userCarsInput();

    // user로부터 round 횟수를 받는 메서드
    void userRoundsInput();

    // view <-> controller 상호 참조를 위해 setter로 뒤늦게 추가
    // 좋은 방법은 아닌 것 같다
    void setRaceControllerInterface(RaceControllerInterface raceControllerInterface);

    // 한 횟수에서 차들의 진행도를 출력. observer의 update가 호출하는 메서드
    void printProgress();

    // 중간 안내문을 출력하는 메서드
    void printProcess();

    // 결과를 출력하는 메서드
    void printResult();

    // 사용자가 입력한 차의 정보가 잘못된 경우 경고를 출력하는 메서드 (5자 초과, 빈 입력)
    void printCarsErrorMessage();

    // 사용자가 입력한 round가 잘못된 경우 경고를 출력하는 메서드 (100 초과)
    void printRoundsArgumentErrorMessage();

    // 사용자가 입력한 round가 잘못된 경우 경고를 출력하는 메서드 (parse 불가)
    void printRoundsFormatErrorMessage();
}

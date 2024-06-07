public class RacingController {

    // 싱글톤 패턴 적용
    private static RacingController instance = new RacingController();

    private RacingController() {}

    public static RacingController getInstance() {
        return instance;
    }

    public void run(){
        setRace();      // 자동차 정보 입력, 이동횟수 입력
        race();         // 입력된 정보를 바탕으로 레이싱 진행
        printResult();  // 우승자 출력 (단, 우승자는 여러명일 수 있다)
    }

}
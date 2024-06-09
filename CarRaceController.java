public class CarRaceController {
    private CarRaceModel model;
    private CarRaceView view;
    private int raceNum; // 사용자 입력값 / 레이스 횟수

    public CarRaceController(CarRaceModel model, CarRaceView view) {
        this.model = model;
        this.view = view;
    }

    public void startRace(int raceNum) {
        this.raceNum = raceNum;
        for (int nowRace = 0; nowRace < raceNum; nowRace++) {
            model.race();
            view.printRaceInfo(model.getCarList(), model.getCarRaceInfo());
        }
        view.printResult(model.getCarList(), model.getCarRaceInfo(), model.getWinnerLength());
    }
}

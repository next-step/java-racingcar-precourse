import controller.RaceController;
import controller.RaceControllerInterface;
import model.Race;
import observer.Observer;
import observer.Subject;
import service.RaceService;
import service.RaceServiceInterface;
import view.RaceView;
import view.RaceViewInterface;

public class Application {

    public static void main(String[] args) {
        // Race 객체 생성
        Race race = new Race();

        // RaceService 객체 생성
        RaceService raceService = new RaceService(race, race);
        // RaceServivce 인스턴스를 각 인터페이스에 맞게 변수 생성. 느슨한 결합을 위함
        RaceServiceInterface raceServiceInterface = raceService;
        Subject subject = raceService;

        // RaceView 객체 생성
        RaceView raceView = new RaceView(raceServiceInterface);
        // RaceView 인스턴스를 각 인터페이스에 맞게 변수 생성. 느슨한 결합을 위함.
        RaceViewInterface raceViewInterface = raceView;
        Observer observer = raceView;

        // subject(RaceService)에 observer(raceview) 등록.
        // controller의 부담을 덜기 위함.
        subject.addObserver(observer);

        // RaceController  생성 및 인터페이스 변수 생성
        RaceControllerInterface raceController = new RaceController(raceService, raceViewInterface);
        // RaceView와 RaceController가 상호 참조하므로 seatter를 사용함.
        raceViewInterface.setRaceControllerInterface(raceController);

        // 컨트롤러를 사용한 서비스 시작
        raceController.init();
        raceController.play();
        raceController.end();
    }
}

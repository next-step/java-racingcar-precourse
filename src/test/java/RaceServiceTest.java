import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;
import service.CarServiceInterface;
import service.RaceService;
import service.RaceServiceInterface;

// 구체적 로직을 갖는 RaceService에 대한 테스트.
// 단순한 getter, setter에 대한 테스트는 생략하였습니다.
public class RaceServiceTest {

    // addCars를 통해 삽입이 잘 됐는지 확인
    @Test
    void addCarsTest() {
        // 객체와 삽입할 배열을 준비
        RaceServiceInterface raceService = new RaceService();
        String[] carsName = {"jih", "hyu", "abc", "xyz"};

        // 삽입 과정
        raceService.addCars(carsName);
        // 개수 구하고
        int numberOfCars = raceService.getNumberOfCars();
        // 삽입한 배열과 리스트의 원소가 동일하면 true를 반환하도록 함.
        boolean isEqual = IntStream.range(0, numberOfCars)
            .allMatch(i -> carsName[i].equals(raceService.getCars().get(i).getName()));

        // 삽입 배열과 리스트의 개수가 맞는지 확인
        Assertions.assertThat(numberOfCars).isEqualTo(carsName.length);
        // 삽입한 배열이 리스트에 잘 들어갔는지 확인
        Assertions.assertThat(isEqual).isTrue();
    }

    // addCars를 통해 5자 초과의 차 이름을 넣었을 때 예외 처리가 되는지 확인
    @Test
    void addCarsNameErrorTest() {
        // 객체와 삽입할 배열을 준비
        RaceServiceInterface raceService = new RaceService();
        String[] carsErrorName = {"abcdef", "abcd"};

        // 잘못된 경우에 대한 테스트 (5자 이상)
        Assertions.assertThatThrownBy(() -> raceService.addCars(carsErrorName))
            .isInstanceOf(IllegalArgumentException.class);
    }

    // addCars를 통해 아무 입력도 넣지 않았을 때 예외 처리가 되는지 확인
    @Test
    void addCarsEmptyErrorTest() {
        // 객체와 삽입할 배열을 준비
        RaceServiceInterface raceService = new RaceService();
        String[] empty = {};

        // 잘못된 경우에 대한 테스트 (빈 입력)
        Assertions.assertThatThrownBy(() -> raceService.addCars(empty))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getWinnersTest() {
        // 객체와 삽입할 배열을 준비
        RaceServiceInterface raceService = new RaceService();
        String[] carsName = {"jih", "hyu", "abc", "xyz"};

        // 삽입
        raceService.addCars(carsName);
        // round 설정 (= 3)
        raceService.setNumberOfRounds("3");
        // 경주 시작
        raceService.startRace();
        // 승자 목록 받아옴. getWinners 테스트
        List<CarServiceInterface> winners = raceService.getWinners();
        // 승자 중 한명의 진행도를 받아옴.
        int winnerProgress = winners.get(0).getProgress();
        // 우선 승자들끼리 진행도가 모두 같은지 확인하는 변수 생성
        boolean isWinnersProgressAllEqual = winners.stream().allMatch(car -> car.getProgress() == winnerProgress);
        // getWinners로 받아온 승자의 진행도가 실제로 가장 높은지 확인하는 변수 생성
        boolean isWinnerProgressTheHighest = raceService.getCars().stream().allMatch(car -> car.getProgress() <= winnerProgress);

        // 승자들끼리의 진행도를 확인
        Assertions.assertThat(isWinnersProgressAllEqual).isTrue();
        // getWinners로 받아온 승자가 진짜 승자인지 확인
        Assertions.assertThat(isWinnerProgressTheHighest).isTrue();
    }
}

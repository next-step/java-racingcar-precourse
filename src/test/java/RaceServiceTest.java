import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;
import service.RaceService;
import service.RaceServiceInterface;

// 구체적 로직을 갖는 RaceService에 대한 테스트.
// 단순한 getter, setter에 대한 테스트는 생략하였습니다.
public class RaceServiceTest {

    // addCars를 통해 삽입이 잘 됐는지 확인
    @Test
    void addCarsNumberTest() {
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
}

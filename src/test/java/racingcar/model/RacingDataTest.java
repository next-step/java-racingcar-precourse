package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.view.RacingView;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RacingDataTest {

    private List<Car> list;
    private RacingData rc;

    @BeforeEach
    void listUp (){
        list = new ArrayList<>();
        list.add(new Car("test1"));
        list.add(new Car("test2"));
        rc = new RacingData("test1,test2");
    }

    @Test
    void setRacingCarlist_ShouldGenerateCarList() {
        assertEquals(2, rc.getRacingCarlist().size());
        assertEquals("test2", rc.getRacingCarlist().get(1).getName());
    }

    @Test
    void newRacingCar_catchException() {
        assertThatIllegalArgumentException().isThrownBy(() -> new RacingData("test1 test2"));
    }

    @Test
    void newRacingCar_SuccessGen() {
        assertThatNoException().isThrownBy(()-> new RacingData("test1,test2"));
    }

    @Test
    void getWinnerDistance_afterEndGame_Success() {
        RacingData testLine = new RacingData("test1,test3");
        testLine.setTrys("4");
        testLine.setGoStops();
        testLine.setGoStops();
        testLine.setGoStops();
        testLine.setGoStops();
        assertThat(testLine.getWinnerDistance()).isLessThan(5);
    }

    @Test
    void setTrys_catchIllegalArguemntsException() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> {
                    RacingData testLine = new RacingData("test1,test2");
                    testLine.setTrys("ggg");
                }
        );
    }

    @Test
    void setTrys_SuccessNonExeption() {
        assertThatNoException().isThrownBy(
                ()->{
                    RacingData testLine = new RacingData("test1,test2");
                    testLine.setTrys("198");
                }
        );
    }
}
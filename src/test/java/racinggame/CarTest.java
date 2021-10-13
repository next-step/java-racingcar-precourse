package racinggame;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nextstep.test.NSTest;

public class CarTest extends NSTest {
	Car car;
	
	@BeforeEach
    void beforeEach() {
		this.car = new Car("james");
	}

    @Test
    @DisplayName("생성 실패")
    void fail() {
    	String name = "";
    	assertThrows(IllegalArgumentException.class, () -> {
    		new Car(name);
    	});
    }
    
    @Test
    @DisplayName("생성 성공")
    void success() {
    	String name = "terry";
    	assertDoesNotThrow(() -> {
    		new Car(name);
    	});
    }
    
    @Test
    @DisplayName("자동차 전진")
    void go() {    	
    	moveCar();
    	assertThat(car.getStep()).isEqualTo(1);
    	moveCar();
    	assertThat(car.getStep()).isEqualTo(2);
    	moveCar();
    	assertThat(car.getStep()).isEqualTo(3);
    }
    
    void moveCar() {
    	moveCar(1);
    }
    
    void moveCar(int cnt) {
    	for (int i = 0; i < cnt; i++) {
    		this.car.go();
    	}
    }
    
    @Test
    @DisplayName("자동차 상태 display")
    void showStatus() {
    	setUp();
    	moveCar(3);
    	assertSimpleTest(() -> {
    		car.showStatus();
            verify(car.getName() + " : ---");
    	});
    }
    
    @Test
    @DisplayName("우승자 여부 확인")
    void winner() {
    	moveCar(3);
    	assertThat(car.getStep()).isNotEqualTo(4);
    	assertThat(car.getStep()).isEqualTo(3);
    }

	@Override
	protected void runMain() {}
}

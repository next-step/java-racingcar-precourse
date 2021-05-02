package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    
    @Test
    @DisplayName("입력받은 값을 쉼표로 분리하여 객체에 할당")
    public void nameSplitTest() {
        
        String userInput = "bee, apple, joy, p";
        userInput = userInput.replace(" ", "");
        
        List<Car> carList = new ArrayList<>();
        
        String[] carNameArray;
        carNameArray = userInput.split(",");
        
        for (int i = 0; i < carNameArray.length; i++) {
            carList.add(new Car(carNameArray[i]));
        }
        
        assertThat(carList.get(0).getCarName()).isEqualTo("bee");
        assertThat(carList.get(1).getCarName()).isEqualTo("apple");
        
    }
    
    @Test
    @DisplayName("게임 진행시 숫자에 따라 전진하는 기능 테스트")
    public void playOneStepTest() {
        
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("1_Car"));
        carList.add(new Car("2_Car"));
        carList.add(new Car("3_Car"));
        carList.add(new Car("4_Car"));
        
        carList.get(0).play(3);
        carList.get(1).play(1);
        carList.get(2).play(5);
        carList.get(3).play(8);
        
        assertThat(carList.get(0).getCurrentPosition()).isEqualTo(0);
        assertThat(carList.get(1).getCurrentPosition()).isEqualTo(0);
        assertThat(carList.get(2).getCurrentPosition()).isEqualTo(1);
        assertThat(carList.get(3).getCurrentPosition()).isEqualTo(1);
        
        carList.get(0).play(0);
        carList.get(1).play(2);
        carList.get(2).play(3);
        carList.get(3).play(5);
        
        assertThat(carList.get(0).getCurrentPosition()).isEqualTo(0);
        assertThat(carList.get(1).getCurrentPosition()).isEqualTo(0);
        assertThat(carList.get(2).getCurrentPosition()).isEqualTo(1);
        assertThat(carList.get(3).getCurrentPosition()).isEqualTo(2);
        
        carList.get(0).play(9);
        carList.get(1).play(1);
        carList.get(2).play(2);
        carList.get(3).play(7);
        
        assertThat(carList.get(0).getCurrentPosition()).isEqualTo(1);
        assertThat(carList.get(1).getCurrentPosition()).isEqualTo(0);
        assertThat(carList.get(2).getCurrentPosition()).isEqualTo(1);
        assertThat(carList.get(3).getCurrentPosition()).isEqualTo(3);
        
    }
    
    @Test
    @DisplayName("입력한 횟수만큼 반복실행 테스트")
    public void iteratePlayTest() {
        
        Cars cars = new Cars("11aa, 22bb, 33cc, 44dd");

        System.out.println("시도할 회수는 몇회인가요?");
        //Scanner scanner = new Scanner(System.in);
        
        int playCnt = 5; //scanner.nextInt();
        
        for(int i = 0; i < playCnt; i++) {
            System.out.println("-----[" + i + "] stage-----");
            cars.play();
            System.out.println("---------------------");
        }
        
    }

    @Test
    @DisplayName("게임 진행상황 출력 테스트")
    public void stagePrintTest() {
        PlayResult result = new PlayResult();
        Cars cars = new Cars("11aa,22bb,33cc,44dd");
        
        cars.getCars().get(0).play(3);
        cars.getCars().get(1).play(1);
        cars.getCars().get(2).play(5);
        cars.getCars().get(3).play(8);
        
        result.printCurrentStatus(cars);
        
        assertThat(cars.getCars().get(0).getCurrentPosition()).isEqualTo(0);
        assertThat(cars.getCars().get(1).getCurrentPosition()).isEqualTo(0);
        assertThat(cars.getCars().get(2).getCurrentPosition()).isEqualTo(1);
        assertThat(cars.getCars().get(3).getCurrentPosition()).isEqualTo(1);

        cars.getCars().get(0).play(0);
        cars.getCars().get(1).play(2);
        cars.getCars().get(2).play(3);
        cars.getCars().get(3).play(5);
        
        result.printCurrentStatus(cars);
        
        assertThat(cars.getCars().get(0).getCurrentPosition()).isEqualTo(0);
        assertThat(cars.getCars().get(1).getCurrentPosition()).isEqualTo(0);
        assertThat(cars.getCars().get(2).getCurrentPosition()).isEqualTo(1);
        assertThat(cars.getCars().get(3).getCurrentPosition()).isEqualTo(2);

        cars.getCars().get(0).play(9);
        cars.getCars().get(1).play(1);
        cars.getCars().get(2).play(2);
        cars.getCars().get(3).play(7);
        
        result.printCurrentStatus(cars);
        
        assertThat(cars.getCars().get(0).getCurrentPosition()).isEqualTo(1);
        assertThat(cars.getCars().get(1).getCurrentPosition()).isEqualTo(0);
        assertThat(cars.getCars().get(2).getCurrentPosition()).isEqualTo(1);
        assertThat(cars.getCars().get(3).getCurrentPosition()).isEqualTo(3);

        result.printCurrentStatus(cars);
    }
}

import model.Race;
import util.ConvertInputUtil;

import java.util.List;
import java.util.Scanner;

public class RacingCar {
    public static void main(String[] args) {
        //TODO: 10줄이내로 줄이기
        Scanner scan = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> names = ConvertInputUtil.getCarNameFromInput(scan.next());
        Race race = new Race(names);

        System.out.println("시도할 회수는 몇회인가요?");
        int tryNumber = ConvertInputUtil.getTryNumberFromInput(scan.next());

        System.out.println("실행 결과");
        for(int i=0; i<tryNumber;i++){
            race.play();
            System.out.println(race.toString());
        }

        System.out.println(race.getWinner()+"가 최종 우승했습니다.");
    }
}

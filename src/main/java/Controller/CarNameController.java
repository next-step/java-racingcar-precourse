package Controller;

import DTO.Car;
import Service.CarNameService;
import View.Print;
import java.util.List;
import java.util.Scanner;

public class CarNameController {

    Print print = new Print();
    Scanner sc = new Scanner(System.in);
    CarNameService name = new CarNameService();

//    경주할 자동차명을 입력 받는다.
//    ,로 구분된 문자를 입력 받는다.
//    입력 검증 후 Car객체를 포함한 List를 반환한다.
//    잘못된 입력시 오류를 출력하고 다시 입력을 받는다.
    public List<Car> getCarNames() {

        while (true) {
            try {
                print.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
                String[] names = sc.nextLine().split(",");

                return name.checkNames(names);

            } catch (IllegalArgumentException e) {
                print.printError("IllegalArgumentException");
            }
        }
    }

}

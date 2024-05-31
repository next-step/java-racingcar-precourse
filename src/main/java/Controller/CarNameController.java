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

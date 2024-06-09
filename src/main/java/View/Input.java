package View;

import Model.Car;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import static java.lang.System.*;

public class Input {
    Scanner sc = new Scanner(System.in);

    public ArrayList<Car> getName() throws Exception {
        String carName;
        ArrayList<Car> carList= new ArrayList<Car>();

        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");

        try {
            carName = sc.next();
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

        StringTokenizer stk = new StringTokenizer(carName, ",");
        while (stk.hasMoreTokens()) {
            String token = stk.nextToken();

            // 자동차 이름이 5자 이상일 경우 예외처리
            if(token.length() > 5) {
                throw new Exception("[ERROR] NAME CAN BE UP TO 5 CHARACTERS LONG");
            }
            carList.add(new Car(token));
        }

        return carList;
    }

    public int getCount() {
        System.out.println("시도할 횟수는 몇회인가요?");

        int cntNum;

        try{
            cntNum = sc.nextInt();
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return cntNum;
    }
}

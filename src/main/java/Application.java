import static java.lang.Integer.parseInt;

import java.io.*;
import java.util.HashMap;
import java.util.Vector;

public class Application {

    public static void main(String[] args) throws IOException{
        Vector<Car> cars = new Vector<Car>();
        boolean carnamevalid;
        boolean attemptcountvalid;
        int attemptnumber = 0;

        //사용자 입력 받기
        do {
            InputHandler.CarNameInput(cars);
            carnamevalid = InputValidator.validateCarName(cars); //유효성 검사
        }while(!carnamevalid);

        do {
            attemptnumber = InputHandler.attemptCountInput();
            attemptcountvalid = InputValidator.validateAttemptCount(attemptnumber); //유효성 검사
        }while(!attemptcountvalid);


        //전진하기
        //우승자 선정
        //우승자 출력

    }

}
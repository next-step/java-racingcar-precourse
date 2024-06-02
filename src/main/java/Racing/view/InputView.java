package Racing.view;

import Racing.domain.Car;
import Racing.exception.InputException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//사용자 입력 시 보여지는 뷰.
public class InputView {

    InputException ie = new InputException();

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private String input;
    private List<String> carNameModel;
    private int tryModel;

    //자동차 이름 입력
    public void printCarNameInput(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        try{
            List<String> list = getInput();
            ie.inputValidation(list);
            carNameModel=list;
        }catch (IllegalArgumentException | IOException ie){
            System.out.println(ie.getMessage());
            printCarNameInput();
        }


    }

    //시도횟수 입력
    public void printTryInput(){
        System.out.println("시도할 회수는 몇회인가요?");
        try{
            String s = getTry();
            ie.isNumber(s);
            tryModel = Integer.parseInt(s);

        }catch (IllegalArgumentException | IOException ie){
            System.out.println(ie.getMessage());
            printTryInput();
        }
        System.out.println("실행 결과");
    }

    //input을 받는다. 받은 문자열을 ,기준으로 나눈 List를 반환한다.
    public List<String> getInput() throws IOException {
        input = br.readLine();
        return new ArrayList<>(Arrays.stream(input.split(",")).toList());
    }

    public String getTry() throws IOException{
        return br.readLine();
    }

    public List<String> getCarNameModel(){
        return carNameModel;
    }

    public int getTryModel(){
        return tryModel;
    }






}

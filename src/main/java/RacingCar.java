import java.util.*;

public class RacingCar {
    String[] nameList;
    int[] stepList;

    public RacingCar(){ }
    public void run(){
        printInputName();
        inputName();

    }
    public void printInputName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void inputName(){
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        this.nameList = text.split(",");
        this.stepList = new int[this.nameList.length];
    }


}

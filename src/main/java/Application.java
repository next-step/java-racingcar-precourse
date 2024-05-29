import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    static String[] nameArray;
    static List<String> nameList = new ArrayList<String>();
    public static void main(String[] args) {
        inputName();

    }

    static void inputName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        nameArray = name.split(",");
        nameList = new ArrayList<String>();
        for (int i = 0; i < nameArray.length; i++) {
            nameList.add(nameArray[i]);
        }
        vaildName();

    }
    static void vaildName(){ // 이름이 5자 이상이면 프로그램을 종료한다.
        for (int i = 0; i < nameArray.length; i++) {
            int nameLength = nameArray[i].length();
            if (nameLength > 5) {
                System.out.println("이름의 길이는 5자 이하로 만들어야 합니다.");
                return;
            }
        }
    }

}

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    static String[] nameArray;
    static List<String> nameList = new ArrayList<String>();
    static int chance;
    static List<Integer> arr = new ArrayList<Integer>();
    static List<Integer> cardistance = new ArrayList<Integer>();

    public static void main(String[] args) {
        inputName();
        if (vaildName() == false){ // validName 메서드 반환값이 false면 프로그램 종료
            return;
        }
        inputChance();
        makeNumber();
        for (int i = 0; i < nameArray.length; i++) { //각각의 자동차가 얼마나 전진했는지 저장할 리스트 요소 0으로 초기화
            cardistance.add(0);
        }
        goStop();

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
        System.out.println(nameList); // 배열에 잘 들어갔는지 확인용도

    }
    static boolean vaildName(){ // 이름이 5자 이상이면 프로그램을 종료한다.
        for (int i = 0; i < nameArray.length; i++) {
            int nameLength = nameArray[i].length();
            if (nameLength > 5) {
                System.out.println("이름의 길이는 5자 이하로 만들어야 합니다.");
                return false;
            }
        }
        return true;
    }
    static void inputChance(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        Scanner scan = new Scanner(System.in);
        chance = scan.nextInt();
    }
    static void makeNumber(){ // 0 ~ 9 사이의 난수 생성
        for (int i = 0; i < nameArray.length; i++) {
            arr.add((int) ((Math.random() * 10000) % 10)); // 0~1사이에 난수가 생성 되므로 10000을 곱한후 10으로 나눈 나머지로 만든다
        }
        System.out.println(arr);
    }
    static void goStop(){ //난수값이 4이상인지 판별후 앞으로 전진시키는 메서드
        List<Integer> carchance = new ArrayList<Integer>(); // 생성된 난수 값을 각각의 자동차에 부여할 리스트 생성
        for (int i = 0; i < arr.size(); i++) {
            carchance.add(arr.get(i));
        }
        System.out.println(carchance);

        for (int j = 0; j < carchance.size(); j++) { // 부여받은 난수가 4이상이면 cardistance의 값 1씩 추가해서 전진
            if (carchance.get(j) >= 4) {
                cardistance.set(j, cardistance.get(j) + 1);
            }
        }
        for (int i = 0; i < carchance.size(); i++) { // cardistance의 값만큼 "_" 반복 출력해 거리 출력
            System.out.println(nameList.get(i)+" : "+ "_".repeat(cardistance.get(i)));
        }
    }

}

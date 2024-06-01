import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    static String[] nameArray;
    static List<String> nameList = new ArrayList<String>();
    static int chance;
    static List<Integer> arr = new ArrayList<Integer>();
    static List<Integer> cardistance = new ArrayList<Integer>();
    static List<Integer> top = new ArrayList<Integer>();
    static int a = 0;
    static String name;

    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        Scanner scan = new Scanner(System.in);
        name = scan.nextLine();
        validName();
        inputChance();
        makeNumber();
        for (int i = 0; i < nameArray.length; i++) { //각각의 자동차가 얼마나 전진했는지 저장할 리스트 요소 0으로 초기화
            cardistance.add(0);
        }
        System.out.println("실행 결과");
        result();
        winner();
        printTop();
    }

    static void inputName() throws IllegalArgumentException{

        nameArray = name.split(",");
        nameList = new ArrayList<String>();
        for (int i = 0; i < nameArray.length; i++) {
            nameList.add(nameArray[i]);
        }
        System.out.println(nameList); // 배열에 잘 들어갔는지 확인용도
        for (int i = 0; i < nameArray.length; i++) {
            int nameLength = nameArray[i].length();
            if (nameLength > 5) { // 이름이 5자 이상이면 IllegalArgumentException를 발생
                throw new IllegalArgumentException();
            }
        }

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

    }
    static void goStop(){ //난수값이 4이상인지 판별후 앞으로 전진시키는 메서드
        List<Integer> carchance = new ArrayList<Integer>(); // 생성된 난수 값을 각각의 자동차에 부여할 리스트 생성
        for (int i = 0; i < arr.size(); i++) {
            carchance.add(arr.get(i));
        }
        for (int j = 0; j < carchance.size(); j++) { // 부여받은 난수가 4이상이면 cardistance의 값 1씩 추가해서 전진
            if (carchance.get(j) >= 4) {
                cardistance.set(j, cardistance.get(j) + 1);
            }
        }
        for (int i = 0; i < carchance.size(); i++) { // cardistance의 값만큼 "_" 반복 출력해 거리 출력
            System.out.println(nameList.get(i)+" : "+ "_".repeat(cardistance.get(i)));
        }
        System.out.println("\n");
        arr.clear(); // 생성되었던 난수 초기화
        makeNumber(); // 한 턴이 지날 때마다 난수 새로 생성
    }
    static void winner(){ // 우승자를 가려내는 메서드
        int max = 0; // 거리의 최댓값을 저장할 변수 max 선언
        for (int i = 0; i < cardistance.size(); i++){ // 최댓값 구하기
            if (cardistance.get(i) > max){
                max = cardistance.get(i);
            }
        }
        for (int i = 0; i < cardistance.size(); i++){
            if (cardistance.get(i) == max){
                top.add(i);
            }
        }
    }
    static void printTop(){ // 최종적으로 정해진 우승자를 출력하는 메서드
        System.out.print("최종 우승자 : ");
        // 우승자가 여러명인 경우 ","를 구분자로 출력한다.
        String[] topNameArray = new String[top.size()]; // 우승자 이름을 저장할 배열
        for (int i = 0; i < top.size(); i++){ // 리스트로부터 이름을 받아 배열로 저장
            topNameArray[i] = nameArray[top.get(i)];
        }
        String topName = String.join(",", topNameArray);//배열 요소들을 출력 할때 구분자 추가
        System.out.println(topName);
    }
    static void result(){ // 전진 결과를 출력할 메서드
        for (int i = 0; i < chance; i++) { // 시도할 횟수만큼 goStop메서드 호출
            goStop();
        }
    }
    static void validName(){ // 자동차의 이름이 5자 이하 인지 판별하는 메서드
        while (a == 0){
            try {
                inputName(); // 입력받은 자동차 이름이 모두 유효하면 반복문 탈출
                a = 1;
            }
            catch (IllegalArgumentException e) { // IllegalArgumentException를 받으면 에러메세지 출력후 다시 이름 입력 받기
                System.out.println("[ERROR] 이름의 길이는 5자 이하로 만들어야 합니다.");
                System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
                Scanner scan = new Scanner(System.in);
                name = scan.nextLine();
                nameArray = name.split(",");
            }
        }
    }
}

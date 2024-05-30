import java.util.*;

public class RacingCar {
    String[] nameList;
    int[] stepList;
    int tryNum;
    int maxNum=0;

    public RacingCar(){ }
    public void run(){
        printInputName();
        inputName();
        printTryNum();
        inputTryNum();
        printResult();
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

    public void printTryNum() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void inputTryNum(){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        this.tryNum = num;
    }

    public void oneStep(){
        for(int i=0;i<nameList.length;i++){
            Random random = new Random();
            int temp = random.nextInt(10);
            if(temp>=4) stepList[i]+=1;
            if(stepList[i]>this.maxNum)this.maxNum = stepList[i];
            printOneStep(i);
        }
        System.out.println();
    }

    public void printOneStep(int i){
        System.out.printf("%s : ",nameList[i]);
        for(int j=0;j<stepList[i];j++){
            System.out.print("-");
        }
        System.out.println();
    }

    public void printResult(){
        System.out.println("실행 결과");
        for(int i=0;i<this.tryNum;i++) {
            oneStep();
        }
        printWinner();
    }

    public void printWinner(){
        List<String> maxNames = new ArrayList<>();
        for(int j=0;j<nameList.length;j++){
            if(stepList[j] == maxNum){
                maxNames.add(nameList[j]);
            }
        }
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < maxNames.size(); i++) {
            System.out.print(maxNames.get(i));
            if (i < maxNames.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}

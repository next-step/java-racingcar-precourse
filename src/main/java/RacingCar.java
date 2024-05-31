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
        do{
            String text = scanner.nextLine();
            this.nameList = text.split(",");
        }while(!checkNameList());
        this.stepList = new int[this.nameList.length];
    }

    public boolean checkNameList(){
        boolean isValid = true;
        try{
            for(String str : this.nameList)
                checkName(str);
        }catch(IllegalArgumentException e){
            isValid = false;
            System.out.println(e.getMessage());
        }
        return isValid;
    }

    public void checkName(String str){
        if(str.length()>5 || str.isEmpty())
            throw new IllegalArgumentException("[ERROR] 이름 길이가 적절하지 않습니다.");
    }

    public void printTryNum() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void inputTryNum(){
        boolean isValid=true;
        int num=0;
        Scanner scanner = new Scanner(System.in);
        do{
            try{
                num = scanner.nextInt();
                checkNum(num);
            }catch(InputMismatchException e){
                isValid=false;
                System.out.println("[ERROR] 숫자를 입력해 주세요.");
            }catch(IllegalArgumentException e){
                isValid = false;
                System.out.println(e.getMessage());
            }
        }while(!isValid);
        this.tryNum = num;
    }

    public void checkNum(int num){
        if(num<=0) throw new IllegalArgumentException("[ERROR] 0보다 큰 숫자를 입력해 주세요.");
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

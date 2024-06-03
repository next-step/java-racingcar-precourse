import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Name {
    String[] NAME;
    int[] NAME_COUNT;
    int NUM;
    String[] RACE;
    int[] RACE_COUNT;
    String WINNER;
    int MAX;
    public Name(){
        WINNER="";
        MAX=0;
    }
    public void namesSplit(String NAMES){
        for(int i=0;i<NAMES.length();i++){
            if(!(NAMES.charAt(i)>='a'&&NAMES.charAt(i)<='z')&&!(NAMES.charAt(i)>='A'&&NAMES.charAt(i)<='Z')&&!(NAMES.charAt(i)==','))
                throw new IllegalArgumentException("[ERROR] 이름을 정확하게 입력하세요.");
            if(i!=0&&NAMES.charAt(i-1)==','&&NAMES.charAt(i)==',')
                throw new IllegalArgumentException("[ERROR] 이름을 정확하게 입력하세요.");
        }
        if(NAMES.charAt(NAMES.length()-1)==',')
            throw new IllegalArgumentException("[ERROR] 이름을 정확하게 입력하세요.");
    }
    public void countNames(){
        NAME_COUNT=new int[NAME.length];
        RACE=new String[NAME.length];
        RACE_COUNT=new int[NAME.length];
        Arrays.fill(RACE, "");
        Arrays.fill(RACE_COUNT, 0);
        for(int i=0;i<NAME_COUNT.length;i++){
            NAME_COUNT[i]=NAME[i].length();
            if(NAME_COUNT[i]>5) {
                throw new IllegalArgumentException("[ERROR] 이름을 정확하게 입력하세요.");
            }
        }
    }
    public void inputNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        Scanner sc=new Scanner(System.in);
        String NAMES=sc.nextLine();
        try{
            namesSplit(NAMES);
            NAME=NAMES.split(",");
            countNames();
        }catch(IllegalArgumentException e) {
            System.out.println("[ERROR] 이름을 정확하게 입력하세요.");
            inputNames();
        }
    }
    public void inputNum(){
        System.out.println("시도할 회수는 몇회인가요?");
        try{
            inputNumCheck();
        }catch(IllegalArgumentException e){
            System.out.println("[ERROR] 숫자를 입력하세요.");
            inputNum();
        }
    }
    public void inputNumCheck(){
        try{
            Scanner sc=new Scanner(System.in);
            NUM=sc.nextInt();
        }catch(InputMismatchException e){
            throw new IllegalArgumentException("[ERROR] 숫자를 입력하세요.");
        }
    }
    public void printGame(){
        System.out.println("실행결과");
        for(int i=0;i<NUM;i++){
            getRandom();
            for(int j=0;j<NAME.length;j++){
                System.out.println(NAME[j]+" : "+RACE[j]);
            }
            System.out.println();
        }
        getWinner();
    }
    public void getRandom(){
        for(int i=0;i<RACE.length;i++){
            Random random = new Random();
            int r=random.nextInt(10);
            if(r>=4){
                RACE[i]+="-";
                RACE_COUNT[i]+=1;
            }
            if(MAX<RACE_COUNT[i])
                MAX=RACE_COUNT[i];
        }
    }
    public void getWinner(){
        for(int i=0;i<RACE.length;i++){
            if(MAX==RACE_COUNT[i]&&!WINNER.isEmpty()){
                WINNER+=", "+NAME[i];
            }
            if(MAX==RACE_COUNT[i]&& WINNER.isEmpty()){
                WINNER+=NAME[i];
            }
        }
        System.out.println("최종 우승자 : "+WINNER);
    }
}
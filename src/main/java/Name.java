import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Name {
    String[] NAME;
    int[] NAME_COUNT;
    public Name(){
    }
    public void namesSplit(String NAMES){
        for(int i=0;i<NAMES.length();i++){
            if(!(NAMES.charAt(i)>='a'&&NAMES.charAt(i)<='z')&&!(NAMES.charAt(i)>='A'&&NAMES.charAt(i)<='Z')&&!(NAMES.charAt(i)==','))
                throw new IllegalArgumentException("[ERROR] 이름을 정확하게 입력하세요.");
            if(i!=0&&NAMES.charAt(i-1)==','&&NAMES.charAt(i)==',')
                throw new IllegalArgumentException("[ERROR] 이름을 정확하게 입력하세요.");
        }
    }
    public void countNames(){
        NAME_COUNT=new int[NAME.length];
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
}
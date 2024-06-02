package view;

import domain.Car;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class RacingView {

    public void startRacing(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }
    public String inputNames()  {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        sc.close();
        return s;
    }
    public int inputNumber(){
        boolean isNum=false;
        Scanner sc=new Scanner(System.in);
        String s="";
        while(!isNum) {
            s = sc.nextLine();
            if (isNumberic(s)){
                isNum=true;
            }
        }
        return Integer.parseInt(s);
    }
    public static boolean isNumberic(String str) {
        return str.chars().allMatch(Character::isDigit);
    }
    public void printWinners(List<Car> winners){

    }

}

package controller;

import java.util.InputMismatchException;
import java.util.Scanner;
import service.RacingService;
import view.RacingView;

public class RacingController {
    private final Scanner sc;
    private final RacingService rs;
    private final RacingView rv;
    private int n;
    public RacingController(){
        sc = new Scanner(System.in);
        rs = new RacingService();
        rv = new RacingView();
    }
    public void inputCarNames(){
        while(true) {
            rv.showInputCarNamesMsg();
            String nameStr = sc.nextLine();
            try {
                rs.enrollCars(nameStr);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public void inputNumOfTry(){
        while(true){
            rv.showInputNumOfTry();
            try{
                n = sc.nextInt();
                break;
            }catch (InputMismatchException e) {
                rv.errorMsgInputNumOfTry();
                sc.next();
            }
        }
    }
    public void racingStart(){
        rv.showRacingStartMsg();
        for(int i=0; i<n; i++){
            rs.round();
            rv.showRacing(rs.getCarRepository());
        }
    }
}

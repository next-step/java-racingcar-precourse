package Controller;
import Model.*;

public class RacingGame {
    int repeat;
    RacingGameCar[] carList ;//= new RacingGameCar[];

    public RacingGame(String[] carlist, int repeat) {
        RacingGameCar[] temp = new RacingGameCar[carlist.length];
        for(int i=0;i<carlist.length;i++) {
            temp[i]=new RacingGameCar(carlist[i],0);
        }
        this.carList = temp;
        this.repeat = repeat;
    }

    public void startGame(){
        ForwardLogic fw = new ForwardLogic();
        for(int i=0;i<this.repeat;i++){
            for(int j=0;j<this.carList.length;j++){
                if(fw.forwarding()) carList[j].forwardingCar();
            }

            for(int j=0;j<this.carList.length;j++){
                System.out.println(carList[j]);
            }
            System.out.println();
        }
    }
    // 승자
    public void endGame(){
        int maxForwarding = 0;
        for(int i=0;i<this.carList.length;i++){
            if(this.carList[i].getForward()>maxForwarding) maxForwarding=this.carList[i].getForward();
        }
        String ans = "최종 우승자 : ";
        for(int i=0;i<this.carList.length;i++){
            if(this.carList[i].getForward()==maxForwarding) ans+=this.carList[i].getCarName()+", ";
        }
        System.out.println(ans.substring(0, ans.length() - 2));
    }


}

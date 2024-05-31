package Util;

public class MoveOrNot {
    private MoveOrNot(){

    }
    //4 ~ 9라면 전진이므로 true, 아니면 false 리턴
    public static boolean checkMoveOrNot(int randomNumber){
        if(randomNumber >= 3 && randomNumber <= 9){
            return true;
        }
        return false;
    }

}

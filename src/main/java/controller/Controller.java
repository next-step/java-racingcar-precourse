package controller;
import java.util.*;

public class Controller {
    private Vector <String> carName;
    private int moveCnt;

    public void play(){ //자동차 경주 게임 전반의 흐름을 처리
         carName = EntryCarName.getCarName();
         moveCnt = EntryMoveCnt.getMoveCnt();
    }

}

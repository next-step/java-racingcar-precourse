package racinggame.view;

import nextstep.utils.Console;
import nextstep.utils.Randoms;
import racinggame.constant.GameOption;
import racinggame.enums.ErrorMsgEnum;
import racinggame.enums.GameMsgEnum;
import racinggame.vo.Player;

import java.util.ArrayList;
import java.util.List;

public class Monitor {
    private long finish;
    private List<Player> list;

    public void gameStart(){
        System.out.println(GameMsgEnum.NAME_MSG.value());

        String readLine = Console.readLine();

        if (readLine.startsWith(",") || readLine.endsWith(",")) {
            System.out.println(ErrorMsgEnum.NOT_AVAILABLE_COMMA_ERROR_MSG.value());

            gameStart();

            return;
        }

        validNameLength(readLine.split(","));
    }

    private void validNameLength(String nameArr[]){
        for (int i = 0; i < nameArr.length; i++) {
            if (nameArr[i].length() > GameOption.nameLength) {
                System.out.println(ErrorMsgEnum.TOO_LONG_NAME_ERROR_MSG.value());

                gameStart();

                return;
            }
        }

        createPlayer(nameArr);
    }

    private void createPlayer(String nameArr[]){
        list = new ArrayList<>();

        for (int i = 0; i < nameArr.length; i++) {
            list.add(new Player(nameArr[i]));
        }

        enterLength();
    }

    private void enterLength(){
        try{
            System.out.println(GameMsgEnum.COUNT_MSG.value());

            finish = Long.parseLong(Console.readLine());

            System.out.println();
        } catch (NumberFormatException e) {
            System.out.println(ErrorMsgEnum.NOT_AVAILABLE_NUMBER_ERROR_MSG.value());

            enterLength();

            return;
        }

        startRace();
    }

    private void startRace(){
        while (true) {
            for (int i = 0; i < list.size(); i++) {
                Player player = list.get(i);

                if(Randoms.pickNumberInRange(0, 9) > GameOption.minNumberToMove) {
                    list.get(i).setPosition(player.getPosition()+1);
                }
            }

            printPlayers();

            String winners = getWinners();

            if (!winners.isEmpty()) {
                System.out.println(GameMsgEnum.FINAL_BEFORE_NAME_MSG.value() + winners + GameMsgEnum.FINAL_AFTER_NAME_MSG.value());

                return;
            }
        }
    }

    private void printPlayers(){
        for (int i = 0; i < list.size(); i++) {
            Player player = list.get(i);

            StringBuffer move = new StringBuffer();

            for (int j = 0; j < player.getPosition(); j++) {
                move.append(GameOption.line);
            }

            System.out.println(player.getName() + " : " + move.toString());
        }

        System.out.println();
    }

    private String getWinners(){
        StringBuffer winners = new StringBuffer();

        for (int i = 0; i < list.size(); i++) {
            Player player = list.get(i);

            if (player.getPosition() >= finish) {
                if (winners.toString().length() > 1) {
                    winners.append(GameOption.nameDivider);
                }

                if (winners.toString().length() == 0) {
                    winners.append(player.getName());
                }
            }
        }

        return winners.toString();
    }
}

package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.GameOption;
import racingcar.enums.ErrorMsgEnum;
import racingcar.enums.GameMsgEnum;
import racingcar.vo.Player;

import java.util.ArrayList;
import java.util.List;

public class Monitor {
    private long finish;
    private List<Player> list;

    public void gameStart() {
        printGame(GameMsgEnum.NAME_MSG);

        String readLine = Console.readLine();

        try {
            validComma(readLine);
            validNameLength(readLine.split(","));
        } catch(IllegalArgumentException e) {
            gameStart();

            return;
        }
    }

    private void printGame(GameMsgEnum gameMsgEnum) {
        System.out.println(gameMsgEnum.value());
    }

    private void printError(ErrorMsgEnum errorMsgEnum) {
        System.out.println(errorMsgEnum.value());
    }

    private void validComma(String readLine) {
        if (readLine.startsWith(",") || readLine.endsWith(",")) {
            printError(ErrorMsgEnum.NOT_AVAILABLE_COMMA_ERROR_MSG);

            throw new IllegalArgumentException();
        }
    }

    private void validNameLength(String[] nameArr){
        for (int i = 0; i < nameArr.length; i++) {
            if (nameArr[i].length() > GameOption.NAME_LENGTH) {
                printError(ErrorMsgEnum.TOO_LONG_NAME_ERROR_MSG);

                throw new IllegalArgumentException();
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
            printGame(GameMsgEnum.COUNT_MSG);

            finish = Long.parseLong(Console.readLine());

            System.out.println();
        } catch (NumberFormatException e) {
            printError(ErrorMsgEnum.NOT_AVAILABLE_NUMBER_ERROR_MSG);

            enterLength();

            return;
        }

        startRace();
    }

    private void pickPlayers() {
        for (int i = 0; i < list.size(); i++) {
            Player player = list.get(i);

            if(Randoms.pickNumberInRange(0, 9) > GameOption.MIN_NIMBER_TO_MOVE) {
                list.get(i).setPosition(player.getPosition()+1);
            }
        }
    }

    private void startRace(){
        while (true) {
            pickPlayers();

            printPlayers();

            String winners = getWinners();

            if (!winners.isEmpty()) {
                System.out.println(GameMsgEnum.FINAL_BEFORE_NAME_MSG.value() + winners);

                return;
            }
        }
    }

    private void printPlayers(){
        for (int i = 0; i < list.size(); i++) {
            Player player = list.get(i);

            StringBuffer move = new StringBuffer();

            for (int j = 0; j < player.getPosition(); j++) {
                move.append(GameOption.LINE);
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
                    winners.append(GameOption.NAME_DIVIDER);
                }

                if (winners.toString().length() == 0) {
                    winners.append(player.getName());
                }
            }
        }

        return winners.toString();
    }
}

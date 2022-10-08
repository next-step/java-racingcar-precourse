package racingcar.model.game;

import racingcar.model.car.Car;
import racingcar.model.car.CarDto;

import java.util.ArrayList;
import java.util.List;

public class BoardDto {

    private final int tryCount;
    private final List<CarDto> entrys;
    private final List<CarDto> winners;

    public BoardDto(Board board){
        this.winners = createWinners(board.getWinners());
        this.entrys = createEntrys(board.getEntrys());
        this.tryCount = board.getTryCount();
    }

    private List<CarDto> createWinners(List<Car> winners){
        List<CarDto> carDtos = new ArrayList<>();
        for (Car winner : winners) {
            carDtos.add(new CarDto(winner));
        }
        return carDtos;
    }

    private List<CarDto> createEntrys(List<Car> entrys){
        List<CarDto> carDtos = new ArrayList<>();
        for (Car entry : entrys) {
            carDtos.add(new CarDto(entry));
        }
        return carDtos;
    }
    public List<CarDto> getEntrys(){
        return entrys;
    }

    public String[] getWinners(){
        String[] carNames = new String[winners.size()];
        for(int i = 0; i < winners.size(); i++){
            carNames[i] = winners.get(i).getName();
        }
        return carNames;
    }

    public int getTryCount(){
        return tryCount;
    }


}

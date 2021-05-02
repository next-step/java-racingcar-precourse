package racing.vo;
import java.util.List;

public class Reception {

    private final List<Car> participants;
    private static final int ZERO_LENGTH = 0;

    public Reception(List<Car> participants){
        this.participants = participants;
    }

    public List<Car> getParticipants(){
        return participants;
    }

    public void register(String names) {
        String [] namesArray = names.split(",");
        namesEmptyValidation(namesArray);
        for(String name:namesArray){
            Car car = new Car(name);
            participants.add(car);
        }
    }

    public void namesEmptyValidation(String [] namesArray){
        if(namesArray.length==ZERO_LENGTH){
            throw new IllegalArgumentException("잘못된 참가자 명입니다.");
        }
    }

}

package racing.vo;
import java.util.List;

public class Reception {

    private final List<Car> participants;

    public Reception(List<Car> participants){
        this.participants = participants;
    }

    public List<Car> getParticipants(){
        return participants;
    }

    public void register(String names) {
        String[] namesArray;
        namesArray = names.split(",");
        for(String name:namesArray){
            Car car = new Car(name);
            participants.add(car);
        }
    }

}

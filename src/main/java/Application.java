import io.Input;
import io.Output;
import repository.CarRepository;
import service.Race;
import validate.Validator;

public class Application {
    public static void main(String[] args) {
        Race race = new Race(new Input(), new Output(), new Validator(), new CarRepository());
        race.execute();
    }
}

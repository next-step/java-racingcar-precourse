package racing;

public class EnergyGeneratorSpy extends EnergyGenerator {
    public int count = 0;

    @Override
    public Energy generate() {
        this.count++;
        return super.generate();
    }
}

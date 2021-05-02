package racing;

public class EnergyGeneratorStub extends EnergyGenerator {
    private int index = 0;
    private int[] energies;

    public EnergyGeneratorStub(int... energies) {
        super();
        this.energies = energies;
    }

    @Override
    public Energy generate() {
        return new Energy(energies[index++ % energies.length]);
    }
}

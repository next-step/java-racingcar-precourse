package racinggame.model;

public class RacinggameResult {
    private final String firstPlace;

    public String getFirstPlace() {
        return firstPlace;
    }

    public RacinggameResult(Builder builder) {
        this.firstPlace = builder.firstPlace;
    }

    public static class Builder {
        private String firstPlace;

        public Builder firstPlace(String firstPlace) {
            this.firstPlace = firstPlace;
            return this;
        }

        public RacinggameResult build() {
            return new RacinggameResult(this);
        }
    }
}

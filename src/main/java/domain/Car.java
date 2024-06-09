package domain;

public class Car {
    private String name;
    private Integer position;

    public Car(String name, Integer position) {
        setName(name);
        this.position = position;
    }

    private void setName(String name){
        // ToDo: 다른 이름형식 제한 예정
        if(name.length() > 5){
            // TODO: ExcessiveParticipantsNameException
            throw new IllegalArgumentException("[Error]: 자동차의 이름이 6자 이상입니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }

    public Integer move(Integer seed){
        if(seed > 3){
            this.position ++;
        }
        return this.getPosition();
    }
}

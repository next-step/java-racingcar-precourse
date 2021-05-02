import NoCarNameException.InvalidCarNameException;

public class Car {
    String name;

    private Car(){}

    public Car(String name) throws InvalidCarNameException {
        setName(name);
    }

    private Car setName(String name) throws InvalidCarNameException {
        invalidCheck(name);
        this.name = name;
        return this;
    }

    private void invalidCheck(String name) throws InvalidCarNameException {
        if (name==null) throw new InvalidCarNameException("입력된 차량 이름이 Null입니다.");
        if (name.equals("")) throw new InvalidCarNameException("입력된 차량 이름이 없습니다");
        if (name.length() > 5) throw new InvalidCarNameException("입력된 차량의 이름" + name + "이 5를 초과합니다.");
    }

    public String getName() {
        return name;
    }
}

package study.User;

public class User {
    private Name name;
    private Age age;

    public User(String nameValue, String ageValue) {
        this.name = new Name(nameValue);
        this.age = new Age(ageValue);
    }
}

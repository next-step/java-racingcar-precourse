package study.User;

public class Name {
    private String name;

    public Name(String nameValue) {
        if(name.length()<2){
            throw new RuntimeException("이름은 두 글자 이상이어야 합니다.");
        }
        this.name = name;
    }
}

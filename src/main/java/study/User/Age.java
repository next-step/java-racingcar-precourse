package study.User;

public class Age {
    private int age;

    public Age(String ageValue) {
        int age = Integer.parseInt(ageValue);
        if(age<0){
            throw new RuntimeException("나이는 0살부터 시작합니다.");
        }
        this.age = age;
    }
}

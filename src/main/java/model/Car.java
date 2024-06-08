package model;

public class Car {
    private final String name;
    private int position;
    private int excelCondition;

    public Car(String name) {
        this.name = name;
        this.position = 0;
        this.excelCondition = 4;
    }

    /**
     * position 증가 조건값(num 이상) 변경
     * @param num 0이상 9이하의 값
     */
    public void setExcelCondition(final int num){
        if(num>=0 && num<=9){
            excelCondition = num;
        }
    }

    /**
     * num이 조건을 만족하는 경우 position을 증가시킨다.
     */
    public void doExcel(final int num){
        if(num>=excelCondition){
            position += 1;
        }
    }

    /**
     * 현재 위치를 반환한다.
     * @return 0 이상의 값
     */
    public int getPosition(){
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Car car = (Car) o;

        return name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}

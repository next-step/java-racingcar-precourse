package racing;

public class PlayResult {
    
    public void stagePrint(Cars cars) {
        for (int i = 0; i < cars.getCars().size(); i++) {
            System.out.println(cars.getCars().get(i).getCarName() + " : "
                    + viewMoveCount(cars.getCars().get(i).getCurrentPosition()));
        }
        System.out.print("\n");
    }
    
    private String viewMoveCount(int moveCount) {
        StringBuffer buffer = new StringBuffer();
        
        for (int i = 0; i < moveCount; i++) {
            buffer.append("-");
        }
        
        return buffer.toString();
    }
    
}

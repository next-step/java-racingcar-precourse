import java.util.HashSet;
import java.util.Set;

public class IsValidInput {

    public void isValidNames(String inputName){
        String[] names = inputName.split(",");
        for(String name: names){
            if ((name.length()) > 5){
                throw new IllegalArgumentException("name is too long");
            }
            if(name.contains(" ")){
                throw new IllegalArgumentException("name contains spaces");
            }
        }

        Set<String> nameSet = new HashSet<>();
        for (String name : names){
            if(nameSet.contains(name)){
                throw new IllegalArgumentException("name is duplicated");
            }
            nameSet.add(name);
        }
    }

    public void isValidCnt(String cnt){
        try{
            Integer.parseInt(cnt);
        }catch(Exception e){
            throw new IllegalArgumentException("type is wrong");
        }
    }

}

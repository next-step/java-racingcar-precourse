package racingcar.util.utils;

public class StringUtil {
    public boolean isEmpty(String str){
        if(str == null) return true;
        return str.isEmpty();
    }

    public String nvl(String str){
        if(this.isEmpty(str))
            return nvl(str, "");

        return str;
    }

    public String nvl(String str, String replace){
        if(this.isEmpty(str))
            return replace;

        return str;
    }
}

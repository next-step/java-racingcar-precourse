package exception;

import org.mockito.internal.matchers.Null;

import java.util.NoSuchElementException;

public class ExceptionWrapper {
    public static void getWrapMessage(Exception e) {
            String message = "[ERROR] " + e.getMessage();
            System.out.println(message);
//            if(e instanceof NullPointerException){
//                System.out.println(message);
//            } else if(e instanceof IllegalStateException) {
//                System.out.println(message);
//            }else if(e instanceof NoSuchElementException){
//                System.out.println(message);
//            }else if(e instanceof IllegalArgumentException ){
//                System.out.println(message);
//            }
    }
}

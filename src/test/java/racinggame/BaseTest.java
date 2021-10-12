package racinggame;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public abstract class BaseTest<T> {

    protected Method getPrivateMethod(T targetClass, String MethodName, Class<?>... classObject) {
        Method method = null;
        try {
            method = targetClass.getClass().getDeclaredMethod(MethodName, classObject);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        method.setAccessible(true);
        return method;
    }

    protected Method getPrivateMethod(T targetClass, String MethodName) {
        Method method = null;
        try {
            method = targetClass.getClass().getDeclaredMethod(MethodName);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        method.setAccessible(true);
        return method;
    }

    protected void setPrivateFieldValue(T targetClass,
                                        String fieldName,
                                        Object value) {

        Field field = null;
        try {
            field = targetClass.getClass().getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        field.setAccessible(true);
        try {
            field.set(targetClass, value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}

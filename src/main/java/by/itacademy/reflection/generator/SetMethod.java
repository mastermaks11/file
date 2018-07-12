package by.itacademy.reflection.generator;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SetMethod<T> {
    private T object;

    public SetMethod(T object) {
        this.object = object;
    }

    public void execute(Field field) throws CustomInstantiationException {
        String methodName = getSetMethodName(field);
        Method method = getMethod(methodName, field.getType());
        try {
            ObjectTypeGeneration objectTypeGeneration = new ObjectTypeGeneration(method, object);
            method.invoke(object, objectTypeGeneration.getTypeObject().get(field.getType().getSimpleName()));
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new CustomInstantiationException(e);
        }
    }

    private String getSetMethodName(Field field) {
        String name = field.getName();
        char[] chars = name.toCharArray();
        chars[0] = Character.toUpperCase(chars[0]);
        return String.join("", "set", new String(chars));
    }

    private Method getMethod(String methodName, Class<?> paramType) throws CustomInstantiationException {
        try {
            return object.getClass().getMethod(methodName, paramType);
        } catch (NoSuchMethodException e) {
            throw new CustomInstantiationException(e);
        }
    }
}
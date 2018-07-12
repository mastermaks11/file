package by.itacademy.reflection.generator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 30.06.2018.
 */
public class ObjectTypeGeneration<T> {
    private Map<String, T> typeObject;

    public ObjectTypeGeneration(Method method, T object) throws InvocationTargetException, IllegalAccessException {
        this.typeObject = new HashMap<>();
        typeObject.put("int", (T) new Integer((int)( Math.random() * 100)));
        typeObject.put("String", (T) RandomString.random());
        typeObject.put("LocalDate", (T) RandomDate.RandomDateOfBirth());
        typeObject.put("boolean", (T) new Boolean(RandomBoolean.getRandomBoolean()));
    }

    public Map<String, T> getTypeObject() {
        return typeObject;
    }
}

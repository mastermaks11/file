package by.itacademy.reflection.generator;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class FieldGenerator<T> {
    private SetMethod<T> setMethod;
    private T object;

    public FieldGenerator(T object) {
        this.object = object;
        setMethod = new SetMethod<T>(object);
    }

    public T execute() throws CustomInstantiationException {
        List<Field> fields = annotatedFields();
        for (Field field : fields) {
            setMethod.execute(field);
        }
        return object;
    }

    private List<Field> annotatedFields() {
        List<Field> annotatedFields = new ArrayList<>();
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Generate.class)) {
                annotatedFields.add(field);
            }
        }
        return annotatedFields;
    }
}
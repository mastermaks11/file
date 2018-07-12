package by.itacademy.reflection.generator;

public class BeanFactory<T> {
    private Class<T> clazz;

    public BeanFactory(Class<T> clazz) {
        this.clazz = clazz;
    }

    public T createObject() throws  CustomInstantiationException {
        try {
            return clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new CustomInstantiationException(e);
        }
    }
}
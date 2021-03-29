package expression.generic;

public abstract class AbstractType<T extends Number> implements TypeWrapper<T> {
    protected T value;
    @Override
    public T getValue() {
        return value;
    }
}

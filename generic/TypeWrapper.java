package expression.generic;

public interface TypeWrapper<T extends Number> {
    T getValue();
    TypeWrapper<T> add(TypeWrapper<T> value);
    TypeWrapper<T> and(TypeWrapper<T> value);
    TypeWrapper<T> or(TypeWrapper<T> value);
    TypeWrapper<T> xor(TypeWrapper<T> value);
    TypeWrapper<T> sub(TypeWrapper<T> value);
    TypeWrapper<T> mul(TypeWrapper<T> value);
    TypeWrapper<T> div(TypeWrapper<T> value);
    TypeWrapper<T> mod(TypeWrapper<T> value);
    TypeWrapper<T> abs();
    TypeWrapper<T> neg();
    TypeWrapper<T> not();
    TypeWrapper<T> square();
    TypeWrapper<T> bitCount();
}

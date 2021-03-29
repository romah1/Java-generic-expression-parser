package expression;

import expression.generic.TypeWrapper;

import java.util.Objects;

public class Const<T extends Number> extends Operation<T> {
    private final TypeWrapper<T> value;
    public Const(TypeWrapper<T> x) {
        super(Priority.CONST);
        this.value = x;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public TypeWrapper<T> evaluate(TypeWrapper<T> x) {
        return value;
    }

    @Override
    public TypeWrapper<T> evaluate(TypeWrapper<T> x, TypeWrapper<T> y, TypeWrapper<T> z) {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Const<?> aConst = (Const<?>) o;
        return value.equals(aConst.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}

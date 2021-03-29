package expression;

import expression.generic.TypeWrapper;

public class Variable<T extends Number> extends Operation<T> {
    private final String sym;
    public Variable(String x) {
        super(Priority.VARIABLE);
        this.sym = x;
    }

    @Override
    public TypeWrapper<T> evaluate(TypeWrapper<T> x) {
        return x;
    }

    @Override
    public String toString() {
        return sym;
    }

    @Override
    public TypeWrapper<T> evaluate(TypeWrapper<T> x, TypeWrapper<T> y, TypeWrapper<T> z) {
        if (sym.equals("x")) {
            return x;
        } else if (sym.equals("y")) {
            return y;
        } else {
            return z;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Variable<?> variable = (Variable<?>) o;
        return sym.equals(variable.sym);
    }

    @Override
    public int hashCode() {
        return sym.hashCode();
    }
}

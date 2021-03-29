package expression;

import expression.generic.TypeWrapper;

public class Subtract<T extends Number> extends BinaryOperation<T> {

    public Subtract(Operation<T> a, Operation<T> b) {
        super(a, b, "-", Priority.SUBTRACT, false);
    }

    @Override
    public TypeWrapper<T> calculateOperation(TypeWrapper<T> x, TypeWrapper<T> y) {
        return x.sub(y);
    }

}

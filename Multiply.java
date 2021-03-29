package expression;

import expression.generic.TypeWrapper;

public class Multiply<T extends Number> extends BinaryOperation<T> {

    public Multiply(Operation<T> a, Operation<T> b) {
        super(a, b, "*", Priority.MULTIPLY, true);
    }

    @Override
    public TypeWrapper<T> calculateOperation(TypeWrapper<T> x, TypeWrapper<T> y) {
        return x.mul(y);
    }
}

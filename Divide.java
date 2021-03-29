package expression;

import expression.generic.TypeWrapper;

public class Divide<T extends Number> extends BinaryOperation<T> {
    public Divide(Operation<T> a, Operation<T> b) {
        super(a, b, "/", Priority.DIVIDE, false);
    }

    @Override
    public TypeWrapper<T> calculateOperation(TypeWrapper<T> x, TypeWrapper<T> y) {
        return x.div(y);
    }

}

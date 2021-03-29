package expression;

import expression.generic.TypeWrapper;

public class Or<T extends Number> extends BinaryOperation<T> {

    public Or(Operation<T> a, Operation<T> b) {
        super(a, b, "|", Priority.OR, true);
    }

    @Override
    public TypeWrapper<T> calculateOperation(TypeWrapper<T> x, TypeWrapper<T> y) {
        return x.or(y);
    }

}

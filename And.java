package expression;

import expression.generic.TypeWrapper;

public class And<T extends Number> extends BinaryOperation<T> {

    public And(Operation<T> a, Operation<T> b) {
        super(a, b, "&", Priority.AND, true);
    }

    @Override
    public TypeWrapper<T> calculateOperation(TypeWrapper<T> x, TypeWrapper<T> y) {
        return x.and(y);
    }

}

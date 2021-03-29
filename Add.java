package expression;

import expression.generic.TypeWrapper;

public class Add<T extends Number> extends BinaryOperation<T> {

    public Add(Operation<T> a, Operation<T> b) {
        super(a, b, "+", Priority.ADD, true);
    }

    @Override
    public TypeWrapper<T> calculateOperation(TypeWrapper<T> x, TypeWrapper<T> y) {
        return x.add(y);
    }

}

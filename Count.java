package expression;

import expression.generic.TypeWrapper;

public class Count<T extends Number> extends UnaryOperation<T>{
    public Count(Operation<T> o) {
        super(o, "count", Priority.COUNT, false);
    }

    @Override
    public TypeWrapper<T> calculateOperation(TypeWrapper<T> x) {
        return x.bitCount();
    }
}

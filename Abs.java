package expression;

import expression.generic.TypeWrapper;

public class Abs<T extends Number> extends UnaryOperation<T>{

    public Abs(Operation<T> o) {
        super(o, "abs", Priority.ABS, false);
    }

    @Override
    public TypeWrapper<T> calculateOperation(TypeWrapper<T> x) {
        return x.abs();
    }
}

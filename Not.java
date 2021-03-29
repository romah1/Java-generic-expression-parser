package expression;

import expression.generic.TypeWrapper;

public class Not<T extends Number> extends UnaryOperation<T>{
    public Not(Operation<T> o) {
        super(o, "~", Priority.NOT, false);
    }

    @Override
    public TypeWrapper<T> calculateOperation(TypeWrapper<T> x) {
        return x.not();
    }
}

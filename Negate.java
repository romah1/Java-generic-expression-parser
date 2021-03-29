package expression;

import expression.generic.TypeWrapper;

public class Negate<T extends Number> extends UnaryOperation<T>{

    public Negate(Operation<T> o) {
        super(o, "-", Priority.UNARY_MINUS, false);
    }

    @Override
    public TypeWrapper<T> calculateOperation(TypeWrapper<T> x) {
        return x.neg();
    }
}

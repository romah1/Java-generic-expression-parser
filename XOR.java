package expression;

import expression.generic.TypeWrapper;

public class XOR<T extends Number> extends BinaryOperation<T> {

    public XOR(Operation<T> a, Operation<T> b) {
        super(a, b, "^", Priority.XOR, true);
    }

    @Override
    public TypeWrapper<T> calculateOperation(TypeWrapper<T> x, TypeWrapper<T> y) {
        return x.xor(y);
    }

}

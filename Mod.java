package expression;

import expression.generic.TypeWrapper;

public class Mod<T extends Number> extends BinaryOperation<T> {

    public Mod(Operation<T> a, Operation<T> b) {
        super(a, b, "mod", Priority.MOD, true);
    }

    @Override
    public TypeWrapper<T> calculateOperation(TypeWrapper<T> x, TypeWrapper<T> y) {
        return x.mod(y);
    }
}

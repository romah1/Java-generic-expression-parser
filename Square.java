package expression;

import expression.generic.TypeWrapper;

public class Square<T extends Number> extends UnaryOperation<T>{

    public Square(Operation<T> o) {
        super(o, "square", Priority.SQUARE, false);
    }

    @Override
    public TypeWrapper<T> calculateOperation(TypeWrapper<T> x) {
        return x.square();
    }
}

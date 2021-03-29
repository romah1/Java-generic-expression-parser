package expression;
import expression.exceptions.*;
import expression.generic.TypeWrapper;

import java.util.Objects;

public abstract class UnaryOperation<T extends Number> extends Operation<T>{
    Operation<T> o;
    private final String operationSymbol;
    private final boolean isAssociative;

    UnaryOperation(Operation<T> o, String operationSymbol, int priority,
                   boolean isAssociative) {
        super(priority);
        this.operationSymbol = operationSymbol;
        this.isAssociative = isAssociative;
        this.o = o;
    }

    public abstract TypeWrapper<T> calculateOperation(TypeWrapper<T> x);

    @Override
    public TypeWrapper<T> evaluate(TypeWrapper<T> x, TypeWrapper<T> y, TypeWrapper<T> z) {
        return calculateOperation(
                o.evaluate(x, y, z)
        );
    }

    @Override
    public TypeWrapper<T> evaluate(TypeWrapper<T> x) {
        return calculateOperation(
                o.evaluate(x)
        );
    }

    @Override
    public String toString() {
        return(operationSymbol + " " + o.toString());
    }

    @Override
    public boolean equals(Object o1) {
        if (this == o1) return true;
        if (o1 == null || getClass() != o1.getClass()) return false;
        UnaryOperation<?> that = (UnaryOperation<?>) o1;
        return isAssociative == that.isAssociative &&
                o.equals(that.o) &&
                operationSymbol.equals(that.operationSymbol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(o, operationSymbol, getPriority(), isAssociative);
    }

}

package expression;

import expression.generic.TypeWrapper;

import java.util.Objects;

public abstract class BinaryOperation<T extends Number> extends Operation<T> {
    Operation<T> a, b;
    private final String operationSymbol;
    private final boolean isAssociative;
    public BinaryOperation(Operation<T> a, Operation<T> b, String operationSymbol, int priority,
                           boolean isAssociative) {
        super(priority);
        this.a = a;
        this.b = b;
        this.operationSymbol = operationSymbol;
        this.isAssociative = isAssociative;
    }

    public abstract TypeWrapper<T> calculateOperation(TypeWrapper<T> x, TypeWrapper<T> y);

    @Override
    public TypeWrapper<T> evaluate(TypeWrapper<T> x, TypeWrapper<T> y, TypeWrapper<T> z) {
        return calculateOperation(
                a.evaluate(x, y, z),
                b.evaluate(x, y, z)
        );
    }

    @Override
    public TypeWrapper<T> evaluate(TypeWrapper<T> x) {
        return calculateOperation(
                a.evaluate(x),
                b.evaluate(x)
        );
    }


    @Override
    public String toString() {
        return "(" + a.toString() + " " + operationSymbol + " " +  b.toString() + ")";
    }

    @Override
    public String toMiniString() {
        StringBuilder sb = new StringBuilder();
        int pra, prb, prt;
        prb = b.getPriority();
        pra = a.getPriority();
        prt = getPriority();
        if (prt > pra) {
            sb.append("(").append(a.toMiniString()).append(")");
        } else {
            sb.append(a.toMiniString());
        }
        sb.append(" ").append(operationSymbol).append(" ");

        if (prt > prb || (prt == prb) && (!isAssociative || getClass() != b.getClass())) {
            sb.append("(").append(b.toMiniString()).append(")");
        } else {
            sb.append(b.toMiniString());
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BinaryOperation<?> that = (BinaryOperation<?>) o;
        return isAssociative == that.isAssociative &&
                a.equals(that.a) &&
                b.equals(that.b) &&
                operationSymbol.equals(that.operationSymbol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, operationSymbol, getPriority(), isAssociative);
    }
}

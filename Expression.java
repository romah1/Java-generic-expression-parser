package expression;

import expression.generic.TypeWrapper;

public interface Expression<T extends Number> extends ToMiniString {
    TypeWrapper<T> evaluate(TypeWrapper<T> x);
}

package expression;

import expression.generic.TypeWrapper;

public interface TripleExpression<T extends Number> extends ToMiniString{
    TypeWrapper<T> evaluate(TypeWrapper<T> x, TypeWrapper<T> y, TypeWrapper<T> z);
}

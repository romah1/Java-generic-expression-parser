package expression.parser;

import expression.TripleExpression;
import expression.exceptions.ParseException;

public interface Parser<T extends Number> {
    TripleExpression<T> parse(String expression) throws ParseException;
}
package expression.generic;

import expression.TripleExpression;
import expression.exceptions.NullExpressionException;
import expression.exceptions.UnsupportedTypeException;
import expression.exceptions.WrongArgumentsException;
import expression.parser.ExpressionParser;

import java.math.BigInteger;
import java.util.function.Function;

public class GenericTabulator implements Tabulator {
    @Override
    public Object[][][] tabulate(String mode, String expression, int x1, int x2, int y1, int y2, int z1, int z2) throws Exception {
        if (expression == null) {
            throw new NullExpressionException();
        }

        switch (mode) {
            case "i":
                return new executor<Integer>().execute(CheckedInt::parse, expression, x1, x2, y1, y2, z1, z2);
            case "d":
                return new executor<Double>().execute(OwnDouble::parse, expression, x1, x2, y1, y2, z1, z2);
            case "bi":
                return new executor<BigInteger>().execute(OwnBigInteger::parse, expression, x1, x2, y1, y2, z1, z2);
            case "u":
                return new executor<Integer>().execute(UncheckedInt::parse, expression, x1, x2, y1, y2, z1, z2);
            case "l":
                return new executor<Long>().execute(UncheckedLong::parse, expression, x1, x2, y1, y2, z1, z2);
            case "s":
                return new executor<Short>().execute(UncheckedShort::parse, expression, x1, x2, y1, y2, z1, z2);
        }
        throw new UnsupportedTypeException(mode);
    }

    static class executor<T extends Number> {
        public Object[][][] execute(Function<String, TypeWrapper<T>> parseType, String expression, int x1, int x2, int y1, int y2, int z1, int z2) {
            TripleExpression<T> expr = new ExpressionParser<T>(parseType).parse(expression);
            Object[][][] result = new Object[x2 - x1 + 1][y2 - y1 + 1][z2 - z1 + 1];
            for (int i = 0; i <= x2 - x1; i++) {
                TypeWrapper<T> iVal = parseType.apply(String.valueOf(i + x1));
                for (int j = 0; j <= y2 - y1; j++) {
                    TypeWrapper<T> jVal = parseType.apply(String.valueOf(j + y1));
                    for (int k = 0; k <= z2 - z1; k++) {
                        TypeWrapper<T> kVal = parseType.apply(String.valueOf(k + z1));
                        try {
                            result[i][j][k] = expr.evaluate(iVal, jVal, kVal).getValue();
                        } catch (ArithmeticException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }
            }
            return result;
        }
    }
    public static void main(String[] args) throws Exception {
        if (args.length < 2 || args[0] == null || args[1] == null) {
            throw new WrongArgumentsException(String.join(" ", args));
        }
        Object[][][] result = new GenericTabulator().tabulate(args[0].substring(1), String.join("", args).substring(args[0].length()), -2, 2, -2, 2, -2, 2);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                for (int k = 0; k < result[i][j].length; k++) {
                    System.out.println("Evaluation for: x = " + (i-2) + ", y = " + (j-2) + ", z = " + (k-2));
                    System.out.println(result[i][j][k]);
                }
            }
        }
    }
}

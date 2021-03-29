package expression.parser;

import expression.*;
import expression.generic.TypeWrapper;

import java.lang.*;
import java.util.function.Function;

public class ExpressionParser<T extends Number> implements Parser<T> {
    private final Function<String, TypeWrapper<T>> parseType;

    public ExpressionParser(Function<String, TypeWrapper<T>> parseType) {
        this.parseType = parseType;
    }

    @Override
    public TripleExpression<T> parse(final String source) {
        return new TripleExpressionParser<T>(new StringSource(source), parseType).parseTripleExpression();
    }
    private static class TripleExpressionParser<T extends Number> extends BaseParser {
        private final Function<String, TypeWrapper<T>> parseType;
        TripleExpressionParser(final CharSource source, Function<String, TypeWrapper<T>> parseType) {
            super(source);
            this.parseType = parseType;
            nextChar();
        }

        public TripleExpression<T> parseTripleExpression() {
            final TripleExpression<T> result = parseBinaryOperation(0);
            if (eof()) {
                return result;
            }
            throw error("End of TripleExpression expected after pos " + (getPos() - 1));
        }
        protected int getPriority(String symbol) {
            return switch (symbol) {
                case "+" -> Priority.ADD;
                case "-" -> Priority.SUBTRACT;
                case "*" -> Priority.MULTIPLY;
                case "/" -> Priority.DIVIDE;
                case "|" -> Priority.OR;
                case "^" -> Priority.XOR;
                case "&" -> Priority.AND;
                case "abs" -> Priority.ABS;
                case "square" -> Priority.SQUARE;
                case "mod" -> Priority.MOD;
                default -> 0;
            };
        }

        protected Operation<T> constructBinaryOperation(String sym, Operation<T> left, Operation<T> right) {
            return switch (sym) {
                case "+" -> new Add<>(left, right);
                case "-" -> new Subtract<>(left, right);
                case "*" -> new Multiply<>(left, right);
                case "&" -> new And<>(left, right);
                case "|" -> new Or<>(left, right);
                case "^" -> new XOR<>(left, right);
                case "/" -> new Divide<>(left, right);
                case "mod" -> new Mod<>(left, right);
                default -> null;
            };
        }

        public Operation<T> constructUnaryOperation(String sym, Operation<T> op) {
            return switch (sym) {
                case "-" -> new Negate<>(op);
                case "count" -> new Count<>(op);
                case "~" -> new Not<>(op);
                case "square" -> new Square<>(op);
                case "abs" -> new Abs<>(op);
                default -> null;
            };
        }


        protected String parseToken() {
            skipWhitespace();
            if (between('0', '9')) {
                return parseNumber();
            }
            String[] tokensList = {"*", "-", "+", "|", "&", "/", "mod", "count", "square", "abs", "(", ")", "x", "y", "z", "^", "~"};
            for (String s: tokensList) {
                if (test(s)) {
                    return s;
                }
            }
            throw error("No valid token on pos " + (getPos() - 1));
        }

        protected Operation<T> parseUnary() {
            String token = parseToken();
            if (token.charAt(0) >= '0' && token.charAt(0) <= '9') {
                return new Const<>(parseType.apply(token));
            }
            if (token.charAt(0) == '-' && between('0', '9')) {
                String num = parseNumber();
                return new Const<>(parseType.apply(num));
            }
            if (token.equals("x") || token.equals("y") || token.equals("z")) {
                return new Variable<>(token);
            }
            if (token.equals(")")) {
                throw error("Unexpected closing bracket on pos " + (getPos() - 1));
            }
            if (token.equals("(")) {
                Operation<T> res = parseBinaryOperation(0);
                if (!test(")")) {
                    throw error("Closing bracket expected on pos " + getPos());
                }
                return res;
            }
            Operation<T> unaryArgument = parseUnary();
            if (unaryArgument == null) {
                throw error("Argument for unary operation expected on pos " + getPos());
            }
            return constructUnaryOperation(token, unaryArgument);
        }

        protected Operation<T> parseBinaryOperation(int minPriority) {
            skipWhitespace();
            Operation<T> left = parseUnary();
            skipWhitespace();
            while (!eof()) {
                skipWhitespace();
                int pos = getPos();
                String op = parseToken();
                int priority = getPriority(op);
                if (priority <= minPriority) {
                    rollback(pos);
                    return left;
                }
                Operation<T> right = parseBinaryOperation(priority);
                left = constructBinaryOperation(op, left, right);
            }
            return left;
        }


        private String parseNumber() {
            final StringBuilder sb = new StringBuilder();
            copyInteger(sb);
            if (test('.')) {
                sb.append('.');
                copyDigits(sb);
            }
            try {
                return sb.toString();
            } catch (NumberFormatException e) {
                throw error("Invalid number " + sb);
            }
        }

        private void copyInteger(final StringBuilder sb) {
            if (test('-')) {
                sb.append('-');
            }
            if (test('0')) {
                sb.append('0');
            } else if (between('1', '9')) {
                copyDigits(sb);
            } else {
                throw error("Invalid number");
            }
        }

        private void copyDigits(final StringBuilder sb) {
            while (between('0', '9')) {
                sb.append(ch);
                nextChar();
            }
        }

        private void skipWhitespace() {
            while (test(' ') || test('\r') || test('\n') || test('\t')) {
                // skip
            }
        }
    }
}

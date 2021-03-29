package expression.parser;


import expression.exceptions.ParseException;

public class BaseParser {
    public static final char END = '\0';
    private final CharSource source;
    protected char ch = 0xffff;

    protected BaseParser(final CharSource source) {
        this.source = source;
    }

    protected void nextChar() {
        ch = source.hasNext() ? source.next() : END;
    }

    protected void rollback(int i) {ch = source.rollback(i);}

    protected int getPos() {return source.getPos();}

    protected boolean test(char expected) {
        if (ch == expected) {
            nextChar();
            return true;
        }
        return false;
    }

    protected boolean test(String expected) {
        int i;
        for (i = 0; i < expected.length(); i++) {
            if (!test(expected.charAt(i))) {
                if (i > 0) {
                    throw error("Unexpected symbol: " + ch);
                }
                return false;
            }
        }
        return true;
    }
    protected boolean eof() {
        return test(END);
    }

    protected ParseException error(final String message) {
        return source.error(message);
    }

    protected boolean between(final char from, final char to) {
        return from <= ch && ch <= to;
    }
}

package expression.parser;

import expression.exceptions.ParseException;

public class StringSource implements CharSource {
    private int pos = 0;
    private final String data;

    public StringSource(String data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        return pos < data.length();
    }

    @Override
    public char next() {
        return data.charAt(pos++);
    }
    @Override
    public int getPos() {
        return pos;
    }
    @Override
    public char rollback(int i) {
        pos = i - 1;
        return data.charAt(pos++);
    }

    @Override
    public ParseException error(final String message) {
        return new ParseException(pos + ": " + message);
    }
}


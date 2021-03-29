package expression.parser;

import expression.exceptions.ParseException;

public interface CharSource {
    boolean hasNext();
    char next();
    char rollback(int i);
    int getPos();
    ParseException error(final String message);
}

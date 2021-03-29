package expression;

public abstract class Operation<T extends Number> implements Expression<T>, TripleExpression<T> {
    private final int priority;
    Operation(int priority) {
        this.priority = priority;
    }
    public int getPriority() {
        return this.priority;
    }
}

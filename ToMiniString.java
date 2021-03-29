package expression;

public interface ToMiniString {
    default public String toMiniString() {
        return this.toString();
    }
}

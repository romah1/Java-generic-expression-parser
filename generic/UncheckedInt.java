package expression.generic;

public class UncheckedInt extends AbstractType<Integer>{

    public UncheckedInt(int value) {
        this.value = value;
    }

    public static TypeWrapper<Integer> parse(String s) {
        return new UncheckedInt(Integer.parseInt(s));
    }

    @Override
    public TypeWrapper<Integer> add(TypeWrapper<Integer> value) {
        return new UncheckedInt(this.value + value.getValue());
    }

    @Override
    public TypeWrapper<Integer> and(TypeWrapper<Integer> value) {
        return new UncheckedInt(this.value & value.getValue());
    }

    @Override
    public TypeWrapper<Integer> or(TypeWrapper<Integer> value) {
        return new UncheckedInt(this.value | value.getValue());
    }

    @Override
    public TypeWrapper<Integer> xor(TypeWrapper<Integer> value) {
        return new UncheckedInt(this.value ^ value.getValue());
    }

    @Override
    public TypeWrapper<Integer> sub(TypeWrapper<Integer> value) {
        return new UncheckedInt(this.value - value.getValue());
    }

    @Override
    public TypeWrapper<Integer> mul(TypeWrapper<Integer> value) {
        return new UncheckedInt(this.value * value.getValue());
    }

    @Override
    public TypeWrapper<Integer> div(TypeWrapper<Integer> value) {
        return new UncheckedInt(this.value / value.getValue());
    }

    @Override
    public TypeWrapper<Integer> neg() {
        return new UncheckedInt(-this.value);
    }

    @Override
    public TypeWrapper<Integer> not() {
        return new UncheckedInt(~this.value);
    }

    @Override
    public TypeWrapper<Integer> bitCount() {
        return new UncheckedInt(Integer.bitCount(this.value));
    }

    @Override
    public TypeWrapper<Integer> abs() {
        if (value < 0) {
            value = -value;
        }
        return new UncheckedInt(value);
    }

    @Override
    public TypeWrapper<Integer> square() {
        return new UncheckedInt(value * value);
    }

    @Override
    public TypeWrapper<Integer> mod(TypeWrapper<Integer> value) {
        return new CheckedInt(this.value % value.getValue());
    }
}

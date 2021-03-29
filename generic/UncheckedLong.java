package expression.generic;

public class UncheckedLong extends AbstractType<Long>{

    public UncheckedLong(long value) {
        this.value = value;
    }

    public static TypeWrapper<Long> parse(String s) {
        return new UncheckedLong(Long.parseLong(s));
    }

    @Override
    public TypeWrapper<Long> add(TypeWrapper<Long> value) {
        return new UncheckedLong(this.value + value.getValue());
    }

    @Override
    public TypeWrapper<Long> and(TypeWrapper<Long> value) {
        return new UncheckedLong(this.value & value.getValue());
    }

    @Override
    public TypeWrapper<Long> or(TypeWrapper<Long> value) {
        return new UncheckedLong(this.value | value.getValue());
    }

    @Override
    public TypeWrapper<Long> xor(TypeWrapper<Long> value) {
        return new UncheckedLong(this.value ^ value.getValue());
    }

    @Override
    public TypeWrapper<Long> sub(TypeWrapper<Long> value) {
        return new UncheckedLong(this.value - value.getValue());
    }

    @Override
    public TypeWrapper<Long> mul(TypeWrapper<Long> value) {
        return new UncheckedLong(this.value * value.getValue());
    }

    @Override
    public TypeWrapper<Long> div(TypeWrapper<Long> value) {
        return new UncheckedLong(this.value / value.getValue());
    }

    @Override
    public TypeWrapper<Long> neg() {
        return new UncheckedLong(-this.value);
    }

    @Override
    public TypeWrapper<Long> not() {
        return new UncheckedLong(~this.value);
    }

    @Override
    public TypeWrapper<Long> bitCount() {
        return new UncheckedLong(Long.bitCount(this.value));
    }

    @Override
    public TypeWrapper<Long> abs() {
        if (value < 0) {
            value = -value;
        }
        return new UncheckedLong(value);
    }

    @Override
    public TypeWrapper<Long> square() {
        return new UncheckedLong(value * value);
    }

    @Override
    public TypeWrapper<Long> mod(TypeWrapper<Long> value) {
        return new UncheckedLong(this.value % value.getValue());
    }
}

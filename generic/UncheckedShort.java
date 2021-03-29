package expression.generic;

public class UncheckedShort extends AbstractType<Short>{

    public UncheckedShort(Short value) {
        this.value = value;
    }

    public static TypeWrapper<Short> parse(String s) {
        return new UncheckedShort((short) Integer.parseInt(s));
    }

    @Override
    public TypeWrapper<Short> add(TypeWrapper<Short> value) {
        return new UncheckedShort((short) (this.value + value.getValue()));
    }

    @Override
    public TypeWrapper<Short> and(TypeWrapper<Short> value) {
        return new UncheckedShort((short) (this.value & value.getValue()));
    }

    @Override
    public TypeWrapper<Short> or(TypeWrapper<Short> value) {
        return new UncheckedShort((short) (this.value | value.getValue()));
    }

    @Override
    public TypeWrapper<Short> xor(TypeWrapper<Short> value) {
        return new UncheckedShort((short) (this.value ^ value.getValue()));
    }

    @Override
    public TypeWrapper<Short> sub(TypeWrapper<Short> value) {
        return new UncheckedShort((short) (this.value - value.getValue()));
    }

    @Override
    public TypeWrapper<Short> mul(TypeWrapper<Short> value) {
        return new UncheckedShort((short) (this.value * value.getValue()));
    }

    @Override
    public TypeWrapper<Short> div(TypeWrapper<Short> value) {
        return new UncheckedShort((short) (this.value / value.getValue()));
    }

    @Override
    public TypeWrapper<Short> neg() {
        return new UncheckedShort((short) -this.value);
    }

    @Override
    public TypeWrapper<Short> not() {
        return new UncheckedShort((short) ~this.value);
    }

    @Override
    public TypeWrapper<Short> bitCount() {
        return new UncheckedShort((short) Integer.bitCount(this.value));
    }

    @Override
    public TypeWrapper<Short> abs() {
        if (value < 0) {
            value = (short)-value;
        }
        return new UncheckedShort(value);
    }

    @Override
    public TypeWrapper<Short> square() {
        return new UncheckedShort((short) (value * value));
    }

    @Override
    public TypeWrapper<Short> mod(TypeWrapper<Short> value) {
        return new UncheckedShort((short) (this.value % value.getValue()));
    }
}

package expression.generic;


public class OwnDouble extends AbstractType<Double>{

    public OwnDouble(double value) {
        this.value = value;
    }

    public static TypeWrapper<Double> parse(String s) {
        return new OwnDouble(Double.parseDouble(s));
    }

    @Override
    public TypeWrapper<Double> add(TypeWrapper<Double> value) {
        return new OwnDouble(this.value + value.getValue());
    }

    @Override
    public TypeWrapper<Double> and(TypeWrapper<Double> value) {
        return new OwnDouble(0);
    }

    @Override
    public TypeWrapper<Double> or(TypeWrapper<Double> value) {
        return new OwnDouble(0);
    }

    @Override
    public TypeWrapper<Double> xor(TypeWrapper<Double> value) {
        return new OwnDouble(0);
    }

    @Override
    public TypeWrapper<Double> sub(TypeWrapper<Double> value) {
        return new OwnDouble(this.value - value.getValue());
    }

    @Override
    public TypeWrapper<Double> mul(TypeWrapper<Double> value) {
        return new OwnDouble(this.value * value.getValue());
    }

    @Override
    public TypeWrapper<Double> div(TypeWrapper<Double> value) {
        return new OwnDouble(this.value / value.getValue());
    }

    @Override
    public TypeWrapper<Double> neg() {
        return new OwnDouble(-this.value);
    }

    @Override
    public TypeWrapper<Double> not() {
        return new OwnDouble(0);
    }

    @Override
    public TypeWrapper<Double> bitCount() {
        return new OwnDouble(0);
    }

    @Override
    public TypeWrapper<Double> abs() {
        if (value < 0) {
            value = -value;
        }
        return new OwnDouble(value);
    }

    @Override
    public TypeWrapper<Double> square() {
        return new OwnDouble(value * value);
    }

    @Override
    public TypeWrapper<Double> mod(TypeWrapper<Double> value) {
        return new OwnDouble(this.value % value.getValue().intValue());
    }
}

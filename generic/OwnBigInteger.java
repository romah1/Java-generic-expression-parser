package expression.generic;
import expression.exceptions.DivisionByZeroException;

import java.math.BigInteger;

public class OwnBigInteger extends AbstractType<BigInteger>{

    public OwnBigInteger(BigInteger value) {
        this.value = value;
    }

    public static TypeWrapper<BigInteger> parse(String s) {
        return new OwnBigInteger(new BigInteger(s));
    }

    @Override
    public TypeWrapper<BigInteger> add(TypeWrapper<BigInteger> value) {
        return new OwnBigInteger(this.value.add(value.getValue()));
    }

    @Override
    public TypeWrapper<BigInteger> and(TypeWrapper<BigInteger> value) {
        return new OwnBigInteger(this.value.and(value.getValue()));
    }

    @Override
    public TypeWrapper<BigInteger> or(TypeWrapper<BigInteger> value) {
        return new OwnBigInteger(this.value.or(value.getValue()));
    }

    @Override
    public TypeWrapper<BigInteger> xor(TypeWrapper<BigInteger> value) {
        return new OwnBigInteger(this.value.xor(value.getValue()));
    }

    @Override
    public TypeWrapper<BigInteger> sub(TypeWrapper<BigInteger> value) {
        return new OwnBigInteger(this.value.subtract(value.getValue()));
    }

    @Override
    public TypeWrapper<BigInteger> mul(TypeWrapper<BigInteger> value) {
        return new OwnBigInteger(this.value.multiply(value.getValue()));
    }

    @Override
    public TypeWrapper<BigInteger> div(TypeWrapper<BigInteger> value) {
        BigInteger second = value.getValue();
        if (second.equals(BigInteger.ZERO)) {
            throw new DivisionByZeroException(String.valueOf(this.value));
        }
        return new OwnBigInteger(this.value.divide(value.getValue()));
    }

    @Override
    public TypeWrapper<BigInteger> neg() {
        return new OwnBigInteger(this.value.negate());
    }

    @Override
    public TypeWrapper<BigInteger> not() {
        return new OwnBigInteger(this.value.not());
    }

    @Override
    public TypeWrapper<BigInteger> bitCount() {
        return new OwnBigInteger(new BigInteger(String.valueOf(this.value.bitCount())));
    }

    @Override
    public TypeWrapper<BigInteger> square() {
        return new OwnBigInteger(value.multiply(value));
    }

    @Override
    public TypeWrapper<BigInteger> abs() {
        return new OwnBigInteger(value.abs());
    }

    @Override
    public TypeWrapper<BigInteger> mod(TypeWrapper<BigInteger> value) {
        return new OwnBigInteger(this.value.mod(value.getValue()));
    }
}

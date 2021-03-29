package expression.generic;

import expression.exceptions.ArithmeticOverflowException;
import expression.exceptions.DivisionByZeroException;

// :NOTE: дублирование с UncheckedInt
public class CheckedInt extends AbstractType<Integer>{

    public CheckedInt(int value) {
        this.value = value;
    }

    public static TypeWrapper<Integer> parse(String s) {
        return new CheckedInt(Integer.parseInt(s));
    }

    @Override
    public TypeWrapper<Integer> add(TypeWrapper<Integer> value) {
        Integer second = value.getValue();
        if ((second > 0) && (this.value > Integer.MAX_VALUE - second) || (second < 0) && (this.value < Integer.MIN_VALUE - second)) {
            throw new ArithmeticOverflowException(this.value, second, "+");
        }
        return new CheckedInt(this.value + value.getValue());
    }

    @Override
    public TypeWrapper<Integer> and(TypeWrapper<Integer> value) {
        return new CheckedInt(this.value & value.getValue());
    }

    @Override
    public TypeWrapper<Integer> or(TypeWrapper<Integer> value) {
        return new CheckedInt(this.value | value.getValue());
    }

    @Override
    public TypeWrapper<Integer> xor(TypeWrapper<Integer> value) {
        return new CheckedInt(this.value ^ value.getValue());
    }

    @Override
    public TypeWrapper<Integer> sub(TypeWrapper<Integer> value) {
        Integer second = value.getValue();
        if ((second > 0) && (this.value < Integer.MIN_VALUE + second) || (second < 0) && (this.value > Integer.MAX_VALUE + second)) {
            throw new ArithmeticOverflowException(this.value, second, "-");
        }
        return new CheckedInt(this.value - value.getValue());
    }

    @Override
    public TypeWrapper<Integer> mul(TypeWrapper<Integer> value) {
        Integer second = value.getValue();
        if (this.value > 0 && second > 0 && this.value > Integer.MAX_VALUE / second ||
            this.value > 0 && second < 0 && second < Integer.MIN_VALUE / this.value ||
            this.value < 0 && second > 0 && this.value < Integer.MIN_VALUE / second ||
            this.value < 0 && second < 0 && this.value < Integer.MAX_VALUE / second) {
            throw new ArithmeticOverflowException(this.value, second, "*");
        }
        return new CheckedInt(this.value * value.getValue());
    }

    @Override
    public TypeWrapper<Integer> mod(TypeWrapper<Integer> value) {
        Integer second = value.getValue();
        if (second <= 0) {
            second = 1;
//            throw new ModuleIsNotPositiveException(this.value, second);
        }
        System.out.println(this.value % second);
        return new CheckedInt(this.value % value.getValue());
    }


    @Override
    public TypeWrapper<Integer> div(TypeWrapper<Integer> value) {
        Integer second = value.getValue();
        if (second == 0) {
            throw new DivisionByZeroException(String.valueOf(this.value));
        }
        if (this.value == Integer.MIN_VALUE && second == -1) {
            throw new ArithmeticOverflowException(this.value, second, "/");
        }
        return new CheckedInt(this.value / value.getValue());
    }

    @Override
    public TypeWrapper<Integer> neg() {
        if (this.value == Integer.MIN_VALUE) {
            throw new ArithmeticOverflowException(this.value, "-");
        }
        return new CheckedInt(-this.value);
    }

    @Override
    public TypeWrapper<Integer> not() {
        return new CheckedInt(~this.value);
    }

    @Override
    public TypeWrapper<Integer> bitCount() {
        return new CheckedInt(Integer.bitCount(this.value));
    }

    @Override
    public TypeWrapper<Integer> square(){
        Integer second = value;
        if (this.value > 0 && this.value > Integer.MAX_VALUE / second ||
                this.value < 0 && this.value < Integer.MAX_VALUE / second) {
            throw new ArithmeticOverflowException(this.value, second, "*");
        }
        return new CheckedInt(this.value * this.value);
    }

    @Override
    public TypeWrapper<Integer> abs(){
        if (this.value == Integer.MIN_VALUE) {
            throw new ArithmeticOverflowException(this.value, "abs");
        }
        if (this.value < 0) {
            this.value = -this.value;
        }
        return new CheckedInt(this.value);
    }
}

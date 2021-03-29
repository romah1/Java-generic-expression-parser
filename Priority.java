package expression;

public abstract class Priority {
    public static int OR = 2;
    public static int XOR = 4;
    public static int AND = 7;
    public static int SUBTRACT = 10;
    public static int ADD = 10;
    public static int MULTIPLY = 20;
    public static int MOD = 20;
    public static int DIVIDE = 20;
    public static int UNARY_MINUS = 30;
    public static int ABS = 30;
    public static int SQUARE = 30;
    public static int NOT = 30;
    public static int COUNT = 30;
    public static int CONST = 40;
    public static int VARIABLE = 40;
}

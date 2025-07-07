package models;

public enum OperationType {
    SUM(0, "Sum"),
    SUB(1, "Subtract"),
    MULTIPLICATION(2, "Multiplication"),
    DIVIDE(3, "Divide");

    private final int code;
    private final String name;

    OperationType(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int get_code() {
        return code;
    }

    public String get_name() {
        return name;
    }

    public static OperationType get_type_by_code(int code) {
        for (OperationType type : OperationType.values()) {
            if (type.get_code() == code) {
                return type;
            }
        }
        // It will never throw cause I validate code in App.Java
        throw new IllegalArgumentException("Invalid code : " + code); 
    }

    public double calc(double a, double b) {
        switch (this) {
            case OperationType.SUM -> {
                return a + b;
            }
            case OperationType.SUB -> {
                return a - b;
            }
            case OperationType.MULTIPLICATION -> {
                return a * b;
            }
            case OperationType.DIVIDE -> {
                return a / b;
            }
            default -> throw new IllegalArgumentException("Not found operation.");
        }
    }
}

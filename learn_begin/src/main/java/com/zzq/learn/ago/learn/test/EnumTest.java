package com.zzq.learn.ago.learn.test;

import java.util.function.DoubleBinaryOperator;

public enum EnumTest {
    PLUS("+", Double::sum),
    MINUS("-", (x, y) -> x - y),
    TIMES("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y);
    private final String symbol;
    private final DoubleBinaryOperator op;

    EnumTest(String symbol, DoubleBinaryOperator op) {
        this.symbol = symbol;
        this.op = op;
    }

    @Override
    public String toString() {
        return symbol;
    }

    public double apply(double x, double y) {
        return op.applyAsDouble(x, y);
    }


//    PLUS,
//    MINUS,
//    TIMES,
//    DIVIDE;
//    public int exec(int x, int y) {
//        switch (this) {
//            case PLUS:
//                return x+y;
//            case MINUS:
//                return x-y;
//            case DIVIDE:
//                return x*y;
//            case TIMES:
//                return x/y;
//            default:
//                return 0;
//        }
//    }
}

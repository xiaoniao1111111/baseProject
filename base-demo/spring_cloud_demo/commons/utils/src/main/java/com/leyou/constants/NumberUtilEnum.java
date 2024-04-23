package com.leyou.constants;

/**
 * 计算枚举
 *
 * @author WangXinWei
 * @version 1.0
 * @date 2020/12/23 9:45
 */
public enum NumberUtilEnum {
    /**
     * 加法运算
     */
    PLUS {
        @Override
        double eval(double x, double y) {
            return x + y;
        }
    },
    /**
     * 减法运算
     */
    MINUS {
        @Override
        double eval(double x, double y) {
            return x - y;
        }
    },
    /**
     * 乘法运算
     */
    TIMES {
        @Override
        double eval(double x, double y) {
            return x * y;
        }
    },
    /**
     * 除法运算
     */
    DIVIDED_BY {
        @Override
        double eval(double x, double y) {
            return x / y;
        }
    };


    abstract double eval(double x, double y);

    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);
        for (NumberUtilEnum op : NumberUtilEnum.values()) {
            System.out.println(x + " " + op + " " + y + "=" + op.eval(1,2));
        }
    }
}

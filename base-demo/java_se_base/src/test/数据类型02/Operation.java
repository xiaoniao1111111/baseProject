package test.数据类型02;

/**
 * 运算测试
 */
public class Operation {
    public static void main(String[] args) {
        // 算数运算符
        countTest();
        // 赋值运算符
         assignmentStatementTest();
    }

    /**
     * 算数运算符
     */
    public static  void  countTest(){
        int a=1;
        int b=a++;
        System.out.println("a的值为: "+a+",b的值为: "+b);
    }

    /**
     * 赋值运算符
     */
    public static void assignmentStatementTest(){
        int a=1;
        a+=2;
        System.out.println("赋值运算符:" + a);
    }
}

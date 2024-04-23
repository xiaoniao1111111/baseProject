package test.异常线程.String拼接;

/**
 *  // todo 待验证
 * @author Wang Xin Wei
 * @version 1.0
 * @date : 2022-06-14 21:00
 */
public class StringBuilder1 extends Thread{
    private String str="abc";
    private String append;

    public StringBuilder1(String append) {
        this.append = append;
    }

    public String getStr() {
        return str;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            StringBuilder builder = new StringBuilder(str);
            StringBuilder sb = builder.append(append);
            System.out.println(Thread.currentThread().getName()+"----"+sb);
            this.str = sb.toString();

        }
        StringBuffer buffer = new StringBuffer(str);
        StringBuffer bf = buffer.append(this.append);
        str = bf.toString();

    }
}

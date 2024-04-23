package Base64;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Base64;

/**
 * Base64加解密
 *
 * @Author: WangXinWei
 * @Date: 2019/12/12 17:42
 * @Version 1.0
 */
public class Base64Test {
    @Test
    public void testByBase64(){
        // getEncoder()
/*        String encodeToString = Base64.getEncoder().encodeToString("aaabbb".getBytes());
        System.out.println("编码后的结果: " + encodeToString);*/

        // getDecoder().decode
     /*   try {
            String encodeToString = Base64.getEncoder().encodeToString("aaabbb".getBytes("utf-8"));
            byte[] decode = Base64.getDecoder().decode(encodeToString);
            System.out.println("解码后的结果: " + new String(decode,"utf-8"));
        }catch (UnsupportedEncodingException e){
            System.out.println("Error: " + e.getMessage());
        }*/

        /*// getMimeEncoder()
        try {
            String encodeToString = Base64.getMimeEncoder().encodeToString("hellojava".getBytes("utf-8"));
            System.out.println("使用MIME编码结果为: " + encodeToString);
        }catch (UnsupportedEncodingException e){
            System.out.println("Error: " + e);
        }*/

        /*// getMimeEncoder()
        try {
            String encodeToString = Base64.getMimeEncoder().encodeToString("hellojava".getBytes("utf-8"));
            byte[] decode = Base64.getMimeDecoder().decode(encodeToString);
            System.out.println("使用MIME解码后的结果: " + new String(decode,"utf-8"));
        }catch (UnsupportedEncodingException e){
            System.out.println("Error: " + e);
        }*/

        /*// getUrlEncoder()
        try {
            String encodeToString = Base64.getUrlEncoder().encodeToString("urlaabbcc".getBytes("utf-8"));
            System.out.println("使用URL方式编码结果: " + encodeToString);
        }catch (UnsupportedEncodingException e){
            System.out.println("Error: " + e.getMessage());
        }*/
        // getUrlEncoder()
/*        try {
            String encodeToString = Base64.getUrlEncoder().encodeToString("urlaabbcc".getBytes("utf-8"));
            byte[] decode = Base64.getUrlDecoder().decode(encodeToString);
            System.out.println("使用URL方式解码结果: " + new String(decode,"utf-8"));
        }catch (UnsupportedEncodingException e){
            System.out.println("Error: " + e.getMessage());
        }*/
    }
}

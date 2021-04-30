package org.vulcan.light.algorithm;

/**
 * substring(beginIndex, endIndex)，第二个参数是下标，指的是截取到该下标为止，不包含该下标指向的字符
 *
 * @author Sam Lu
 * @date 2021/4/18
 */
public class StringTest {

    public static void main(String[] args) {
        String str = "10086";
        // print 100
        System.out.println(str.substring(0, 3));
        // print 00
        System.out.println(str.substring(1, 3));
    }

}

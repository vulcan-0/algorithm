package org.vulcan.light.algorithm;

/**
 * @author Sam Lu
 * @createdOn 2021/4/18
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

package bFindTheAnswer.leetcode.easy;

import org.junit.Test;

/**
 * Created by drudg on 2017/5/31.
 */
public class ReverseString {

    @Test
    public void  stringTest(){
        String s="aA";

        System.out.println(reverseString(s));
    }

    public String reverseString(String s) {
        int size=s.length();

        int l=size%2==0?size/2:size/2+1;

        char[] charTemp=s.toCharArray();
        char temp;
        for (int i = 0; i <=l-1; i++) {
        temp=charTemp[i];
        charTemp[i]=charTemp[size-i-1];
        charTemp[size-i-1]=temp;
        }
        s=String.valueOf(charTemp);

        return s;
    }
}

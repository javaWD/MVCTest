package bFindTheAnswer.leetcode.easy;

import org.junit.Test;

/**
 * Created by drudg on 2017/6/1.
 */
public class ReverseVowels {

    @Test
    public void  stringTest(){
        String s="aA";

        System.out.println(reverseVowels(s));
    }

    public String reverseVowels(String s) {
        StringBuffer strB=new StringBuffer();
        String vowelsStr="aeiouAEIOU";
        char[] sChars=s.toCharArray();
        for (int i = 0; i <=s.length()-1; i++) {
            if(vowelsStr.contains(String.valueOf(sChars[i]))){
                strB.append(sChars[i]);
            }
        }
        char[] reverseChar=reverseString(strB.toString()).toCharArray();
        int index=0;
        for (int i = 0; i <=s.length()-1; i++) {
            if(vowelsStr.contains(String.valueOf(sChars[i]))){
                sChars[i]=reverseChar[index];
                index++;
            }
        }
        return String.valueOf(sChars);
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

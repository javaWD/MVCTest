package bFindTheAnswer.leetcode.easy;

import org.junit.Test;

/**
 * Created by drudg on 2017/6/1.
 */
public class NumberOfSegments {

    @Test
    public void  stringTest(){
        //String s="The one-hour drama series Westworld is a dark odyssey about the dawn of artificial consciousness and the evolution of sin.Set at the intersection of the near future and the reimagined past, it explores a world in which every human appetite, no matter how noble or depraved, can be indulged.";
        String s="      ";
        System.out.println(countSegments2(s));
    }

    public int countSegments(String s) {
        char[] temp=s.toCharArray();
        s=s.replace("\"","");
        String ziMu="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ'1234567890";
        int index=0;
        s=s.trim();
        if(s.length()==0){
            return 0;
        }
        for (int i = 0; i <=s.length()-1-1; i++) {
                if((ziMu.contains(String.valueOf(temp[i]))&&!ziMu.contains(String.valueOf(temp[i+1])))||
                        (!ziMu.contains(String.valueOf(temp[i]))&&ziMu.contains(String.valueOf(temp[i+1])))){
                    index++;
                }
        }

        return index/2+1;
    }

    public int countSegments2(String s) {
        int index = 0;
        char[] chars = s.toCharArray();
        for(int i=0;i<chars.length;i++) {
            if(chars[i]!=' ') index++;
            while(i<chars.length && chars[i]!=' ')
                i++;
        }
        return index;
    }
}

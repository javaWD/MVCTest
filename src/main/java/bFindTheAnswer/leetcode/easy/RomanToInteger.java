package bFindTheAnswer.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by drudg on 2017/6/2.
 */
public class RomanToInteger {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int addr=0;
        int count=0;

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
//            if(ch<s.charAt){
//
//            }

        }

        return 0;
    }
}

package demo1;

import java.util.HashMap;
import java.util.Map;

public class Temp {
//Given a string s, find the length of the longest
//substring
// without repeating characters.
//
//
//
//Example 1:
//
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length
    //pwwkefew
//
//dvdf
    public static void main(String[] args) {
        Map<Character,Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int counter = 0;
        String str = "dvdf";
        int pos = 0;

        for(int i=0;i<str.length();i++){
            System.out.println("i :: "+i);
            char curr = str.charAt(i);
            if(!map.containsKey(curr)){
                map.put(curr,1);
                counter++;
            }
            else{
                counter  =1;
                map = new HashMap<>();
                map.put(curr,1);
            }
            if(counter > max){
                max = counter;
            }
        }

        System.out.println("max = "+max);
    }
}

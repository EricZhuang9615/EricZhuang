import java.util.*;
/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 */

// @lc code=start
class Solution {
    public static Map<Character, String> map = 
    Map.of('2', "abc", '3', "def", '4', "ghi", '5', "jkl", '6', "mno",
    '7', "pqrs", '8', "tuv", '9', "wxyz");

    public static List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<String>();
        // 1. regular method, iterative
        // if(digits.length()==0) return ret;
        // int len = 0;int index = 0;
        // for(int i = digits.length()-1;i>=0;i--){
        //     if(i==digits.length()-1){
        //         //first time, initialize
        //         for(Character c : map.get(digits.charAt(i))){
        //             ret.add(new String(Character.toString(c)));
        //         }
        //     }else{
        //         len = ret.size();
        //         for(int j = index;j<len;j++){
        //             for(Character c : map.get(digits.charAt(i))){
        //                 ret.add(c+ret.get(j));
        //             }
        //         }
        //         index = len;
        //     }
        // }
        // return ret.subList(index, ret.size());

        // 2. Backtracking method
        /**
         * s(digits[0...n-1])
         *  = map(digits[0]) + s(digits[1..n-1])
         *  = map(digits[0]) + letter(digits[1]) + s(digits[2..n-1])
         */
        letterCombination(ret, digits, 0);
        return ret;
    }

    public static void letterCombination(List<String> ret, String digits, int start) {
        if(start==digits.length()-1) return;
        if(start==0){
            for(String c : map.get(digits.charAt(start)).split("")){
                String str = c + "";
                ret.add(str);
            }
            letterCombination(ret, digits, start++);
        }else{
            for(int i = 0;i<ret.size();i++){
                for(String c : map.get(digits.charAt(start)).split("")){
                    ret.set(i, ret.get(i)+c);
                }
            }
            letterCombination(ret, digits, start++);
        }
    }

    public static void main(String[] args){
        System.out.println(letterCombinations("23"));
    }
}
// @lc code=end


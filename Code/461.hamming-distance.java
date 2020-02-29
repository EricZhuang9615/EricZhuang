/*
 * @lc app=leetcode id=461 lang=java
 *
 * [461] Hamming Distance
 */

// @lc code=start
class Solution {
    public int hammingDistance(int x, int y) {
        int count = 0;
        while(x>0 | y>0){
            count = (x%2 != y%2) ? count+1 : count;
            x /= 2;
            y /= 2;   
        }
        return count;
    }
}
// @lc code=end

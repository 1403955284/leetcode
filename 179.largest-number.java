import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=179 lang=java
 *
 * [179] Largest Number
 */

// @lc code=start
class Solution {
    public String largestNumber(int[] nums) {
        String[] sarray = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            sarray[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(sarray, (a, b) -> (b+a).compareTo(a+b));
        if(sarray[0].equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for(String s : sarray) {
            sb.append(s);
        }
        return sb.toString();
    }
}
// @lc code=end

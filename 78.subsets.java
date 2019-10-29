import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        int length=nums.length;
        List<Integer> init=new ArrayList<>();
        List<Integer> init2=new ArrayList<>();
        init.add(nums[0]);
        ans.add(init);
        ans.add(init2);
        for(int i=1;i<length;i++){
            int curLength=ans.size();
            for(int j=0;j<curLength;j++){
                List<Integer> modifList=new ArrayList<>(ans.get(j));
                modifList.add(nums[i]);
                ans.add(modifList);
            }
        }
        return ans;

    }
}
// @lc code=end


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=315 lang=java
 *
 * [315] Count of Smaller Numbers After Self
 */

// @lc code=start
class Solution {

    class Node{
        // 当前节点存的值
        int val;
        // 比当前节点所存的值小的节点个数
        int count;
        Node right;
        Node left;
        public Node(int val){
            this.val = val;
            this.count = 0;
            this.left = null;
            this.right = null;
        }

    }
    public List<Integer> countSmaller(int[] nums) {
        if(nums==null||nums.length==0){
            return new LinkedList<>();
        }

        /**
         * 暴力解法
         */
        // List<Integer> ans = new LinkedList<>();
        // for(int i = 0;i<nums.length;i++){
        //     int curNum = nums[i];
        //     int curCount = 0;
        //     for(int j = i+1;j<nums.length;j++){
        //         if(nums[j]<curNum){
        //             curCount++;
        //         }
        //     }
        //     ans.add(curCount);
        // }
        // return ans;


        /**
         * 利用BST,未调通
         */
        // List<Integer> ans = new LinkedList<>();
        // Node root = null;
        // for(int i = nums.length-1;i>=0;i--){
        //     ans.add(insert(root,nums[i]));
        // }
        // Collections.reverse(ans);
        // return ans;
    }

    public int insert(Node root,int val){
        int ans = 0;
        if(root==null){
            root = new Node(val);
        }
        else{
            if(val>=root.val){
                ans+=(val==root.val?root.count:root.count+1);
                ans+=insert(root.right, val);
            }else{
                root.count++;
                ans+=insert(root.left, val);
            }
        }
        return ans;
    }

}
// @lc code=end


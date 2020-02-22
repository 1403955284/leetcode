import java.util.Random;

/*
 * @lc app=leetcode id=384 lang=java
 *
 * [384] Shuffle an Array
 */

// @lc code=start
class Solution {
    private int[] data;
    Random rand = new Random();

    private int randRange(int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    private void swapAt(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public Solution(int[] nums) {
        this.data = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return data;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] tmp = new int[data.length];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = data[i];
        }
        for (int i = 0; i < tmp.length; i++) {
            swapAt(tmp, i, randRange(i, tmp.length));
        }
        return tmp;
    }
}

/**
 * Your Solution object will be instantiated and called as such: Solution obj =
 * new Solution(nums); int[] param_1 = obj.reset(); int[] param_2 =
 * obj.shuffle();
 */
// @lc code=end

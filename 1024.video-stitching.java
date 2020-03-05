import java.util.Arrays;
import java.util.Comparator;

/*
 * @lc app=leetcode id=1024 lang=java
 *
 * [1024] Video Stitching
 */

// @lc code=start
class Solution {
    public int videoStitching(int[][] clips, int T) {
        Arrays.sort(clips, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o2[1] - o1[1];
                }
            }

        });
        int ans = 0;
        int y = 0;
        if (clips[0][0] != 0) {
            return -1;
        }
        for (int i = 0, j = 0; i < clips.length; i++) {
            if (y >= T) {
                break;
            }
            int max = y;
            while (j < clips.length && clips[j][0] <= y) {
                max = Math.max(max, clips[j][1]);
                j++;
            }
            if (i == j) {
                return -1;
            }
            i = j - 1;
            y = max;
            ans++;
        }
        return y >= T ? ans : -1;
    }
}
// @lc code=end

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=757 lang=java
 *
 * [757] Set Intersection Size At Least Two
 */

// @lc code=start
class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        ArrayList<Integer> result = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] != o2[0]) {
					return o1[0] - o2[0];
				}
				return o2[1] - o1[1];
			}
		});
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int i = intervals.length - 1;
        while (i >= 0) {
        	ArrayList<Integer> l = new ArrayList<>();
        	l.add(intervals[i][0]);
        	l.add(intervals[i][1]);
        	list.add(l);
        	int j = i - 1;
        	while (j >= 0 && intervals[j][1] >= intervals[i][1]) {
        		j--;
        	}
        	
        	if (j < 0) {
    			break;
    		}
        	
        	i = j;
        }
        int size = list.size();
        result.add(list.get(size - 1).get(1) - 1);
        result.add(list.get(size - 1).get(1));
        for (i = size - 2; i >= 0; i--) {
        	int begin = list.get(i).get(0);
        	int end = list.get(i).get(1);
        	if (result.get(result.size() - 1) >= begin && result.get(result.size() - 2) >= begin) {
        		continue;
        	} else if (result.get(result.size() - 1) >= begin) {
        		result.add(end);
        	} else {
        		result.add(end - 1);
        		result.add(end);
        	}
        }
        return result.size();
    }
}
// @lc code=end


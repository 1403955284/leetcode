import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=763 lang=java
 *
 * [763] Partition Labels
 */

// @lc code=start
class Solution {
    public List<Integer> partitionLabels(String S) {
        // =================================== 13% ============================

        /**
         *首先统计每个字母最先出现和最后出现的索引位置，并以最先出现的索引位置的升序排序
         *遍历排好序的list，max记录当前以遍历的元素中最后出现索引位置的最大值。
         *当遍历到某一元素的第一次出现位置的索引大于当前max时，则当前所有已遍历过的元素可以被划分为一个子划分
         *例："ababcbacadefegdehijhklij"，其所有字母出现的最早和最迟索引位置如下
         *a-> 0,8
         *b-> 1,5
         *c-> 4,7
         *d-> 9,14
         *e-> 10,15
         *f-> 11,11
         *g-> 13,13
         *h-> 16,19
         *i-> 17,22
         *j-> 18,23
         *k-> 20,20
         *l-> 21,21
         *
         * 当遍历到 d -> 9,14 时
         * 9比当前已遍历过 a,b,c中的max 8要大，所以第一个子划分的长度为 9-0 = 9
         * 
         * 当遍历到 h -> 16,19时
         * 16比当前已遍历过的d,e,f中的max 15要大，所以第二个子划分的长度为 16-9 = 8 
         * 
         * 当遍历到最末端时，要用 curStart-max+1
         * 
         * 
         */

        Map<Character,int[]> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for(int i = 0;i<S.length();i++){
            Character cur = S.charAt(i);
            if(map.containsKey(cur)){
                int[] tmp = map.get(cur);
                tmp[1] = i;
                map.put(cur, tmp);
            }else{
                int[] tmp = new int[2];
                tmp[0] = i;
                tmp[1] = i;
                map.put(cur, tmp);
            }
        }
        map.forEach((k,v) -> {
            System.out.println(k+"-> "+v[0]+","+v[1]);
        });
        List<int[]> list = new LinkedList<>();
        map.forEach((k,v) ->list.add(v));
        list.sort(new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        for(int i = 0;i<list.size();){
            int curStart = list.get(i)[0];
            int max = list.get(i)[1];
            while(i<list.size()&&list.get(i)[0]<=max){
                max = Math.max(max, list.get(i)[1]);
                i++;
            }
            if(i==list.size()){
                ans.add(max-curStart+1);
            }else{
                ans.add(list.get(i)[0]-curStart);
            }
        }
        return ans;
    }
    // "eccbbbbdec"
    // "caedbdedda"
}
// @lc code=end


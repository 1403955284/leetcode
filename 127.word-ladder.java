import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 */

// @lc code=start
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // floyed算法，超时
        // if (!wordList.contains(endWord)) {
        // return 0;
        // }
        // List<String> newWordList = new LinkedList<>();
        // newWordList.add(beginWord);
        // wordList.forEach(e -> {
        // if (!newWordList.contains(e)) {
        // newWordList.add(e);
        // }
        // });
        // int[][] graph = new int[newWordList.size()][newWordList.size()];
        // // 初始化一个图
        // int count = 0;
        // for (int i = 0; i < graph.length; i++) {
        // for (int j = 0; j < graph.length; j++) {
        // if (isJustOneDiff(i, j, newWordList)) {
        // graph[i][j] = 1;
        // count++;
        // } else {
        // graph[i][j] = Integer.MAX_VALUE;
        // }
        // }
        // }
        // for (int i = 0; i < graph.length; i++) {
        // graph[i][i] = 0;
        // }
        // if (count == 0) {
        // return 0;
        // }
        // int targetIndex = 0;
        // for (int i = 0; i < newWordList.size(); i++) {
        // if (endWord.equals(newWordList.get(i))) {
        // targetIndex = i;
        // break;
        // }
        // }
        // }
        // for(int k = 0;k<graph.length;k++){
        // for(int i = 0;i<graph.length;i++){
        // for(int j = 0;j<graph.length;j++){
        // if(graph[i][k]!=Integer.MAX_VALUE&&graph[k][j]!=Integer.MAX_VALUE){
        // if(graph[i][j]>graph[i][k]+graph[k][j]){
        // graph[i][j] = graph[i][k]+graph[k][j];
        // }
        // }
        // }
        // }
        // }
        // for (int i = 0;i<graph.length;i++){
        // for (int j = 0;j<graph.length;j++){
        // System.out.print(graph[i][j]+" ");
        // }
        // System.out.println(" ");
        // }
        // newWordList.forEach(e -> System.out.println(e));
        // System.out.println(targetIndex);
        // return graph[0][targetIndex]==Integer.MAX_VALUE?0:graph[0][targetIndex]+1;



        
        // ============================== 答案 ================================

        // edge cases
        int endWordIndex = wordList.indexOf(endWord);
        if (endWordIndex < 0)
            return 0;
        else if (similar(beginWord, endWord))
            return 2;
        // if this word is checked
        boolean[] distance = new boolean[wordList.size()];
        distance[endWordIndex] = true;
        List<Integer> todo = new ArrayList<>();
        todo.add(endWordIndex);
        return checkLevel(beginWord, endWord, wordList, distance, 1, todo);

    }

    public boolean isJustOneDiff(int i, int j, List<String> wordList) {
        String str1 = wordList.get(i);
        String str2 = wordList.get(j);
        int count = 0;
        for (int k = 0; k < str1.length(); k++) {
            if (count > 1) {
                break;
            }
            if (str1.charAt(k) != str2.charAt(k)) {
                count++;
            }
        }
        return count == 1;
    }

    public boolean similar(String w1, String w2) {
        boolean diff = false;
        for (int i = 0; i < w1.length(); i++) {
            if (w1.charAt(i) != w2.charAt(i)) {
                if (diff)
                    return false;
                diff = true;
            }
        }
        return true;
    }

    public int checkLevel(String beginWord, String endWord, List<String> wordList, boolean[] distance, int level,
            List<Integer> todo) {
        // BFS
        List<Integer> newTodo = new ArrayList<>();
        for (int i = 0; i < todo.size(); i++) {
            int endIndex = todo.get(i);
            String end = wordList.get(todo.get(i));
            for (int j = 0; j < wordList.size(); j++) {
                if (distance[j] || j == endIndex)
                    continue;
                String word = wordList.get(j);
                if (similar(word, end)) {
                    distance[j] = true;
                    newTodo.add(j);
                    if (similar(word, beginWord))
                        return level + 2;
                }
            }
        }
        if (newTodo.size() > 0)
            return checkLevel(beginWord, endWord, wordList, distance, level + 1, newTodo);
        else
            return 0;
    }

    public static int[] Dijsktra(int[][] weight, int start) {

        int length = weight.length;// 获取顶点个数

        int[] shortPath = new int[length];// 最短路径数组

        shortPath[0] = 0;//

        String[] path = new String[length];// 记录起始点到各定点的最短路径

        for (int i = 0; i < length; i++) {

            path[i] = start + "->" + i;
        }

        int[] visited = new int[length];// 记录当前顶点的最短路径是否已经求出，1表示已求出

        for (int i = 0; i < length; i++) {

            visited[i] = 0;
        }

        visited[0] = 1;// 起始点的最短路径已经求出

        for (int m = 1; m < length; m++) {

            int k = -1;

            int dmin = Integer.MAX_VALUE;

            // 选择一个离起始点最近的未标记顶点，且到起始点的最短路径为dmin
            for (int n = 0; n < length; n++) {

                if (visited[n] == 0 && weight[start][n] < dmin) {

                    dmin = weight[start][n];

                    k = n;
                }
            }

            shortPath[k] = dmin;

            visited[k] = 1;

            // 以k为中间点，更新起始点到其他未标记各点的距离
            for (int j = 0; j < length; j++) {

                if (visited[j] == 0 && weight[k][j] != Integer.MAX_VALUE
                        && weight[start][k] + weight[k][j] < weight[start][j]) {

                    weight[start][j] = weight[start][k] + weight[k][j];

                    path[j] = path[k] + "->" + j;
                }
            }
        }

        for (int i = 1; i < length; i++) {

            System.out.println("起始点到" + i + "的最短路径为:" + path[i] + "距离为：" + shortPath[i]);
        }
        return shortPath;
    }
}
// @lc code=end

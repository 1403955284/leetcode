import com.sun.corba.se.impl.orbutil.graph.Node;

/*
 * @lc app=leetcode id=559 lang=java
 *
 * [559] Maximum Depth of N-ary Tree
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    private int ans = 0;
    public int maxDepth(Node root) {
        visit(root, 1);
        return ans;
    }

    private void visit(Node root,int deep){
        if(root == null){
            return;
        }
        ans = Math.max(ans, deep);
        if(root.children!=null){
            root.children.forEach(e ->{
                visit(e,deep+1);
            });
        }
    }
}
// @lc code=end


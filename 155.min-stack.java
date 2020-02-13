import java.util.Stack;

/*
 * @lc app=leetcode id=155 lang=java
 *
 * [155] Min Stack
 */

// @lc code=start
class MinStack {

    private Stack<Integer> stackData;
    private Stack<Integer> minData;

    /** initialize your data structure here. */
    public MinStack() {
        stackData = new Stack<>();
        minData = new Stack<>();
    }

    public void push(int x) {
        stackData.push(x);
        if (minData.isEmpty() || minData.peek() >= x) {
            minData.push(x);
        }
    }

    public void pop() {
        int cur = stackData.pop();
        if (minData.peek() == cur) {
            minData.pop();
        }
    }

    public int top() {
        return stackData.peek();
    }

    public int getMin() {
        return minData.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4
 * = obj.getMin();
 */
// @lc code=end

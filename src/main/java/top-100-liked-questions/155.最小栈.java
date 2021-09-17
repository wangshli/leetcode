/*
 * @lc app=leetcode.cn id=155 lang=java
 *
 * [155] 最小栈
 */

// @lc code=start
class MinStack {
    List<Integer> mStack;
    List<Integer> minStack;
    int t;

    /** initialize your data structure here. */
    public MinStack() {
        mStack = new ArrayList<Integer>();
        minStack = new ArrayList<Integer>();
        minStack.add(Integer.MAX_VALUE);
        t = 0;
    }
    
    public void push(int val) {
        mStack.add(val);
        minStack.add(Math.min(minStack.get(t), val));
        t++;
    }
    
    public void pop() {
        mStack.remove(t - 1);
        minStack.remove(t);
        t--;
    }
    
    public int top() {
        return mStack.get(t - 1);
    }
    
    public int getMin() {
        return minStack.get(t);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end


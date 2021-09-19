/*
 * @lc app=leetcode.cn id=208 lang=java
 *
 * [208] 实现 Trie (前缀树)
 */

// @lc code=start
class Trie {
    private Trie[] children;
    private boolean isEnd;

    /** Initialize your data structure here. */
    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie node = this;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            int ind = ch - 'a';
            if(node.children[ind] == null){
                node.children[ind] = new Trie();
            }
            node = node.children[ind];
        }
        node.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node = this;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            int ind = ch - 'a';
            if(node.children[ind] == null){
                return false;
            }else{
                node = node.children[ind];
            }
        }
        return node.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie node = this;
        for(int i = 0; i < prefix.length(); i++){
            char ch = prefix.charAt(i);
            int ind = ch - 'a';
            if(node.children[ind] == null){
                return false;
            }else{
                node = node.children[ind];
            }
        }
        return true;
    }

    
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end


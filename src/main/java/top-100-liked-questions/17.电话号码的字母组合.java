/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
class Solution {
    //hashmap+回溯
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<String>();
        if(digits.length() == 0)  return ans;
        Map<Character, String> mapping = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        func(ans, mapping, digits, 0, new StringBuffer());
        return ans;
    }

    public void func(List<String > ans, Map<Character, String> mapping, String digits, int index, StringBuffer s){
        if(index == digits.length()){
            ans.add(s.toString());
        }else{
            char num = digits.charAt(index);
            String letters = mapping.get(num);
            for(int i = 0; i < letters.length(); i++){
                s.append(letters.charAt(i));
                func(ans, mapping, digits, index + 1, s);
                s.deleteCharAt(index);
            }
        }
    }
}
// @lc code=end


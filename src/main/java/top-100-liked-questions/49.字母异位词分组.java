/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */

// @lc code=start
class Solution {
    /**
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<List<String>>();
        List<String> strsaslist = Arrays.asList(strs);
        List<String> strsList = new ArrayList<String>(strsaslist);
        int n = strsList.size();
        while(n > 0){
            String s = strsList.get(0);
            List<String> temp = new ArrayList<String>();
            temp.add(s);
            n--;
            strsList.remove(0);
            Map<Character, Integer> map = new HashMap<Character, Integer>();
            for(int i = 0; i < s.length(); i++){
                map.put(s.charAt(i), i);
            }
            int j = 0;
            while (j < strsList.size()){
                if(strsList.get(j).length() == s.length()){
                    int k = 0;
                    while(k < s.length() && map.containsKey(strsList.get(j).charAt(k))){
                        k++;
                    }
                    if(k == s.length()){
                        temp.add(strsList.get(j));
                        strsList.remove(j);
                        n--;
                    }else{
                        j++;
                    }
                }else{
                    j++;
                }
            }
            ans.add(new ArrayList<String>(temp));
        }
        return ans;
    }
    */
    /**
    
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            int[] counts = new int[26];
            int length = str.length();
            for (int i = 0; i < length; i++) {
                counts[str.charAt(i) - 'a']++;
            }
            // 将每个出现次数大于 0 的字母和出现次数按顺序拼接成字符串，作为哈希表的键
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 26; i++) {
                if (counts[i] != 0) {
                    sb.append((char) ('a' + i));
                    sb.append(counts[i]);
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
    */

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }

}
// @lc code=end


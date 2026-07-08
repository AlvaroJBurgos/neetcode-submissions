class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int length = 0;
        int start = 0;

        for (int i = 0; i <s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                start = Math.max(map.get(s.charAt(i)) + 1, start);
            }      
            length = Math.max(length, (i - start + 1));          
            map.put(s.charAt(i), i);
        }
        return length;
    }
}

// abcabcbb

// 1.
// a, i = 0; start = 0; length = 1
// 2.
// b, i = 1, start = 0; length = 2
// 3. 
// c, i = 2, start = 0; length = 3
// 4.
// a, i = 4, start = 1, length = 3
// 5.
// b, i = 5, start = 2, length = 3
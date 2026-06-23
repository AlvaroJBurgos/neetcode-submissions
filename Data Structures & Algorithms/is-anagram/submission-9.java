class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        Map<Character, Integer> mapS = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (mapS.containsKey(c)) {
                int newCount = mapS.get(c) + 1;
                mapS.put(c, newCount);
            } else {
                mapS.put(c, 1);
            }
        }

        for (char c : t.toCharArray()) {
            if (!mapS.containsKey(c))
                return false;
            else {
                int newCount = mapS.get(c) - 1;
                if (newCount == 0) {
                    mapS.remove(c);
                } else
                    mapS.put(c, newCount);
            }
        }
        return true;
    }
}
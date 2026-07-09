class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] arrayS1 = new int[26];
        boolean isPermutation = false;
        int[] arrayS2 = new int[26];

        for (char c : s1.toCharArray()) {
            arrayS1[c - 'a']++;
        }

        for (int i = 0; i < s1.length(); i++) {
            arrayS2[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(arrayS1, arrayS2)) {
            return true;
        }

        for (int j = s1.length(); j < s2.length(); j++) {
            arrayS2[s2.charAt(j - (s1.length())) - 'a']--;
            arrayS2[s2.charAt(j) - 'a']++;

            if (Arrays.equals(arrayS2, arrayS1)) return true;
        }
        return false;
    }
}

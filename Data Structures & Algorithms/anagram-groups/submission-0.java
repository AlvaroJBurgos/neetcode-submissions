class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> solution = new HashMap<>();
        List<List<String>> list = new ArrayList<>();

        for (String str : strs) {
            int[] word = new int[26];
            for (int i = 0; i < str.length(); i++) {
                word[str.charAt(i) - 'a']++;
            }
            String frequency = Arrays.toString(word);
            if (solution.get(frequency) != null) {
                solution.get(frequency).add(str);
            } else {
                solution.put(frequency, new ArrayList<String>());
                solution.get(frequency).add(str);
            }
        }
        for(Map.Entry<String, List<String>> e : solution.entrySet()) {
            list.add(e.getValue());
        }

        return list;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        Map<Integer, List<Integer>> buckets = new HashMap<>();
        for(int i = 1; i <= nums.length; i++) {
            buckets.put(i, new ArrayList<>());
        }

        for(int num : nums) {
            //map.computeIfAbsent(num, count -> )
            if(map.get(num)!= null) {
                map.put(num, map.get(num) + 1);
            }
            else map.put(num, 1);
        }
        for(Map.Entry<Integer,Integer> e : map.entrySet()) {
            int key = e.getValue();
            int number = e.getKey();
            List<Integer> list = buckets.get(key);
            list.add(number);
            buckets.put(key, list);
            // buckets.put(e.getValue(), buckets.get(e.getValue).add(e.getKey));
            // buckets.put
        }
        int j = k;
        int l = nums.length;
        List<Integer> solution = new ArrayList<>();
        while (j > 0 && l > 0) {
            List<Integer> list = buckets.get(l);
            if(!list.isEmpty()) {
                for (int num : list) {
                    solution.add(num);
                    j--;
                    if(j==0) break;
                }
            }
            l--;
        }
        int size = solution.size();
        int[] answer = new int[size];
        int i = 0;
        for(int num : solution) {
            answer[i] = num;
            i++;
        }
        return answer;
        
    }
}

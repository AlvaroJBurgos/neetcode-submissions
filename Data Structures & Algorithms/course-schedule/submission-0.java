class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            if (map.containsKey(prerequisites[i][0])) {
                map.get(prerequisites[i][0]).add(prerequisites[i][1]);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(prerequisites[i][1]);
                map.put(prerequisites[i][0], set);
            }
        }
        Set<Integer> safeCourses = new HashSet<>();
        for (Map.Entry<Integer, Set<Integer>> e : map.entrySet()) {
            if (safeCourses.contains(e.getKey())) {
                continue;
            }
            Set<Integer> currentPath = new HashSet<>();
            if (isDfsCycle(map, currentPath, e.getKey(), safeCourses))
                return false;
        }
        return true;
    }
    private boolean isDfsCycle(Map<Integer, Set<Integer>> map, Set<Integer> currentPath, int course,
        Set<Integer> safeCourses) {
        if (currentPath.contains(course))
            return true;
        else if (!map.containsKey(course) || safeCourses.contains(course)) {
            return false;
        }
        currentPath.add(course);
        for (int prerequisite : map.get(course)) {
            if (isDfsCycle(map, currentPath, prerequisite, safeCourses)) {
                return true;
            }
        }
        safeCourses.add(course);
        currentPath.remove(course);
        
        return false;
    }
}

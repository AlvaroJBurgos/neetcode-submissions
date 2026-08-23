/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> visited = new HashMap<>();
        // Node solution = node;
        Deque<Node> nextVisit = new ArrayDeque<>();
        if (node == null)
            return null;
        nextVisit.offer(node);

        while (!nextVisit.isEmpty()) {
            Node current = nextVisit.poll();
            ArrayList<Node> clonedNeighbors = new ArrayList<>();
            if (!visited.containsKey(current)) {
                Node cloneCurrent = new Node(current.val);
                visited.put(current, cloneCurrent);
            }
            for (int i = 0; i < current.neighbors.size(); i++) {
                if (!visited.containsKey(current.neighbors.get(i))) {
                    int val = current.neighbors.get(i).val;
                    Node cloneNeighbor = new Node(val);
                    visited.put(current.neighbors.get(i), cloneNeighbor);
                    clonedNeighbors.add(cloneNeighbor);
                    nextVisit.offer(current.neighbors.get(i));
                } else {
                    clonedNeighbors.add(visited.get(current.neighbors.get(i)));
                }

            }
            visited.get(current).neighbors= clonedNeighbors;
        }
        return visited.get(node);
    }
}

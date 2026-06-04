class LinkedList {
    private class Node {
        private int value;
        private Node nextNode;

        public Node(int value, Node nextNode) {
            this.value = value;
            this.nextNode = nextNode;
        }
    }

    private Node head;
    private Node tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        // this.size = 0;
    }

    public int get(int index) {
        if (head == null)
            return -1;
        Node actual = head;
        int i = 0;
        while (i <= index && actual != null) {
            if (i == index) {
                return actual.value;
            } else {
                actual = actual.nextNode;
                i++;
            }
        }
        return -1;
    }

    public void insertHead(int val) {
        if (head == null) {
            head = new Node(val, null);
            tail = head;
        } else {
            Node newHead = new Node(val, head);
            head = newHead;
        }
    }

    public void insertTail(int val) {
        if (tail == null) {
            tail = new Node(val, null);
            head = tail;
        } else {
            Node newTail = new Node(val, null);
            tail.nextNode = newTail;
            tail = newTail;
        }
    }

    public boolean remove(int index) {
        if (head == null)
            return false;

        if (index == 0) {
            head = head.nextNode;
            if (head == null) {
                tail = null;
            }
            return true;
        }

        Node prev = head;
        int i = 0;

        while (i < index - 1 && prev != null) {
            prev = prev.nextNode;
            i++;
        }

        if (prev == null || prev.nextNode == null) {
            return false;
        }

        Node target = prev.nextNode;

        prev.nextNode = target.nextNode;

        if (target == tail) {
            tail = prev;
        }

        return true;
    }

    public ArrayList<Integer> getValues() {
        Node actual = head;
        ArrayList<Integer> resul = new ArrayList<>();
        while (actual != null) {
            resul.add(actual.value);
            actual = actual.nextNode;
        }
        return resul;
    }
}

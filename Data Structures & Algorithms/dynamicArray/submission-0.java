class DynamicArray {
    int[] myArray;
    int capacity;
    int size;

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.myArray = new int[capacity];
    }

    public int get(int i) {
        return myArray[i];
    }

    public void set(int i, int n) {
        myArray[i] = n;
    }

    public void pushback(int n) {
        if (capacity == size) {
            resize();
        }
        myArray[size] = n;
        size++;
    }

    public int popback() {
        int result = myArray[size - 1];
        size--;
        return result;
    }

    private void resize() {
       int[] doubleArray = new int[capacity * 2];
        for (int i = 0; i < size; i++) {
            doubleArray[i] = myArray[i];
        }
        myArray = doubleArray;
        capacity *= 2;
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return this.capacity;
    }
}

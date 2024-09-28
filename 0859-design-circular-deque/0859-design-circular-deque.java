class MyCircularDeque {
    private int[] v;
    private int front, back, size, capacity;

    public MyCircularDeque(int k) {
        v = new int[k];
        Arrays.fill(v, -1); // Initialize the deque with -1
        front = 0;
        back = 0;
        size = 0; // Keeps track of the current number of elements
        capacity = k;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }

        // Way - 01
        if (front == 0) {
            front = capacity - 1; // Wrap around to the end
        } else {
            front--; // Simply decrement front
        }

        // Way - 02 (Alternative method commented out)
        // front = (front - 1 + capacity) % capacity;

        v[front] = value;
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }

        v[back] = value;

        // Way - 01
        if (back == capacity - 1) {
            back = 0; // Wrap around to the beginning
        } else {
            back++; // Simply increment back
        }

        // Way - 02 (Alternative method commented out)
        // back = (back + 1) % capacity;

        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }

        v[front] = -1;

        // Way - 01
        if (front == capacity - 1) {
            front = 0; // Wrap around to the beginning
        } else {
            front++; // Simply increment front
        }

        // Way - 02 (Alternative method commented out)
        // front = (front + 1) % capacity;

        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }

        if (back == 0) {
            back = capacity - 1; // Wrap around to the end
        } else {
            back--; // Simply decrement back
        }
        v[back] = -1;

        size--;
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return v[front];
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        if (back == 0) {
            return v[capacity - 1]; // Wrap around to the last valid element
        } else {
            return v[back - 1]; // Get the last element
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}
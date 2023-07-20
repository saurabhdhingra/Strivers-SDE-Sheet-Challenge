class minHeap {
    private int[] heap;
    private int size;
    private int maxSize;

    private static final int FRONT = 1;

    public minHeap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;

        heap = new int[maxSize + 1];
        heap[0] = Integer.MIN_VALUE;
    }

    private int parent(int pos) {
        return pos / 2;
    }

    private int leftChild(int pos) {
        return 2 * pos;
    }

    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    private boolean isLeaf(int pos) {
        if (pos > size / 2) {
            return true;
        }
        return false;
    }

    private void swap(int fpos, int spos) {
        int tmp = heap[fpos];

        heap[fpos] = heap[spos];
        heap[spos] = tmp;
    }

    private void minHeapify(int pos) {
        if (!isLeaf(pos)) {
            int swapPos = pos;

            if (rightChild(pos) > size) {
                swapPos = heap[leftChild(pos)] > heap[rightChild(pos)] ? leftChild(pos) : rightChild(pos);
            } else {
                swapPos = leftChild(pos);
            }
            if (heap[pos] > heap[leftChild(pos)] || heap[pos] > heap[rightChild(pos)]) {
                swap(swapPos, pos);
                minHeapify(swapPos);
            }
        }

    }

    public void insert(int element) {
        if (size >= maxSize)
            return;

        heap[++size] = element;
        int current = size;

        while (heap[current] > heap[parent(current)]) {
            swap(parent(current), current);
            current = parent(current);
        }
    }

    public int remove() {
        int popped = heap[FRONT];
        heap[FRONT] = heap[size--];

        minHeapify(FRONT);
        return popped;
    }

    public void print() {
        for (int i = 1; i <= size / 2; i++) {

            System.out.print(
                    " PARENT : " + heap[i]
                            + " LEFT CHILD : " + heap[2 * i]
                            + " RIGHT CHILD :" + heap[2 * i + 1]);
            System.out.println();
        }
    }

    public static void main(String[] arg) {

      
        System.out.println("The Min Heap is ");

   
        minHeap mHeap = new minHeap(15);

   
        mHeap.insert(5);
        mHeap.insert(3);
        mHeap.insert(17);
        mHeap.insert(10);
        mHeap.insert(84);
        mHeap.insert(19);
        mHeap.insert(6);
        mHeap.insert(22);
        mHeap.insert(9);

        mHeap.print();

       
        System.out.println("The Min val is "
                + mHeap.remove());
    }

}

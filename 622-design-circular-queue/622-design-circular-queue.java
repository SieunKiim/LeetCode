class MyCircularQueue {

    int[] Cqueue;
    int start;
    int end;
    int size;
    public MyCircularQueue(int k) {
        Cqueue = new int[k];
        start = 0;
        end = -1;
        size = k;
    }
    
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        if(end == size-1) end = -1;
        end += 1;
        Cqueue[end] = value;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        if(start == end){
            start = 0;
            end = -1;
        } else {
            if(start == size-1) start = 0;
            else start += 1;
        }
        return true;
    }
    
    public int Front() {
        if(isEmpty()) return -1;
        return Cqueue[start];
    }
    
    public int Rear() {
        if(isEmpty()) return -1;
        return Cqueue[end];
    }
    
    public boolean isEmpty() {
        if(start == 0 && end == -1){
            return true;
        }
        return false;
    }
    
    public boolean isFull() {
        if(start == 0 && end == size-1){
            return true;
        }
        if(start != 0 && end == start-1) return true;
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
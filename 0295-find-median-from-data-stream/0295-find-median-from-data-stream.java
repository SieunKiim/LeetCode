class MedianFinder {
    
    PriorityQueue<Integer> max = new PriorityQueue<>();
    PriorityQueue<Integer> min = new PriorityQueue<>((o1,o2) -> o2-o1);
    int smallSize = 0;
    int bigSize = 0;
    int mid;
    
    public void addNum(int num) {
        if (smallSize == 0) {
            mid = num;
            min.add(num);
            smallSize += 1;
            return;
        }
        if( mid < num){
            max.add(num);
            bigSize += 1;
        } else {
            min.add(num);
            smallSize += 1;
        }
        
        if(smallSize < bigSize){
            min.add(max.poll());
            bigSize -= 1;
            smallSize += 1;
        } else if (smallSize >= bigSize + 2){
            max.add(min.poll());
            smallSize -= 1;
            bigSize += 1;
        }
        mid = min.peek();
    }
    
    public double findMedian() {
        
        if((smallSize + bigSize) %2 == 0){
            return (mid + max.peek())/2.0;
        } else {
            return mid;
        }
    }
}

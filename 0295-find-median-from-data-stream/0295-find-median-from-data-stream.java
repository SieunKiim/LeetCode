class MedianFinder {
    ArrayList<Integer> arr = new ArrayList<>();
    int size= 0;
    int mid;

    public void addNum(int num) {
        if (size== 0) {
            arr.add(num);
            mid = num;
            size += 1;
            return;
        }
        if(mid<= num){
            int index = size-1;
            while(num < arr.get(index)){
                index -= 1;
            }
            if(index == size-1)
                {arr.add(num);}
            else
                {arr.add(index+1, num);}
        } else {
            int index = 0;
            while(num > arr.get(index)){
                index += 1;
            }
            arr.add(index, num);
        }
        size += 1;
    }
    
    public double findMedian() {
        int mid = (size - 1)/2;
        if(size %2 == 0){
            return (arr.get(mid) + arr.get(mid+1))/2.0;
        } else {
            return arr.get(mid);
        }
    }
}

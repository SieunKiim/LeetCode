class SmallestInfiniteSet {
    TreeSet<Integer> set;
    int smallest;

    public SmallestInfiniteSet() {
        set = new TreeSet<>();
        smallest = 1;
    }
    
    public int popSmallest() {
        if(set.isEmpty()){
            int temp = smallest;
            smallest++;
            return temp;
        } else{
            int result = set.first();
            set.remove(result);
            return result;
        }
    }
    
    public void addBack(int num) {
        if(!set.isEmpty() && num < set.first() ||  num < smallest){
            set.add(num);
        }
    }
}

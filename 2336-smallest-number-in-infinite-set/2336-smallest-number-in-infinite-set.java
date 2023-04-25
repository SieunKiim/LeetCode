class SmallestInfiniteSet {
    TreeSet<Integer> set;

    public SmallestInfiniteSet() {
        set = new TreeSet<>();
        for(int i = 1; i<= 1000; i++){
            set.add(i);
        }
    }
    
    public int popSmallest() {
        int result = set.first();
        set.remove(result);
        return result;
    }
    
    public void addBack(int num) {
        set.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
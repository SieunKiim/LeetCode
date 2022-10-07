class MyCalendarThree {

    TreeMap<Integer, Integer> bookList;
    
    public MyCalendarThree() {
        bookList = new TreeMap<>();
    }
    
    public int book(int start, int end) {
        bookList.put(start, bookList.getOrDefault(start, 0) + 1);
        bookList.put(end, bookList.getOrDefault(end, 0) - 1);
        int ongoing = 0, k = 0;
        for (int v : bookList.values())
            k = Math.max(k, ongoing += v);
        return k;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */
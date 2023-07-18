class LRUCache {

    int maxSize;
    LinkedHashMap<Integer, Integer> map;

    public LRUCache(int capacity) {
        maxSize = capacity;
        map = new LinkedHashMap<>(){
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            int temp = map.get(key);
            map.remove(key);
            map.put(key,temp);
        } 
        return map.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.remove(key);
            map.put(key,value);
        } else {
            if(map.size() == maxSize){

            }
            map.put(key,value);
        }
        // System.out.println("put" + map);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
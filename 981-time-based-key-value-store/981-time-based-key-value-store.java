class TimeMap {

    HashMap<String, TreeMap> map;
    
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> temp = map.getOrDefault(key, new TreeMap<>());
        temp.put(timestamp, value);
        map.put(key, temp);
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        TreeMap<Integer, String> temp = map.get(key);
        Integer fk = temp.floorKey(timestamp);
        if(fk != null)return temp.get(fk);
        else return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
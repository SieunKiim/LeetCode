class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for(String s : paths){
            String[] path = s.split(" ");
            
            String filePath = path[0] + "/";
            for(int i = 1; i< path.length; i++){
                String[] temp = path[i].split("\\(|\\)");
                String name = temp[0];
                String key = temp[1];
                ArrayList<String> temp2 = map.getOrDefault(key, new ArrayList<>());
                temp2.add(filePath+name);
                map.put(key,temp2);
            }
        }
        // System.out.println(map);
        for (ArrayList<String> s : map.values()) {
            if(s.size() > 1) result.add(s);
        }
        return result;
    }
}
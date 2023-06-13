class Solution {
    public int equalPairs(int[][] grid) {
        HashMap<String,Integer> colSet = new HashMap<>();
        HashMap<String,Integer> rowSet = new HashMap<>();

        int output = 0;
        for(int i = 0;i<grid.length;i++){
            ArrayList<String> t = new ArrayList<>();
            for(int n : grid[i]){
                t.add(String.valueOf(n));
            }
            String colTemp = String.join(",",t);
            // System.out.println(colTemp);
            colSet.put(colTemp, colSet.getOrDefault(colTemp, 0)+1);
            StringBuilder sb = new StringBuilder();
            for(int j = 0;j < grid.length;j++){
                sb.append(String.valueOf(grid[j][i])).append(",");
                
            }
            sb.deleteCharAt(sb.length() - 1);
            String rowTemp = sb.toString();
            rowSet.put(rowTemp, rowSet.getOrDefault(rowTemp, 0)+1);
        }

        // System.out.println(colSet);
        // System.out.println(rowSet);

        for(Map.Entry<String, Integer> entry : colSet.entrySet()){
            if(rowSet.containsKey(entry.getKey())){
                output += entry.getValue() * rowSet.get(entry.getKey());
            }
        }
        return output;
    }
}
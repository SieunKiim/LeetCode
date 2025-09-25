class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int hight = triangle.size();
        List<Integer> dp = new ArrayList<>();
        // Arrays.fill(arr, Integer.MAX_VALUE);
        for(int i =0 ;i<triangle.size();i++){
            List<Integer> row = triangle.get(i);
            List<Integer> replace = new ArrayList<>();
            for(int j = 0;j<row.size();j++){
                if(j == 0){
                    int first = 0;
                    if(i > 0){
                        first = dp.get(j);
                    }
                    replace.add(first + row.get(j));
                } else if (j == row.size()-1){
                    replace.add(dp.get(j-1) +row.get(j));
                } else {
                    int small = Math.min(dp.get(j), dp.get(j-1));
                    replace.add(small + row.get(j));
                }
            }
            dp = new ArrayList<>(replace);
        }
        int output = Integer.MAX_VALUE;
        for(int temp : dp){
            output = Math.min(output, temp);
        }
        return output;
    }


}
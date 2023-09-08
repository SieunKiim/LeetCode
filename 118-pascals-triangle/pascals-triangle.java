class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(1);
        output.add(first);
        for(int i = 2; i<=numRows;i++){
            List<Integer> temp = new ArrayList<>();
            for(int j = 0;j<i;j++){
                List<Integer> last = output.get(output.size()-1);
                int leftIndex = j-1;
                int rightIndex = j;
                int left = 0;
                int right = 0;
                if(j-1 >= 0){
                    left = last.get(leftIndex);
                }
                if(j < last.size()){
                    right = last.get(j);
                }
                temp.add(left+right);
            }
            output.add(temp);
        }
        return output;
    }
}
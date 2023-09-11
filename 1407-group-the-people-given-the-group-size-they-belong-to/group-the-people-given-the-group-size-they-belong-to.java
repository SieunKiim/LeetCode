class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        int n = groupSizes.length;
        List<List<Integer>> output = new ArrayList<>();
        boolean[] used = new boolean[n];

        for(int i = 1; i<=n;i++){
            
            List<Integer>temp = new ArrayList<>();
            for(int j = 0; j<n;j++){
                if(used[j] == false && groupSizes[j] == i){
                    temp.add(j);
                    used[j] = true;
                }
            }
            if(temp.size() == 0){
                continue;
            }

            List<Integer>temptemp = new  ArrayList<>();
            for(int k = 0; k<temp.size();k++){
                temptemp.add(temp.get(k));
                if((k+1)%i == 0){
                    output.add(temptemp);
                    temptemp = new ArrayList<>();
                }
            }
        }

        System.out.println(output);

        return output;
    }
}
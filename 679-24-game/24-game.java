class Solution {
    private static final double EPSILON = 1e-6;

    public boolean judgePoint24(int[] cards) {
        List<Double> nums = new ArrayList<>();
        for (int card : cards) {
            nums.add((double) card);
        }

        return dfs(nums);
    }

    private boolean dfs(List<Double> arr){
        if(arr.size() == 1){
            System.out.println(arr.get(0));
            return Math.abs(arr.get(0) - 24) < EPSILON;
        }

        
        for(int i = 0; i<arr.size(); i++){
            for(int j = 0; j<arr.size(); j++){
                if(i == j) continue;
                List<Double> next = new ArrayList<>();
                double a = arr.get(i);
                double b= arr.get(j);
                for(int k = 0; k<arr.size(); k ++){
                    if(k != i && k != j) next.add(arr.get(k));
                }

                next.add(a+b);
                if(dfs(next))return true;
                next.remove(next.size()-1);

                next.add(a-b);
                if(dfs(next))return true;
                next.remove(next.size()-1);

                next.add(a*b);
                if(dfs(next))return true;
                next.remove(next.size()-1);

                if(Math.abs(b) > EPSILON){
                    next.add(a/b);
                    if(dfs(next))return true;
                    next.remove(next.size()-1);
                }
            }
        }
        return false;
    }
}
class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        if(n<2) return n;
        HashMap<Integer, Integer> table = new HashMap<>();
        int left = 0;
        table.put(fruits[0],1);
        int output = 0;
        for(int i = 1; i<n ;i++){
            table.put(fruits[i], table.getOrDefault(fruits[i],0)+1);
            while(table.size() > 2){
                Integer temp = table.get(fruits[left]);
                if(temp-1 == 0) {
                    table.remove(fruits[left]);
                    left += 1;
                    break;
                }
                table.put(fruits[left], temp - 1);
                left += 1;
            }
            int sum = 0;
            for(int value : table.values()){
                sum += value;
            }
            output = Math.max(output, sum);
        }
        return output;
    }
}
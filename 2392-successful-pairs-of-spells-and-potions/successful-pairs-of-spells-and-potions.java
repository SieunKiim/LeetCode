class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = potions.length;
        Arrays.sort(potions);
        int[] output = new int[spells.length];
        for(int i= 0;i<spells.length;i++){
            
            int index = getIndex(potions, ((success + 0.0)/spells[i]));
            // System.out.println("index : "+ index);
            
            output[i] = Math.max(0, n-index);
        }
        return output;
    }

    public int getIndex(int[] arr, double target){
        if(arr[arr.length-1] < target){
            return arr.length;
        }
        
        int left = 0;
        int right = arr.length-1;
        while(left<right){
            int mid = (left + right)/2;
            double midVal = arr[mid]+0.0;
            if(midVal< target){
                left = mid+1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
}
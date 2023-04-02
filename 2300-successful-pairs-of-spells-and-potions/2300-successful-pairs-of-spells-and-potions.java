class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = potions.length;
        int[] output = new int[spells.length];
        int outputIndex = 0;
        Arrays.sort(potions);
        System.out.println(Arrays.toString(potions));
        // System.out.println("전체 길이 : "+ n);
        for(int spell : spells){
            int target = (int) Math.ceil((double)success/Long.valueOf(spell));
            // int index = Arrays.binarySearch(potions, target);
            int index = lowerBound(target, potions, 0,n);
            // System.out.println("target : " + target + " index : " +index);
            output[outputIndex] = (n-index+1);
            // if(output[outputIndex] != 0) output[outputIndex] += 1;
            outputIndex +=1;
        }
        return output;
    }
    
    public int lowerBound(int target, int[] potions, int start, int end){
        while(start<end){
            int mid = (start+end)/2;
            if(potions[mid] < target){
                start = mid+1;
            } else{
                end = mid;
            }
        }
        return start+1;
    }
}
class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
		TreeMap<Long, Integer> map = new TreeMap<>();
        map.put(Long.MAX_VALUE, potions.length);
		for (int i = potions.length - 1; i >= 0; i--) {
			map.put((long) potions[i], i);
		}
		for (int i = 0; i < spells.length; i++) {
            long need = (success + spells[i] - 1) / spells[i];
			spells[i] = potions.length - map.ceilingEntry(need).getValue();
		}
		return spells;
        // int n = potions.length;
        // int[] output = new int[spells.length];
        // int outputIndex = 0;
        // Arrays.sort(potions);
        // System.out.println(Arrays.toString(potions));
        // for(int spell : spells){
        //     int target = (int) Math.ceil((double)success/Long.valueOf(spell));
        //     int index = lowerBound(target, potions, 0,n);
        //     output[outputIndex] = (n-index+1);
        //     outputIndex +=1;
        // }
        // return output;
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
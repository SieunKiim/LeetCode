class Solution {
    private void countingSort(int[] arr) {
        HashMap<Integer,Integer> counts = new HashMap<>();
        int minVal = arr[0], maxVal = arr[0];
        
        for (int i = 0; i < arr.length; i++) {
            minVal = Math.min(minVal, arr[i]);
            maxVal = Math.max(maxVal, arr[i]);
            counts.put(arr[i], counts.getOrDefault(arr[i], 0) + 1);
        }
        
        int index = 0;
        for (int val = minVal; val <= maxVal; ++val) {
            while (counts.getOrDefault(val, 0) > 0) {
                arr[index] = val;
                index += 1;
                counts.put(val, counts.get(val) - 1);
            }
        }
    }

    public int[] sortArray(int[] nums) {
        countingSort(nums);
        return nums;
    }
}
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<Integer>();
        int left = 0;
        int right = arr.length - 1;
        
        while(right - left >= k){
            int distLeft = Math.abs(arr[left] - x);
            int distRight = Math.abs(arr[right] - x);
            
            if(distLeft <= distRight)
                right--;
            else
                left++;
        }
        while(left <= right){
            list.add(arr[left]);
            left+=1;
        }
            
        
        
        return list; 
    }
}
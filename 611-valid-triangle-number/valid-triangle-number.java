class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        // HashSet<Tri> set = new HashSet<>();
        for(int i = 0; i< nums.length;i++){
            for(int j = i+1; j< nums.length; j++){
                int temp = nums[i] + nums[j];
                int index = getIndex(nums, temp)-1;
                // System.out.println("i : "+i+ " , j : " + j);
                // System.out.println("indeix : "+index);
                if(index > j){
                    count +=(index-j);
                }
            }
        }
        // System.out.println(set);
        return count;
    }

    public int getIndex(int[] arr, int x){
        int left = 0, right = arr.length; // right는 arr.length까지 가능
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] < x) {
                left = mid + 1; // x보다 작은 값은 버림
            } else {
                right = mid;    // x 이상일 때는 mid 포함 가능
            }
        }
        return left; // 또는 right (둘이 같음)
    }
}
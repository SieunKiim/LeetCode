class Solution {
    public int search(int[] nums, int target) {

        // 1. 로테이션 갯수 구하기
        int n = nums.length;
        int left = 0;
        int right = nums.length-1;
        int rotatedIndex = n;
        for(int i =1;i<nums.length;i++){
            if(nums[i] < nums[i-1]) {
                rotatedIndex = i;
                break;
            }
        }

        // 2. target 넘버 인덱스 구하기
        if(target >= nums[0]){
            left = 0;
            right = rotatedIndex-1;
        } else {
            left = rotatedIndex;
            right = n-1;
        }

        if (left > right) return -1;

        while(left < right){
            int mid = (left + right)/2;
            if(nums[mid] == target){
                return mid;
            }

            if(nums[mid] < target){
                left = mid+1;
            } else {
                right = mid;
            }
        }
        if(nums[left] != target)return -1;
        return left;
    }
}
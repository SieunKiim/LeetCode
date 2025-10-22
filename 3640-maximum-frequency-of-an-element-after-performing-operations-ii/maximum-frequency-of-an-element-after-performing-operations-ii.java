class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Arrays.sort(nums);
        int n = nums.length;
        
        // 좌표 압축: 중요한 목표값들만 수집
        Set<Integer> targetSet = new HashSet<>();
        for (int num : nums) {
            targetSet.add(num);
            targetSet.add(num - k);
            targetSet.add(num + k);
        }
        
        List<Integer> targets = new ArrayList<>(targetSet);
        Collections.sort(targets);
        
        int maxFreq = 0;
        
        for (int target : targets) {
            // target과 정확히 같은 원소 개수
            int exact = countExact(nums, target);
            
            // [target-k, target+k] 범위의 원소 개수
            int inRange = countInRange(nums, target - k, target + k);
            
            // 이미 같은 값 + 변환 가능한 개수(최대 numOperations)
            int freq = Math.min(exact + numOperations, inRange);
            maxFreq = Math.max(maxFreq, freq);
        }
        
        return maxFreq;
    }
    
    private int countExact(int[] nums, int target) {
        int left = lowerBound(nums, target);
        int right = upperBound(nums, target);
        return right - left;
    }
    
    private int countInRange(int[] nums, int low, int high) {
        int left = lowerBound(nums, low);
        int right = upperBound(nums, high);
        return right - left;
    }
    
    private int lowerBound(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    
    private int upperBound(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
class Solution {
    public int numberOfBeams(String[] bank) {
        List<Integer> arr = new ArrayList<>();
        for(String s : bank){
            int count = getDeviceCount(s);
            arr.add(count);
        }


        int left = 0;
        int right = arr.size()-1;
        while(left <= right && !(arr.get(left) != 0 && arr.get(right)!= 0)){
            if(arr.get(left) == 0){
                left += 1;
            }
            if(arr.get(right) == 0){
                right -= 1;
            }
        }

        int output = 0;
        int index = left;
        if(arr.size() <= 1) return 0;
        int lastVal = arr.get(left);
        index +=1;
        while(index <= right){
            int now = arr.get(index);
            if (arr.get(index) != 0) {
                output += lastVal * now;
                lastVal = now;
            }
            index += 1;
        }
        return output;
    }

    public int getDeviceCount(String s){
        int count = 0;
        for(int i = 0; i < s.length();i++){
            char now = s.charAt(i);
            if(now == '1'){
                count += 1;
            }
        }
        return count;
    }
}
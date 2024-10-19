import java.util.*;

class Solution {
    public int maximumSwap(int num) {
        char[] arr = (num + "").toCharArray();
        char[] sorted = (num + "").toCharArray();
        Arrays.sort(sorted);
        char[] output = new char[arr.length];
        
        for(int i = 0 ;i<arr.length; i++){
            if(sorted[arr.length-1-i] != arr[i]){
                int index = Integer.MAX_VALUE;
                for(int k = arr.length-1; k> i; k--){
                    if(sorted[arr.length-1-i] == arr[k]){
                        index = k;
                        break;
                    }
                }
                arr[index] = arr[i];
                arr[i] = sorted[arr.length-1-i];
                
                break;
            }
        }
        // System.out.println(Arrays.toString(arr));
        String str = new String(arr);
        return Integer.parseInt(str);
    }
}
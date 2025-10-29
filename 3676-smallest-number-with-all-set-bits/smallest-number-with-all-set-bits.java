class Solution {
    public int smallestNumber(int n) {
        String str = Integer.toBinaryString(n);
        char[] arr = str.toCharArray();
        // System.out.println(Arrays.toString(arr));
        for(int i = arr.length-1;i >= 0;i--){
            if(arr[i] == '0'){
                // System.out.println(i);
                n+= Math.pow(2, arr.length-1 - i);
            }
        }
        return n;
    }
}
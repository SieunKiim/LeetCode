class Solution {
    public boolean hasSameDigits(String s) {
        char[] arr= s.toCharArray();
        int n = s.length();
        while(n > 2){
            for(int i = 1;i<n;i++){
                arr[i-1] = (char)(((arr[i]-'0') + (arr[i-1]-'0'))%10 + '0');
                // System.out.println(((arr[i]-'0') + (arr[i-1]-'0'))%10 + '0');
                
            }
            n-=1;
        }
        return arr[0] == arr[1];
    }
}
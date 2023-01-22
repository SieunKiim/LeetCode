class Solution {
    List<List<String>> output;
    char[] preset;
    int n;
    
    public List<List<String>> partition(String s) {
        output = new ArrayList<>();
        preset = s.toCharArray();
        n = s.length();
        findString(0, new ArrayList<>());
        return output;
    }
    
    public void findString(int start, List<String> arr){
        if(start == n){
            output.add(new ArrayList<>(arr));
            return;
        }
        int i = 1;
        while(start + i <= n){
            String temp = String.valueOf(Arrays.copyOfRange(preset, start, start+i));
            if(checkPalindrome(temp)){
                arr.add(temp);
                findString(start+i, arr);
                arr.remove(arr.size()-1);
            }
            i+=1;
        }
    }
    
    public boolean checkPalindrome(String s){
        int len = s.length();
        for(int i = 0; i< len/2 ; i++){
            if(s.charAt(i) != s.charAt(len-1-i)) return false;
        }
        return true;
    }
}
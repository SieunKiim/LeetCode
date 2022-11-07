class Solution {
    public int maximum69Number (int num) {
        String n = String.valueOf(num);
        char[] arr = n.toCharArray();
        for(int i = 0; i< arr.length; i++){
            if(arr[i] == '6'){
                arr[i] = '9';
                break;
            }
        }
        String s = new String(arr);
        
        return Integer.parseInt(s);
    }
}
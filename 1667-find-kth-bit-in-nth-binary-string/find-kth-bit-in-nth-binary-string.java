class Solution {
    public char findKthBit(int n, int k) {
        StringBuilder sb = new StringBuilder();
        sb.append("0");

        for(int i = 0; i<n-1;i++){
            sb = proccess(sb);
        }
        return sb.charAt(k-1);
    }

    private StringBuilder proccess(StringBuilder sb){
        StringBuilder output = new StringBuilder(sb.toString());
        output.append("1");
        sb = sb.reverse();
        for(int i = 0; i<sb.length(); i++){
            char temp = sb.charAt(i);
            if(temp == '0'){
                output.append('1');
            } else {
                output.append('0');
            }
        }
        // System.out.println(output.toString());
        return output;
    }
}
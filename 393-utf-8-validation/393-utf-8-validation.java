class Solution {
    public boolean validUtf8(int[] data) {
        int left=0;
        for(int d :data){
            int ch = check(d);
            if (ch > 4) return false;
            System.out.println(ch+"개수");
            if(ch != 1 && ch != 0){
                if(left != 0) return false;
                left = ch-1;
            }
            
            if(ch == 0 && left != 0) return false;
            if(ch == 1) left -=1;
            
            // if(left != 0 && ch == 1){
            //     left -= 1;
            // }
            if(left < 0) return false;
            
        }
        if (left !=0) return false;
        System.out.println(left);
        return true;
    }
    public int check(int num){
        String binary = String.format("%08d", Integer.parseInt(Integer.toBinaryString(num)));
        // System.out.println(binary);
        int count = 0;
        for(int i = 0; i<binary.length(); i++){
            if(binary.charAt(i)=='1'){
                count += 1;
            } else {
                break;
            }
        }
        return count;
    }
}
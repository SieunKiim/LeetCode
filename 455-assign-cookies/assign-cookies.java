class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int index = 0;
        while(count < g.length && index < s.length){
            if(g[count] <= s[index]){
                count += 1;
            }
            index += 1;
        }
        return count;
    }
}
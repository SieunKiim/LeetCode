class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int rx = Math.min(ax2, bx2);
        int ry = Math.min(ay2, by2);
        int lx = Math.max(ax1, bx1);
        int ly = Math.max(ay1, by1);
        
        if(rx-lx <=0 || ry - ly <=0 ){
            return (ax2-ax1) * (ay2-ay1) + (bx2-bx1)*(by2-by1);
        }
        return (ax2-ax1) * (ay2-ay1) + (bx2-bx1)*(by2-by1) - Math.abs(rx-lx) * Math.abs(ry-ly);
    }
}
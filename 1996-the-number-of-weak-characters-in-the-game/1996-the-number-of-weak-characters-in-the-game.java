class Solution {
    
//     class Champion implements Comparable<Champion>{
//         int off;
//         int def;
        
//         public Champion(int off, int def){
//             this.off = off;
//             this.def = def;
//         }
        
//         @Override
//         public int compareTo(Champion o){
//             if(this.off == o.off) return this.def - o.def;
//             return this.off-o.off;
//         }
//     }
    
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (a, b) -> (a[0] == b[0]) ? b[1] - a[1] : a[0] - b[0]);
        for (int i = 0; i < properties.length; i++) {
            System.out.println(Arrays.toString(properties[i]));
        }
        int count = 0;
        int n = properties.length;
//        int[] last = properties[0];
        int last = properties[n-1][1];
        for (int i = n-2; i >=0; i--) {
            if (properties[i][1] < last) {
                count+= 1;
            } else {
                last = properties[i][1];
            }
        }
        return count;
    }
}
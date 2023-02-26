class Solution {
    public int minDistance(String word1, String word2) {
//         HashMap<Character, Integer> word1Map = new HashMap<>();
//         HashMap<Character, Integer> word2Map = new HashMap<>();
        
//         for(int i =0; i<word1.length(); i++){
//             word1Map.put(word1.charAt(i),word1Map.getOrDefault(word1.charAt(i), 0)+1);
//         }
        
//         for(int i =0; i<word2.length(); i++){
//             word2Map.put(word2.charAt(i),word2Map.getOrDefault(word2.charAt(i), 0)+1);
//         }
        
//         System.out.println(word1Map);
//         System.out.println(word2Map);
        
        int n = word1.length();
        int m = word2.length();
        int[][] map = new int[n+1][m+1];
        for(int i =0; i<=n ;i++){
            map[i][0] = i;
        }
        for(int j = 0; j<=m; j++){
            map[0][j] = j;
        }
        
        for(int i =1 ; i<=n; i++){
            for(int j = 1; j<=m;j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)) map[i][j] = map[i-1][j-1];
                else{
                    map[i][j] = Math.min(map[i][j-1], Math.min(map[i-1][j], map[i-1][j-1]))+1;
                }
            }
        }
        
        
        
        return map[n][m];
    }
}
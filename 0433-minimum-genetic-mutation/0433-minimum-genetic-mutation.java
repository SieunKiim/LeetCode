class Solution {
     public int minMutation(String start, String end, String[] bank) {
        Queue<String> queue = new LinkedList<>();
        Set<String> seen = new HashSet<>();
        queue.add(start);
        seen.add(start);
        
        int steps = 0;
        
        while (!queue.isEmpty()) {
            int nodesInQueue = queue.size();
            for (int j = 0; j < nodesInQueue; j++) {
                String node = queue.remove();
                if (node.equals(end)) {
                    return steps;
                }

                for (char c: new char[] {'A', 'C', 'G', 'T'}) {
                    for (int i = 0; i < node.length(); i++) {
                        String neighbor = node.substring(0, i) + c + node.substring(i + 1);
                        if (!seen.contains(neighbor) && Arrays.asList(bank).contains(neighbor)) {
                            queue.add(neighbor);
                            seen.add(neighbor);
                        }
                    }
                }
            }
            
            steps++;
        }
        
        return -1;
    }
//     String[] muts;
//     int n; 
//     String target;
//     public int minMutation(String start, String end, String[] bank) {
//         target = end;
//         n = bank.length;
//         muts = bank;
//         boolean[] used = new boolean[n];
//         int output = n+1;
//         for(int i = 0; i< n; i++){
//             if(bank[i].equals(end)){
//                 output = find(start, 0, used);
//                 if (output == n+1)
//                     output = -1;
//                 return output;
//             }
//         }
//         return -1;
//     }
    
//     public int find(String now, int count, boolean[] visited){
//         if(now.equals(target)) return 0;
//         if(count == n) return -1;
//         int result = n+1;
//         for(int i= 0; i< n; i++){
//             if(!visited[i] && checkValid(now, muts[i])){
//                 visited[i] = true;
//                 result = Math.min(find(muts[i], count+1, visited)+1, result);
//                 visited[i] = false;
//             }
//         }
//         return result;
//     }
    
//     public boolean checkValid(String a, String b){
//         int count = 0;
//         for(int i = 0; i< a.length(); i++){
//             if(a.charAt(i)!= b.charAt(i)) count += 1;
//         }
//         if(count == 1) return true; // 0일때도?
//         else return false;
//     }
}
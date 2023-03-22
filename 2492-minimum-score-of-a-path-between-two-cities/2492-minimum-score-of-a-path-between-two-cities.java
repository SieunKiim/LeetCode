class Solution {
    int[] parent;
    int[] minPaths;
    int output;
    public int minScore(int n, int[][] roads) {
        parent = new int[n+1];
        minPaths = new int[n+1];
        for(int i = 0; i<=n;i++){
            parent[i] = i;
            minPaths[i] = Integer.MAX_VALUE;
        }
        
        for(int[] road: roads){
            int index = union(road[0], road[1]);
            minPaths[index] = Math.min(minPaths[index], road[2]);
        }
        for(int i = 1; i<=n ; i++){
            int nextIndex = parent[i];
            if(nextIndex != parent[nextIndex]){
                parent[i] = parent[nextIndex];
            }
            minPaths[parent[nextIndex]] = Math.min(minPaths[i], minPaths[parent[nextIndex]]);
        }
        // System.out.println(Arrays.toString(parent));
        // System.out.println(Arrays.toString(minPaths));
        return minPaths[1];
    }
    
    public int getParent(int x){
        if(parent[x] == x) return x;
        minPaths[parent[x]] = Math.min(minPaths[x], minPaths[parent[x]]);
        return parent[x] = getParent(parent[x]);
    }
    
    public int union(int a, int b){
        int parentA = getParent(a);
        int parentB = getParent(b);
        
        if(parentA < parentB){
            parent[parentB] = parentA;
            return parentA;
        } else if(parentA > parentB){
            parent[parentA] = parentB;
            return parentB; 
        }
        return parentA;
    }
}